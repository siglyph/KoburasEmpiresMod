package net.kobura.koburasempires.block;

import net.kobura.koburasempires.KoburasEmpiresMod;
import net.kobura.koburasempires.block.custom.SmithingAnvil;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block STEEL_BLOCK = registerBlock("steel_block", new Block(AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.NETHERITE).strength(1f).requiresTool()));

    public static final Block SMITHING_ANVIL = registerBlock("smithing_anvil", new SmithingAnvil(AbstractBlock.Settings.create()
            .strength(1f).requiresTool()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(KoburasEmpiresMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(KoburasEmpiresMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        KoburasEmpiresMod.LOGGER.info("Registering Mod Blocks for " + KoburasEmpiresMod.MOD_ID);
    }

}
