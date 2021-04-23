package wraith.basedcooking.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import wraith.basedcooking.BasedCooking;
import wraith.basedcooking.registry.BlockEntityRegistry;

public class CrateBlockEntity extends LootableContainerBlockEntity {

    protected DefaultedList<ItemStack> inventory;

    public CrateBlockEntity() {
        super(BlockEntityRegistry.CRATE);
        this.inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        return inventoryToTag(tag);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        inventoryFromTag(tag);
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
    protected Text getContainerName() {
        return new TranslatableText("container." + BasedCooking.MOD_ID + ".crate");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, this);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return player.squaredDistanceTo(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= 64D;
    }

    @Override
    public int size() {
        return 27;
    }

    public void inventoryFromTag(CompoundTag tag) {
        if (!this.deserializeLootTable(tag) && tag.contains("Items", 9)) {
            Inventories.fromTag(tag, this.inventory);
        }
    }

    public CompoundTag inventoryToTag(CompoundTag tag) {
        if (!this.serializeLootTable(tag)) {
            Inventories.toTag(tag, this.inventory, false);
        }
        return tag;
    }

}
