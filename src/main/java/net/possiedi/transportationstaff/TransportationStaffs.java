package net.possiedi.transportationstaff;

import net.fabricmc.api.ModInitializer;

import net.possiedi.transportationstaff.item.ModItemGroups;
import net.possiedi.transportationstaff.item.ModItems;
import net.possiedi.transportationstaff.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransportationStaffs implements ModInitializer {
	public static final String MOD_ID = "transportation-staffs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModLootTableModifiers.modifyLootTables();

	}
}