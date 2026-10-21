package uk.co.hexeption.rsinfinitybooster.item;

import com.refinedmods.refinedstorage.common.api.upgrade.AbstractUpgradeItem;
import com.refinedmods.refinedstorage.common.api.upgrade.UpgradeRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import uk.co.hexeption.rsinfinitybooster.RSInfinityBooster;

/**
 * InfinityCard
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 14/02/2021 - 05:15 pm
 */
public class InfinityCard extends AbstractUpgradeItem {
    private static final Component HELP = Component.translatable("item." + RSInfinityBooster.MODID + ".tooltip.infinity_card.help");

    public InfinityCard(final Item.Properties properties, final UpgradeRegistry registry) {
        super(properties, registry, HELP);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public long getEnergyUsage() {
        return RSInfinityBooster.SERVER_CONFIG.getInfinityCard().getEnergyUsage();
    }

}
