package astrid.nucleartech.main;

import astrid.nucleartech.blockentities.NuclearTechBlockEntites;
import astrid.nucleartech.gui.NuclearTechMenus;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AstridNuclearTech.MODID)
public class AstridNuclearTech {
    public static final String MODID = "anucleartech";
    public static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public void common_setup(FMLCommonSetupEvent event) {
        LOGGER.info("CUTE MOD IS LOADING YIPPEE :3");
    }

    public AstridNuclearTech(FMLJavaModLoadingContext ctx) {
        IEventBus bus = ctx.getModEventBus();

        NuclearTechBlocks.register(bus);
        NuclearTechBlockEntites.register(bus);
        NuclearTechItems.register(bus);
        NuclearTechTabs.register(bus);
        NuclearTechMenus.register(bus);
        bus.addListener(this::common_setup);
    }
}
