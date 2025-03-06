package astrid.nucleartech.gui;

import astrid.nucleartech.blockentities.RTGBlockEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class RTGMenu extends AbstractContainerMenu {

    public RTGMenu(int id, Inventory inventory, Container entity) {
        super(NuclearTechMenus.RTG.get(), id);
        addSlots(inventory, entity);
    }

    public RTGMenu(int id, Inventory inv) {
        this(id, inv, new SimpleContainer(1));
    }

    public void addSlots(Inventory inv, Container entity) {
        this.addStandardInventorySlots(inv, 8, 78);
        this.addSlot(new Slot(entity, 0, 54, 28
        ));
    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return super.getItems();
    }

    @Override
    public boolean stillValid(Player player) {
        return player.isAlive();
    }
}
