package io.github.deegs79.armura.Copper;

import io.github.deegs79.armura.Armura;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;

import java.util.EnumMap;
public class CopperRegistrar {
    public static EnumMap<CopperState, CopperPickaxe> COPPER_PICKAXES = Util.make(new EnumMap<>(CopperState.class), (map) -> {
        map.put(CopperState.UNOXIDIZED, new CopperPickaxe(CopperToolMaterial.UNOXIDIZED, 1, 2.8f, new FabricItemSettings()));
        map.put(CopperState.EXPOSED, new CopperPickaxe(CopperToolMaterial.EXPOSED, 1, 2.8f, new FabricItemSettings()));
        map.put(CopperState.WEATHERED, new CopperPickaxe(CopperToolMaterial.WEATHERED, 1, 2.8f, new FabricItemSettings()));
        map.put(CopperState.OXIDIZED, new CopperPickaxe(CopperToolMaterial.OXIDIZED, 1, 2.8f, new FabricItemSettings()));
    });

    public static EnumMap<CopperState, CopperArmorItem> COPPER_HELMETS = Util.make(new EnumMap<>(CopperState.class), (map) -> {
        map.put(CopperState.UNOXIDIZED, new CopperArmorItem(CopperArmorMaterial.UNOXIDIZED, ArmorItem.Type.HELMET, new FabricItemSettings()));
        map.put(CopperState.EXPOSED, new CopperArmorItem(CopperArmorMaterial.EXPOSED, ArmorItem.Type.HELMET, new FabricItemSettings()));
        map.put(CopperState.WEATHERED, new CopperArmorItem(CopperArmorMaterial.WEATHERED, ArmorItem.Type.HELMET, new FabricItemSettings()));
        map.put(CopperState.OXIDIZED, new CopperArmorItem(CopperArmorMaterial.OXIDIZED, ArmorItem.Type.HELMET, new FabricItemSettings()));
    });

    public static EnumMap<CopperState, CopperArmorItem> COPPER_LEGGINGS = Util.make(new EnumMap<>(CopperState.class), (map) -> {
        map.put(CopperState.UNOXIDIZED, new CopperArmorItem(CopperArmorMaterial.UNOXIDIZED, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
        map.put(CopperState.EXPOSED, new CopperArmorItem(CopperArmorMaterial.EXPOSED, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
        map.put(CopperState.WEATHERED, new CopperArmorItem(CopperArmorMaterial.WEATHERED, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
        map.put(CopperState.OXIDIZED, new CopperArmorItem(CopperArmorMaterial.OXIDIZED, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    });

    public static EnumMap<CopperState, CopperArmorItem> COPPER_CHESTPLATES = Util.make(new EnumMap<>(CopperState.class), (map) -> {
        map.put(CopperState.UNOXIDIZED, new CopperArmorItem(CopperArmorMaterial.UNOXIDIZED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
        map.put(CopperState.EXPOSED, new CopperArmorItem(CopperArmorMaterial.EXPOSED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
        map.put(CopperState.WEATHERED, new CopperArmorItem(CopperArmorMaterial.WEATHERED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
        map.put(CopperState.OXIDIZED, new CopperArmorItem(CopperArmorMaterial.OXIDIZED, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    });

    public static EnumMap<CopperState, CopperArmorItem> COPPER_BOOTS = Util.make(new EnumMap<>(CopperState.class), (map) -> {
        map.put(CopperState.UNOXIDIZED, new CopperArmorItem(CopperArmorMaterial.UNOXIDIZED, ArmorItem.Type.BOOTS, new FabricItemSettings()));
        map.put(CopperState.EXPOSED, new CopperArmorItem(CopperArmorMaterial.EXPOSED, ArmorItem.Type.BOOTS, new FabricItemSettings()));
        map.put(CopperState.WEATHERED, new CopperArmorItem(CopperArmorMaterial.WEATHERED, ArmorItem.Type.BOOTS, new FabricItemSettings()));
        map.put(CopperState.OXIDIZED, new CopperArmorItem(CopperArmorMaterial.OXIDIZED, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    });

    public static void Register() {
        Armura.LOGGER.info("Registering Armura Copper Items");
        String name;

        for (CopperState state : CopperState.values()) {
            name = state.getName();

            if (!name.isEmpty())
            {
                name = name + "_";
            }

            Registry.register(Registries.ITEM, Armura.id(name + "copper_pickaxe"), COPPER_PICKAXES.get(state));

            Registry.register(Registries.ITEM, Armura.id(name + "copper_helmet"), COPPER_HELMETS.get(state));
            Registry.register(Registries.ITEM, Armura.id(name + "copper_chestplate"), COPPER_CHESTPLATES.get(state));
            Registry.register(Registries.ITEM, Armura.id(name + "copper_leggings"), COPPER_LEGGINGS.get(state));
            Registry.register(Registries.ITEM, Armura.id(name + "copper_boots"), COPPER_BOOTS.get(state));
        }
    }
}
