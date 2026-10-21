package uk.co.hexeption.rsinfinitybooster.datagen;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

/**
 * RSInfinityBoosterDataGen
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 06:48 pm
 */
@EventBusSubscriber(modid = RSInfinityBooster.MODID)
public final class DataGenerators {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        var registries = event.getLookupProvider();
        
        var pack = generator.getVanillaPack(true);

        pack.addProvider(bindRegistries(RecipeGenerator.Runner::new, registries));
    }

    private static <T extends DataProvider> DataProvider.Factory<T> bindRegistries(
            BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> factory,
            CompletableFuture<HolderLookup.Provider> factories) {
        return packOutput -> factory.apply(packOutput, factories);
    }
}
