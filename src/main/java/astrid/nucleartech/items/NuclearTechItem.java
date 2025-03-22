package astrid.nucleartech.items;

import astrid.nucleartech.main.NuclearTechItems;
import astrid.nucleartech.main.NuclearTechTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class NuclearTechItem extends Item {
    public NuclearTechItem(Item.Properties prop) {
        super(prop);
    }

    public NuclearTechItem setModdedCreativeTab(CreativeModeTab tab) {
        NuclearTechTabs.MODDED_CREATIVE_TAB_ITEMS.put(tab, this);
        return this;
    }
    public NuclearTechItem setVanillaCreativeTab(CreativeModeTab tab) {
        NuclearTechTabs.VANILLA_CREATIVE_TAB_ITEMS.put(tab, this);
        return this;
    }
}
