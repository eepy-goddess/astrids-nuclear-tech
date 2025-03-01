package astrid.nucleartech.main;

import astrid.nucleartech.blocks.RTG;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NuclearTechBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AstridNuclearTech.MODID);

    public static final RegistryObject<Block> RTG = BLOCKS.register("rtg", () -> {
        return new RTG(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).strength(20f).setId(BLOCKS.key("rtg")));
    });

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
