package uk.co.hexeption.rsinfinitybooster.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;
import uk.co.hexeption.rsinfinitybooster.setup.ModItems;

/**
 * RecipeGenerator
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 06:35 pm
 */
public class RecipeGenerator extends FabricRecipeProvider {
	public RecipeGenerator(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(packOutput, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
		return new RecipeProvider(provider, recipeOutput) {
			@Override
			public void buildRecipes() {
				shaped(RecipeCategory.MISC, ModItems.INFINITY_CARD)
					.pattern("ERE").pattern("RSR").pattern("NNN")
					.define('E', Items.ENDER_EYE)
					.define('R', com.refinedmods.refinedstorage.common.content.Items.INSTANCE.getRangeUpgrade())
					.define('S', Items.NETHER_STAR)
					.define('N', Items.NETHERITE_INGOT)
					.unlockedBy("has_item", has(Items.NETHERITE_INGOT))
					.save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(RSInfinityBooster.MODID, "infinity_card")));
				shaped(RecipeCategory.MISC, ModItems.DIMENSION_CARD)
					.pattern("RNR").pattern("NEN").pattern("RNR")
					.define('R', ModItems.INFINITY_CARD)
					.define('E', Items.ENDER_EYE)
					.define('N', Items.NETHER_STAR)
					.unlockedBy("has_item", has(ModItems.INFINITY_CARD))
					.save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(RSInfinityBooster.MODID, "dimension_card")));
			}
		};
	}

	@Override
	public String getName() {
		return "RSInfinityBooster Recipes";
	}
}
