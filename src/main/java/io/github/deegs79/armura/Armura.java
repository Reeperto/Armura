package io.github.deegs79.armura;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Armura implements ModInitializer {

    public static final String ID = "armura";

    public static final ToolItem UNOXIDIZED_COPPER_PICKAXE = new PickaxeItem(CopperToolMaterial.UNOXIDIZED, 1, 2.8f, new FabricItemSettings());
    public static final ToolItem EXPOSED_COPPER_PICKAXE = new PickaxeItem(CopperToolMaterial.EXPOSED, 1, 2.8f, new FabricItemSettings());
    public static final ToolItem WEATHERED_COPPER_PICKAXE = new PickaxeItem(CopperToolMaterial.WEATHERED, 1, 2.8f, new FabricItemSettings());
    public static final ToolItem OXIDIZED_COPPER_PICKAXE = new PickaxeItem(CopperToolMaterial.OXIDIZED, 1, 2.8f, new FabricItemSettings());

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, id("copper_pickaxe"), UNOXIDIZED_COPPER_PICKAXE);
        Registry.register(Registries.ITEM, id("exposed_copper_pickaxe"), EXPOSED_COPPER_PICKAXE);
        Registry.register(Registries.ITEM, id("weathered_copper_pickaxe"), WEATHERED_COPPER_PICKAXE);
        Registry.register(Registries.ITEM, id("oxidized_copper_pickaxe"), OXIDIZED_COPPER_PICKAXE);
    }

    public static Identifier id(String name)
    {
        return new Identifier(ID, name);
    }
}
