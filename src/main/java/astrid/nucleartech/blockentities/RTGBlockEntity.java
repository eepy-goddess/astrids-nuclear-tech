package astrid.nucleartech.blockentities;

import astrid.nucleartech.blocks.RTG;
import astrid.nucleartech.gui.RTGMenu;
import astrid.nucleartech.main.AstridNuclearTech;
import astrid.nucleartech.main.NuclearTechItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// OMGGGG I MISSED WHEN THEY WERE CALLED TILE ENTITIES
public class RTGBlockEntity extends BlockEntity implements Container, MenuProvider {
    NonNullList<ItemStack> items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
    BlockPos pos;
    IItemHandlerModifiable handler;

    public RTGBlockEntity(BlockPos pos, BlockState state) {
        super(NuclearTechBlockEntites.RTG.get(), pos, state);
        this.pos = pos;

    }

    private net.minecraftforge.items.IItemHandlerModifiable createHandler() {
        BlockState state = this.getBlockState();
        if (!(state.getBlock() instanceof RTG rtg)) {
            return new net.minecraftforge.items.wrapper.InvWrapper(this);
        }
        Container inv = this;
        return new net.minecraftforge.items.wrapper.InvWrapper(this);
    }

    @Override
    public int getContainerSize() {
        return 1;
    }


    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public ItemStack removeItem(int slot, int p_18943_) {
        return ContainerHelper.removeItem(items, slot, p_18943_);

    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(items, slot);
    }

    @Override
    public void setItem(int slot, ItemStack item) {
        AstridNuclearTech.LOGGER.info("item at RTG entity set");
        items.set(slot, item);
    }



    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        if (!this.isEmpty())
            ContainerHelper.saveAllItems(tag, items, provider);
    }

    @Override
    protected void loadAdditional(CompoundTag tags, HolderLookup.Provider provider) {
        super.loadAdditional(tags, provider);
        items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!this.isEmpty())
            ContainerHelper.loadAllItems(tags, items, provider);
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.isAlive();
    }

    @Override
    public void startOpen(Player p_18955_) {
        Container.super.startOpen(p_18955_);
    }

    @Override
    public void clearContent() {
        items.clear();

    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menus." + AstridNuclearTech.MODID + ".rtg");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new RTGMenu(id, inv, this);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {

        if (cap == net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER && !this.remove) {
            if (this.handler == null)
                this.handler = (IItemHandlerModifiable) LazyOptional.of(this::createHandler);
            return (LazyOptional<T>) this.handler;
        }
        return super.getCapability(cap);
    }
}
