package io.github.deegs79.armura.Copper;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.random.Random;

public class CopperPickaxe extends PickaxeItem implements RandomTickableItem {

    private final static int OXIDATION_TICK_RATE = 150;

    public CopperPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void randomTick(ItemStack stack, PlayerInventory inventory, int slot, Random random) {
        if (stack.isOf(CopperRegistrar.COPPER_PICKAXES.get(CopperState.OXIDIZED))) {
            return;
        }

        if (random.nextInt(OXIDATION_TICK_RATE) == 0)
        {
            var nbt = stack.getNbt();

            // TODO: Use a number to track the state and use a switch statement
            var new_item_stack = new ItemStack(CopperRegistrar.COPPER_PICKAXES.get(
                    ((CopperToolMaterial) getMaterial()).state.nextState()
            ));

            new_item_stack.setNbt(nbt);
            inventory.setStack(slot, new_item_stack);
        }
    }
}
