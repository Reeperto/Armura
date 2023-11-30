package io.github.deegs79.armura.Copper;

import net.minecraft.util.Util;

import java.util.EnumMap;

public enum CopperState {
    UNOXIDIZED(""),
    EXPOSED("exposed"),
    WEATHERED("weathered"),
    OXIDIZED("oxidized");


    private static final EnumMap<CopperState, CopperState> NextState = Util.make(new EnumMap<>(CopperState.class), (map) -> {
        map.put(UNOXIDIZED, EXPOSED);
        map.put(EXPOSED, WEATHERED);
        map.put(WEATHERED, OXIDIZED);
        map.put(OXIDIZED, null);
    });
    private final String name;
    CopperState(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public CopperState nextState()
    {
        return NextState.get(this);
    }
}
