package astrid.nucleartech.handler;

import astrid.nucleartech.client.screen.RTGScreen;
import astrid.nucleartech.gui.NuclearTechMenus;
import astrid.nucleartech.gui.RTGMenu;
import astrid.nucleartech.main.AstridNuclearTech;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AstridNuclearTech.MODID, bus = Mod.EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void client_setup(FMLClientSetupEvent event) {
        AstridNuclearTech.LOGGER.info("Client setup event reached");
        event.enqueueWork(() -> {
            MenuScreens.<RTGMenu, RTGScreen>register((MenuType<? extends RTGMenu>) NuclearTechMenus.RTG.get(), RTGScreen::new);
        });
    }
}
