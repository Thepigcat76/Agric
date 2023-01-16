package net.thepigcat76.agric.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.thepigcat76.agric.Agric;

public class DryingRackScreen extends AbstractContainerScreen<DryingRackMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Agric.MODID,"textures/gui/drying_rack_gui.png");

    public DryingRackScreen(DryingRackMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = leftPos;
        int j = topPos;
        this.blit(pPoseStack, i, j, 0, 0, imageWidth, imageHeight);

        if (menu.isCrafting()) {
            this.blit(pPoseStack, i + 56, j + 36 + 12 - menu.getScaledProgress(), 176, 12 - menu.getScaledProgress(), 14, menu.getScaledProgress() + 1);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}