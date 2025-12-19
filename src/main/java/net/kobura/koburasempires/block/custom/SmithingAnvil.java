package net.kobura.koburasempires.block.custom;

import net.kobura.koburasempires.entity.ModEntities;
import net.kobura.koburasempires.entity.custom.BanditEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import javax.swing.text.html.parser.Entity;
import java.util.Objects;

public class SmithingAnvil extends Block {

    public SmithingAnvil(Settings settings) {
        super(settings);
    }




    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {

        if (world instanceof ServerWorld serverWorld){
            for (int i = 0; i < 10; i++)
                ModEntities.BANDIT.spawn(serverWorld, pos, SpawnReason.EVENT);
        }

        super.onDestroyedByExplosion(world, pos, explosion);
    }
}