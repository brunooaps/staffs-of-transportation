package net.possiedi.transportationstaff.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.possiedi.transportationstaff.TransportationStaffs;

public class ModItemGroups {

    public static final ItemGroup STAFF_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TransportationStaffs.MOD_ID, "staff"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.staff"))
                    .icon( () -> new ItemStack(ModItems.WOODEN_STAFF)).entries((displayContext, entries) -> {


                        //STAFFS OF TRANSPORTATION MOD
                        entries.add(ModItems.WOODEN_STAFF);

                    }).build());

    public static void registerItemGroups() {
        TransportationStaffs.LOGGER.info("Registering Item Groups for " + TransportationStaffs.MOD_ID);
    }
}
