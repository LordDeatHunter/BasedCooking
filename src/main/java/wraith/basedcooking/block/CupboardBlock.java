package wraith.basedcooking.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CupboardBlock extends FrontFacingBarrelBlock {

    public CupboardBlock(Settings settings) {
        super(settings);
    }

    @Override
    @Nullable
    public BlockEntity createBlockEntity(BlockView world) {
        return new CupboardBlockEntity();
    }

}
