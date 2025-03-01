package astrid.nucleartech.blockentities;

import astrid.nucleartech.gui.RTGMenu;
import astrid.nucleartech.main.AstridNuclearTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

// OMGGGG I MISSED WHEN THEY WERE CALLED TILE ENTITIES
public class RTGBlockEntity extends BlockEntity implements Container, MenuProvider {

    BlockPos pos;
    public RTGBlockEntity(BlockPos pos, BlockState state) {
        super(NuclearTechBlockEntites.RTG.get(), pos, state);
        this.pos = pos;
        AstridNuclearTech.LOGGER.info("RTG Block Entity loaded");
    }

    @Override
    public int getContainerSize() {
        return 0;
    }



    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int p_18941_) {
        return null;
    }

    @Override
    public ItemStack removeItem(int p_18942_, int p_18943_) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_18951_) {
        return null;
    }

    @Override
    public void setItem(int p_18944_, ItemStack p_18945_) {

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

    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("menus." + AstridNuclearTech.MODID + ".rtg");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new RTGMenu(id, inv);
    }
}
