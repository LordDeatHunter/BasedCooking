package wraith.basedcooking.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class WickerBasketBlock extends CustomBarrelBlock {

    public WickerBasketBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new WickerBasketBlockEntity();
    }

}
