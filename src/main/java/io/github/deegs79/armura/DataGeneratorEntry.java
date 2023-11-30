package io.github.deegs79.armura;

import io.github.deegs79.armura.Copper.CopperRegistrar;
import io.github.deegs79.armura.Copper.CopperState;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import java.nio.file.Path;

public class DataGeneratorEntry implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ArmuraItemModelGenerator::new);
        pack.addProvider(ArmuraLanguageGenerator::new);
    }

    private static class ArmuraItemModelGenerator extends FabricModelProvider {
        private ArmuraItemModelGenerator(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            // All Copper Items and Oxidation levels
            for (CopperState state : CopperState.values()) {
                // Tools
                itemModelGenerator.register(CopperRegistrar.COPPER_PICKAXES.get(state), Models.HANDHELD);

                // Armor
                itemModelGenerator.registerArmor(CopperRegistrar.COPPER_HELMETS.get(state));
                itemModelGenerator.registerArmor(CopperRegistrar.COPPER_CHESTPLATES.get(state));
                itemModelGenerator.registerArmor(CopperRegistrar.COPPER_LEGGINGS.get(state));
                itemModelGenerator.registerArmor(CopperRegistrar.COPPER_BOOTS.get(state));
            }
        }
    }

    private static class ArmuraLanguageGenerator extends FabricLanguageProvider {
        private ArmuraLanguageGenerator(FabricDataOutput dataGenerator) {
            super(dataGenerator, "en_us");
        }

        @Override
        public void generateTranslations(TranslationBuilder translationBuilder) {
            // Append existing translation file
            try {
                Path existingFilePath = FabricLoader.getInstance().getModContainer("armura").get().findPath("assets/armura/lang/en_us.manual.json").get();
                translationBuilder.add(existingFilePath);
            } catch (Exception e) {
                throw new RuntimeException("Failed to add existing language file!", e);
            }

            String name;

            for (CopperState state : CopperState.values()) {
                name = state.getName();

                if (!name.isEmpty())
                {
                    //noinspection ReassignedVariable
                    name = name.substring(0,1).toUpperCase() + name.substring(1) + " ";
                }

                translationBuilder.add(CopperRegistrar.COPPER_PICKAXES.get(state), name + "Copper Pickaxe");

                translationBuilder.add(CopperRegistrar.COPPER_HELMETS.get(state), name + "Copper Helmet");
                translationBuilder.add(CopperRegistrar.COPPER_CHESTPLATES.get(state), name + "Copper Chestplate");
                translationBuilder.add(CopperRegistrar.COPPER_LEGGINGS.get(state), name + "Copper Leggings");
                translationBuilder.add(CopperRegistrar.COPPER_BOOTS.get(state), name + "Copper Boots");
            }
        }
    }
}
