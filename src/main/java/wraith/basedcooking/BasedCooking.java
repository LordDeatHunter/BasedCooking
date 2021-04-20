package wraith.basedcooking;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wraith.basedcooking.registry.BlockRegistry;
import wraith.basedcooking.registry.ItemRegistry;

public class BasedCooking implements ModInitializer {

    public static final String MOD_ID = "basedcooking";
    public static final String MOD_NAME = "Based Cooking";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        BlockRegistry.register();
        ItemRegistry.register();
        LOGGER.info("[" + MOD_NAME + "] has been initiated.");
    }

}
