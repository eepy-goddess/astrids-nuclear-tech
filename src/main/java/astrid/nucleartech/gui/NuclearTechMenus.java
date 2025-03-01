package astrid.nucleartech.gui;

import astrid.nucleartech.main.AstridNuclearTech;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NuclearTechMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AstridNuclearTech.MODID);

    public static final RegistryObject<MenuType<?>> RTG = MENU_TYPES.register("rtg_menu", () -> {
        return new MenuType<RTGMenu>(RTGMenu::new, FeatureFlagSet.of());
    });

    public static void register(IEventBus bus) {
        MENU_TYPES.register(bus);

    }
}
