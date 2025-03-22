package astrid.nucleartech.main;

import astrid.nucleartech.items.PlutoniumPellet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NuclearTechItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AstridNuclearTech.MODID);

    public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza", () -> {
        return new Item(new Item.Properties().setId(ITEMS.key("pizza")));
    });
    public static final RegistryObject<Item> HYDRO_PEROXIDE = ITEMS.register("hydrogen_peroxide", () -> {
        return new Item(new Item.Properties().setId(ITEMS.key("hydrogen_peroxide")));
    });
    public static final RegistryObject<Item> RTG = ITEMS.register("rtg", () -> {
        return new BlockItem(NuclearTechBlocks.RTG.get(), new Item.Properties().setId(ITEMS.key("rtg")));
    });
    public static final RegistryObject<Item> PLUTONIUM_238_PELLET = ITEMS.register("plutonium238_pellet", () -> {
        return new PlutoniumPellet(new Item.Properties().setId(ITEMS.key("plutonium238_pellet")));
    });

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
