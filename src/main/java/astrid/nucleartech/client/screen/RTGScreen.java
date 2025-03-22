package astrid.nucleartech.client.screen;

import astrid.nucleartech.gui.RTGMenu;
import astrid.nucleartech.main.AstridNuclearTech;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class RTGScreen extends AbstractContainerScreen<RTGMenu> {
    public static final ResourceLocation RTG_GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(AstridNuclearTech.MODID, "textures/gui/rtg.png");

    public RTGScreen(RTGMenu menu, Inventory inv, Component comp) {
        super(menu, inv, comp);
        this.imageWidth = 176;
        this.imageHeight = 166;
        this.inventoryLabelY = this.inventoryLabelY - 5;
        this.titleLabelY = this.titleLabelY - 5;

    }

    @Override
    protected void renderBg(GuiGraphics graphics, float p_97788_, int p_97789_, int p_97790_) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageWidth) / 2;
        graphics.blit(RenderType::guiTextured, RTG_GUI_TEXTURE, x, y, 0.0f, 0.0f, imageWidth, imageHeight, 256, 256);
    }

    @Override
    public void render(GuiGraphics graphics, int p_281550_, int p_282878_, float p_282465_) {
        super.render(graphics, p_281550_, p_282878_, p_282465_);
        super.renderTooltip(graphics, p_281550_, p_282878_);
        int x = (width - imageWidth) / 2;
        int y = (height - imageWidth) / 2;
        int i = x + 128;
        int j = y + 19;
        graphics.blit(RenderType::guiTextured, RTG_GUI_TEXTURE, i, j, 0.0f,  0.0f, 16, 55, 256, 256);
        
    }
}
