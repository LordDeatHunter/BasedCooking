package wraith.basedcooking.block;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import wraith.basedcooking.BasedCooking;
import wraith.basedcooking.registry.BlockEntityRegistry;
import wraith.basedcooking.registry.BlockRegistry;

public class CupboardBlockEntity extends FrontFacingBarrelBlockEntity {

    public CupboardBlockEntity() {
        super(BlockEntityRegistry.CUPBOARD);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container." + BasedCooking.MOD_ID + ".cupboard");
    }

    @Override
    public void tick() {
        if (this.viewerCount > 0) {
            this.scheduleUpdate();
        } else {
            BlockState blockState = this.getCachedState();
            if (!blockState.isOf(BlockRegistry.get("cupboard"))) {
                this.markRemoved();
                return;
            }

            boolean bl = blockState.get(FrontFacingBarrelBlock.OPEN);
            if (bl) {
                this.playSound(blockState, SoundEvents.BLOCK_BARREL_CLOSE);
                this.setOpen(blockState, false);
            }
        }
    }

}
