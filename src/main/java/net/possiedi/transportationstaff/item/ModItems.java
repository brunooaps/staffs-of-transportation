package net.possiedi.transportationstaff.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.possiedi.transportationstaff.TransportationStaffs;
import net.possiedi.transportationstaff.item.custom.StaffItem;

public class ModItems {

    public static final Item WOODEN_STAFF = registerItem("wooden_staff",
            new StaffItem(new FabricItemSettings().maxDamage(64), 7));

    public static final Item IRON_STAFF = registerItem("iron_staff",
            new StaffItem(new FabricItemSettings().maxDamage(128), 12));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TransportationStaffs.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TransportationStaffs.LOGGER.info("Registering Mod Items for " + TransportationStaffs.MOD_ID);
    }

}
