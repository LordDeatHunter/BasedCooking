package wraith.basedcooking.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;
import wraith.basedcooking.Utils;
import wraith.basedcooking.block.CupboardBlock;
import wraith.basedcooking.block.PaperBasketBlock;
import wraith.basedcooking.block.WickerBasketBlock;

import java.util.HashMap;
import java.util.Map;

public class BlockRegistry {

    private static final HashMap<String, Block> BLOCKS = new HashMap<String, Block>() {{
        put("wood_stove", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE).sounds(BlockSoundGroup.STONE).strength(3.5F).requiresTool()));
        put("wicker_basket", new WickerBasketBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.5F)));
        put("cupboard", new CupboardBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.5F)));
        put("crate", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.5F)));
        put("paper_basket", new PaperBasketBlock(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.5F)));
        put("smooth_chocolate", new Block(FabricBlockSettings.of(Material.CAKE, MaterialColor.BROWN).strength(0.5F)));
        put("chocolate_tiles", new Block(FabricBlockSettings.of(Material.CAKE, MaterialColor.BROWN).strength(0.5F)));
        put("chocolate_pillar", new Block(FabricBlockSettings.of(Material.CAKE, MaterialColor.BROWN).strength(0.5F)));
    }};

    public static void register() {
        for (Map.Entry<String, Block> block : BLOCKS.entrySet()) {
            Registry.register(Registry.BLOCK, Utils.ID(block.getKey()), block.getValue());
        }
    }

    public static Block get(String id) {
        return BLOCKS.get(id);
    }

}
