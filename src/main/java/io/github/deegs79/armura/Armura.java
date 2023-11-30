package io.github.deegs79.armura;

import io.github.deegs79.armura.Copper.CopperRegistrar;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Armura implements ModInitializer {

    public static final String ID = "armura";
    public static final Logger LOGGER = LoggerFactory.getLogger("Armura");
    @Override
    public void onInitialize() {
        CopperRegistrar.Register();
    }

    public static Identifier id(String name)
    {
        return new Identifier(ID, name);
    }
}
