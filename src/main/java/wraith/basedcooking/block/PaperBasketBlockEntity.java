package wraith.basedcooking.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import wraith.basedcooking.BasedCooking;
import wraith.basedcooking.registry.BlockEntityRegistry;
import wraith.basedcooking.registry.BlockRegistry;

public class PaperBasketBlockEntity extends CustomBarrelBlockEntity{

    public PaperBasketBlockEntity() {
        super(BlockEntityRegistry.PAPER_BASKET);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container." + BasedCooking.MOD_ID + ".paper_basket");
    }

    @Override
    public void tick() {
        if (this.viewerCount > 0) {
            this.scheduleUpdate();
        } else {
            BlockState blockState = this.getCachedState();
            if (!blockState.isOf(BlockRegistry.get("paper_basket"))) {
                this.markRemoved();
                return;
            }

            boolean bl = blockState.get(CustomBarrelBlock.OPEN);
            if (bl) {
                this.playSound(blockState, SoundEvents.BLOCK_BARREL_CLOSE);
                this.setOpen(blockState, false);
            }
        }
    }

}
