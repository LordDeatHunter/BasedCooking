package wraith.basedcooking.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import wraith.basedcooking.BasedCookingItemGroup;
import wraith.basedcooking.Utils;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {

    private static final HashMap<String, Item> ITEMS = new HashMap<String, Item>() {{
        put("wood_stove", new BlockItem(BlockRegistry.get("wood_stove"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("wicker_basket", new BlockItem(BlockRegistry.get("wicker_basket"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("cupboard", new BlockItem(BlockRegistry.get("cupboard"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("crate", new BlockItem(BlockRegistry.get("crate"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("paper_basket", new BlockItem(BlockRegistry.get("paper_basket"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("smooth_chocolate", new BlockItem(BlockRegistry.get("smooth_chocolate"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("chocolate_tiles", new BlockItem(BlockRegistry.get("chocolate_tiles"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("chocolate_pillar", new BlockItem(BlockRegistry.get("chocolate_pillar"), new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));

        put("bagel", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("chocolate", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("cooked_spider_meat", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("fried_egg", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("knife", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("knife_sharpener", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("pan", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("pot", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("raw_spider_meat", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));
        put("spider_bagel_burger", new Item(new FabricItemSettings().group(BasedCookingItemGroup.ITEM_GROUP)));

    }};

    public static void register() {
        for (Map.Entry<String, Item> block : ITEMS.entrySet()) {
            Registry.register(Registry.ITEM, Utils.ID(block.getKey()), block.getValue());
        }
    }

    public static Item get(String id) {
        return ITEMS.get(id);
    }
}
