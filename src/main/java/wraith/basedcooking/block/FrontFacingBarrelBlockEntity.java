package wraith.basedcooking.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3i;
import wraith.basedcooking.BasedCooking;

public abstract class FrontFacingBarrelBlockEntity extends LootableContainerBlockEntity {

    protected DefaultedList<ItemStack> inventory;
    protected int viewerCount;

    public FrontFacingBarrelBlockEntity(BlockEntityType<?> blockEntityType) {
        super(blockEntityType);
        this.inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        if (!this.serializeLootTable(tag)) {
            Inventories.toTag(tag, this.inventory);
        }

        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(tag)) {
            Inventories.fromTag(tag, this.inventory);
        }

    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }


    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }

    @Override
    protected abstract Text getContainerName();

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }

    @Override
    public int size() {
        return 27;
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.viewerCount < 0) {
                this.viewerCount = 0;
            }

            ++this.viewerCount;
            BlockState blockState = this.getCachedState();
            boolean bl = blockState.get(FrontFacingBarrelBlock.OPEN);
            if (!bl) {
                this.playSound(blockState, SoundEvents.BLOCK_BARREL_OPEN);
                this.setOpen(blockState, true);
            }

            this.scheduleUpdate();
        }

    }

    public void scheduleUpdate() {
        this.world.getBlockTickScheduler().schedule(this.getPos(), this.getCachedState().getBlock(), 5);
    }

    public abstract void tick();

    @Override
    public void onClose(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.viewerCount;
        }

    }

    public void setOpen(BlockState state, boolean open) {
        this.world.setBlockState(this.getPos(), state.with(FrontFacingBarrelBlock.OPEN, open), 3);
    }

    public void playSound(BlockState blockState, SoundEvent soundEvent) {
        Vec3i vec3i = blockState.get(FrontFacingBarrelBlock.FACING).getVector();
        double d = (double)this.pos.getX() + 0.5D + (double)vec3i.getX() / 2.0D;
        double e = (double)this.pos.getY() + 0.5D + (double)vec3i.getY() / 2.0D;
        double f = (double)this.pos.getZ() + 0.5D + (double)vec3i.getZ() / 2.0D;
        this.world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
    }

}
