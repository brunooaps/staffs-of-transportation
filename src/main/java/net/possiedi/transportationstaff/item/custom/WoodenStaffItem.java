package net.possiedi.transportationstaff.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WoodenStaffItem extends Item {
    public WoodenStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
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
        if (!world.isClient) {

            double yawRad = Math.toRadians(user.getYaw());
            double pitchRad = Math.toRadians(user.getPitch());

            double x = -Math.sin(yawRad) * Math.cos(pitchRad);
            double y = -Math.sin(pitchRad);
            double z = Math.cos(yawRad) * Math.cos(pitchRad);

            double distance = 7;
            double teleportX = user.getX() + x * distance;
            double teleportY = user.getY() + y * distance;
            double teleportZ = user.getZ() + z * distance;

            user.teleport(teleportX, teleportY, teleportZ);
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
