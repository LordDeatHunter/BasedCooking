package wraith.basedcooking;

import net.minecraft.util.Identifier;

public class Utils {

    public static Identifier ID(String path) {
        return new Identifier(BasedCooking.MOD_ID, path);
    }

}
