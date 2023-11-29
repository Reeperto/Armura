package io.github.deegs79.armura;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum CopperToolMaterial implements ToolMaterial {

    UNOXIDIZED(2, 250, 4f),
    EXPOSED(2, 500, 4f),
    WEATHERED(2, 750, 4f),
    OXIDIZED(3, 1000, 5f);

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;

    CopperToolMaterial(
            int miningLevel,
            int itemDurability,
            float miningSpeed
    ) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
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
