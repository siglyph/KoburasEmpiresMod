package net.kobura.koburasempires.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kobura.koburasempires.KoburasEmpiresMod;
import net.kobura.koburasempires.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup KOBURAS_EMPIRES_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KoburasEmpiresMod.MOD_ID, "koburas_empires"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.koburas_empires"))
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.SMITHING_ANVIL);
                        entries.add(ModItems.HAMMER);
                    }).build());


    public static void registerItemGroups() {
        KoburasEmpiresMod.LOGGER.info("Registering Item Groups for " + KoburasEmpiresMod.MOD_ID);
    }

}
