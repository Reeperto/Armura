package io.github.deegs79.armura.Mixin;

import io.github.deegs79.armura.Copper.RandomTickableItem;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.GameRules;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World {
    @Shadow
    @Final
    List<ServerPlayerEntity> players;

    protected ServerWorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef, DynamicRegistryManager registryManager, RegistryEntry<DimensionType> dimensionEntry, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long biomeAccess, int maxChainedNeighborUpdates) {
        super(properties, registryRef, registryManager, dimensionEntry, profiler, isClient, debugWorld, biomeAccess, maxChainedNeighborUpdates);
    }

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void itemRandomTick(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        var randomTickSpeed = getGameRules().get(GameRules.RANDOM_TICK_SPEED).get();

        if (randomTickSpeed > 0) {
            for (var player : players) {
                for (int j = 0; j < randomTickSpeed; ++j) {
                    if (random.nextInt(20) == 0) {
                        var inventory = player.getInventory();
                        for (int i = 0; i < inventory.size(); ++i) {
                            var item = inventory.getStack(i).getItem();
                            if (item instanceof RandomTickableItem) {
                                ((RandomTickableItem) item).randomTick(inventory.getStack(i), inventory, i, random);
                            }
                        }
                    }
                }
            }
        }
    }
}
