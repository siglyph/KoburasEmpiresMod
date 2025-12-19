package net.kobura.koburasempires.item.custom;

import net.kobura.koburasempires.block.ModBlocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;

public class HammerItem extends Item {

    public HammerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        if(!world.isClient()) {
            // If used on Smithing Anvil
            if (world.getBlockState(context.getBlockPos()).isOf(ModBlocks.SMITHING_ANVIL)) {
                // Break block
                world.breakBlock(context.getBlockPos(), true, context.getPlayer());

                // Play sound
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);

                // Damage hammer
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()), item ->
                        Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            }
        }
            return ActionResult.CONSUME;
    }
}
