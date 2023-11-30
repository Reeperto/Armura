package io.github.deegs79.armura.Copper;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;

public interface RandomTickableItem {
    void randomTick(ItemStack stack, PlayerInventory inventory, int slot, Random random);
}
