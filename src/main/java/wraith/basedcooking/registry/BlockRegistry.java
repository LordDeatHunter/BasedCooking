package wraith.basedcooking.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.util.registry.Registry;
import wraith.basedcooking.Utils;

import java.util.HashMap;
import java.util.Map;

public class BlockRegistry {

    private static final HashMap<String, Block> BLOCKS = new HashMap<String, Block>() {{
        put("wood_stove", new Block(FabricBlockSettings.of(Material.STONE, MaterialColor.STONE)));
        put("wicker_basket", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN)));
        put("cupboard", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN)));
        put("crate", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN)));
        put("paper_basket", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN)));
        put("smooth_chocolate", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN)));
        put("chocolate_tiles", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN)));
        put("chocolate_pillar", new Block(FabricBlockSettings.of(Material.WOOD, MaterialColor.BROWN)));
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
