package net.possiedi.transportationstaff.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.possiedi.transportationstaff.TransportationStaffs;

public class ModSounds {
    public static final SoundEvent STAFF_TELEPORTATION_SOUND = registerSoundEvent("staff_teleportation_sound");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(TransportationStaffs.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        TransportationStaffs.LOGGER.info("Registering Sounds for " + TransportationStaffs.MOD_ID);
    }

}
