package net.possiedi.transportationstaff.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.possiedi.transportationstaff.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class WoodenStaffItem extends Item {
    public WoodenStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        ItemStack itemStack = user.getStackInHand(hand);
        itemStack.damage(1, user, (p) -> {
            p.sendToolBreakStatus(hand);
        });
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

            double yawRad = Math.toRadians(user.getYaw());
            double pitchRad = Math.toRadians(user.getPitch());

            double x = -Math.sin(yawRad) * Math.cos(pitchRad);
            double y = -Math.sin(pitchRad);
            double z = Math.cos(yawRad) * Math.cos(pitchRad);

            double distance = 7;
            double teleportX = user.getX() + x * distance;
            double teleportY = user.getY() + y * distance;
            double teleportZ = user.getZ() + z * distance;

        if (!world.isClient) {


            world.playSound(null, teleportX, teleportY, teleportZ, ModSounds.STAFF_TELEPORTATION_SOUND,
                    SoundCategory.AMBIENT, 1f, 1f);

            user.teleport(teleportX, teleportY, teleportZ);


            if (user instanceof PlayerEntity) {
                ((PlayerEntity) user).getItemCooldownManager().set(this, 50);
            }
        } else {
            spawnTeleportParticles(world, user.getX(), user.getY(), user.getZ(), 200);
            spawnTeleportParticles(world, teleportX, teleportY, teleportZ, 200);
        }
    }

    private void spawnTeleportParticles(World world, double x, double y, double z, int particleCount) {
        Random random = new Random();

        for (int i = 0; i < particleCount; i++) {
            double offsetX = (random.nextDouble() - 0.5) * 2.0;
            double offsetY = random.nextDouble() * 2.0;
            double offsetZ = (random.nextDouble() - 0.5) * 2.0;

            world.addParticle(ParticleTypes.PORTAL, x + offsetX, y + offsetY, z + offsetZ, 0, 0, 0);
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.transportation-staffs.wooden_staff.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
