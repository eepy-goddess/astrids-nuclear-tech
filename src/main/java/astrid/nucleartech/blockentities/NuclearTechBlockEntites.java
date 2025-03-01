package astrid.nucleartech.blockentities;

import astrid.nucleartech.main.AstridNuclearTech;
import astrid.nucleartech.main.NuclearTechBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class NuclearTechBlockEntites {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AstridNuclearTech.MODID);

    public static final RegistryObject<BlockEntityType<?>> RTG = BLOCK_ENTITY_TYPES.register("rtg_blockentity", () -> {
        return new BlockEntityType<>(RTGBlockEntity::new, Set.of(NuclearTechBlocks.RTG.get()));
    });

    public static void register(IEventBus bus) {
        BLOCK_ENTITY_TYPES.register(bus);
    }
}
