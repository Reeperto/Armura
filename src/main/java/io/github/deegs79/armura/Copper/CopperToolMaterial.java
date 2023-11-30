package io.github.deegs79.armura.Copper;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum CopperToolMaterial implements ToolMaterial {

    UNOXIDIZED(CopperState.UNOXIDIZED,2, 250, 4f),
    EXPOSED(CopperState.EXPOSED,2, 500, 4f),
    WEATHERED(CopperState.WEATHERED,2, 750, 4f),
    OXIDIZED(CopperState.OXIDIZED,3, 1000, 5f);

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    public final CopperState state;

    CopperToolMaterial(
            CopperState state,
            int miningLevel,
            int itemDurability,
            float miningSpeed
    ) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.state = state;
    }

    @Override
    public int getDurability() {
        return itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public float getAttackDamage() {
        return 1.5f;
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }
}
