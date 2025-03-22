package astrid.nucleartech.items;

import net.minecraft.world.item.Item;

public class PlutoniumPellet extends Item implements RTGFuel {
    public PlutoniumPellet(Properties properties) {
        super(properties);
    }

    @Override
    public int getEnergy() {
        return 0;
    }
}
