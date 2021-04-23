package wraith.basedcooking.block;

import net.minecraft.block.BlockState;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import wraith.basedcooking.BasedCooking;
import wraith.basedcooking.registry.BlockEntityRegistry;
import wraith.basedcooking.registry.BlockRegistry;

public class WickerBasketBlockEntity extends CustomBarrelBlockEntity {

    public WickerBasketBlockEntity() {
        super(BlockEntityRegistry.WICKER_BASKET);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container." + BasedCooking.MOD_ID + ".wicker_basket");
    }

    @Override
    public void tick() {
        if (this.viewerCount > 0) {
            this.scheduleUpdate();
        } else {
            BlockState blockState = this.getCachedState();
            if (!blockState.isOf(BlockRegistry.get("wicker_basket"))) {
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
