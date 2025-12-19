package net.kobura.koburasempires.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kobura.koburasempires.KoburasEmpiresMod;
import net.kobura.koburasempires.item.custom.HammerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new Item.Settings()));

    public static final Item HAMMER = registerItem("hammer", new HammerItem(new Item.Settings().maxDamage(10)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(KoburasEmpiresMod.MOD_ID, name), item);
    }

    private static void customIngredients(FabricItemGroupEntries entries){
        entries.add(STEEL_INGOT);
    }

    public static void registerModItems() {
        KoburasEmpiresMod.LOGGER.info("Registering Mod Items for " + KoburasEmpiresMod.MOD_ID);

        // Add item to ingredients tab in creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
