package wraith.basedcooking.registry;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import wraith.basedcooking.Utils;
import wraith.basedcooking.block.CrateBlockEntity;
import wraith.basedcooking.block.CupboardBlockEntity;
import wraith.basedcooking.block.PaperBasketBlockEntity;
import wraith.basedcooking.block.WickerBasketBlockEntity;

public class BlockEntityRegistry {

    public static final BlockEntityType<CupboardBlockEntity> CUPBOARD = BlockEntityType.Builder.create(CupboardBlockEntity::new, BlockRegistry.get("cupboard")).build(null);
    public static final BlockEntityType<PaperBasketBlockEntity> PAPER_BASKET = BlockEntityType.Builder.create(PaperBasketBlockEntity::new, BlockRegistry.get("paper_basket")).build(null);
    public static final BlockEntityType<WickerBasketBlockEntity> WICKER_BASKET = BlockEntityType.Builder.create(WickerBasketBlockEntity::new, BlockRegistry.get("wicker_basket")).build(null);
    public static final BlockEntityType<CrateBlockEntity> CRATE = BlockEntityType.Builder.create(CrateBlockEntity::new, BlockRegistry.get("crate")).build(null);

    public static void register() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Utils.ID("cupboard"), CUPBOARD);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Utils.ID("paper_basket"), PAPER_BASKET);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Utils.ID("wicker_basket"), WICKER_BASKET);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, Utils.ID("crate"), CRATE);
    }

}
