package uk.co.hexeption.rsinfinitybooster;

import com.refinedmods.refinedstorage.common.api.RefinedStorageApi;
import com.refinedmods.refinedstorage.common.api.upgrade.UpgradeItem;
import com.refinedmods.refinedstorage.common.upgrade.UpgradeDestinations;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import uk.co.hexeption.rsinfinitybooster.config.ServerConfig;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;
import net.neoforged.fml.config.ModConfig;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;

// The value here should match an entry in the META-INF/mods.toml file
public class RSInfinityBooster implements ModInitializer {
    public static final String MODID = "rsinfinitybooster";
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    @Override
    public void onInitialize() {
        ConfigRegistry.INSTANCE.register(MODID, ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());

        ModItems.register();
        registerTab();
        handleCommonSetup();
    }

    public static void registerTab() {
        CreativeModeTab tab = FabricCreativeModeTab.builder()
        .title(Component.translatable("item_group." + MODID + ".tab"))
        .icon(() -> new ItemStack(ModItems.INFINITY_CARD))
        .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.INFINITY_CARD);
            output.accept(ModItems.DIMENSION_CARD);
        })
        .build();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(MODID, "aebooster")), tab);
    }

    public static void handleCommonSetup() {
        RefinedStorageApi.INSTANCE.getUpgradeRegistry().forDestination(UpgradeDestinations.WIRELESS_TRANSMITTER).add(ModItems.INFINITY_CARD).add(ModItems.DIMENSION_CARD);
        RefinedStorageApi.INSTANCE.addWirelessTransmitterRangeModifier((upgradeState, range) -> {
            if (upgradeState.has((UpgradeItem)ModItems.INFINITY_CARD) || upgradeState.has((UpgradeItem)ModItems.DIMENSION_CARD)) {
                return Integer.MAX_VALUE;
            }

            return range;
        });
    }

}
