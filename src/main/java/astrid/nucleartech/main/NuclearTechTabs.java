package astrid.nucleartech.main;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NuclearTechTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AstridNuclearTech.MODID);

    public static final RegistryObject<CreativeModeTab> CHEMICALS = TABS.register("nucleartechchermicals", () -> {
        return CreativeModeTab.builder().title(Component.translatable("tabs.anucleartech.chemicals"))
                .icon(() -> NuclearTechItems.HYDRO_PEROXIDE.get().getDefaultInstance()).displayItems((params, output) -> {
                    output.accept(NuclearTechItems.HYDRO_PEROXIDE.get().getDefaultInstance());
                }).build();
    });

    public static final RegistryObject<CreativeModeTab> MACHINES = TABS.register("nucleartechmachines", () -> {
        return CreativeModeTab.builder().title(Component.translatable("tabs.anucleartech.machines"))
                .icon(() -> NuclearTechItems.RTG.get().getDefaultInstance()).displayItems((params, output) -> {
                    output.accept(NuclearTechItems.RTG.get().getDefaultInstance());
                }).build();
    });

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}
