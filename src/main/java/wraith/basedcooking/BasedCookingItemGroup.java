package wraith.basedcooking;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import wraith.basedcooking.registry.BlockRegistry;

public class BasedCookingItemGroup {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(Utils.ID("based_cooking")).icon(() -> new ItemStack(BlockRegistry.get("wood_stove"))).build();

}
