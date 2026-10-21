package uk.co.hexeption.rsinfinitybooster.setup;

import com.refinedmods.refinedstorage.common.api.RefinedStorageApi;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.FontDescription.Resource;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.item.DimensionCard;
import uk.co.hexeption.rsinfinitybooster.item.InfinityCard;

/**
 * ModItems
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 07:26 pm
 */
public class ModItems {
	public static final ResourceKey<Item> INFINITY_CARD_RESOURCE_KEY = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(RSInfinityBooster.MODID, "infinity_card"));
	public static final ResourceKey<Item> DIMENSION_CARD_RESOURCE_KEY = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(RSInfinityBooster.MODID, "dimension_card"));

	public static final Item INFINITY_CARD = Registry.register(BuiltInRegistries.ITEM, INFINITY_CARD_RESOURCE_KEY, new InfinityCard(new Item.Properties().setId(INFINITY_CARD_RESOURCE_KEY), RefinedStorageApi.INSTANCE.getUpgradeRegistry()));
	public static final Item DIMENSION_CARD = Registry.register(BuiltInRegistries.ITEM, DIMENSION_CARD_RESOURCE_KEY, new DimensionCard(new Item.Properties().setId(DIMENSION_CARD_RESOURCE_KEY), RefinedStorageApi.INSTANCE.getUpgradeRegistry()));

	public static void register() {}
}
