package net.redstone233.morehammercraft.core.gui.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;

import java.util.function.Function;

public class PolishMachineScreen extends HandledScreen<PolishingMachineScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(MoreHammerCraft.MOD_ID,"textures/gui/conversion_table.png");
    private static final Identifier TEXTURE_PROGRESS = Identifier.of(MoreHammerCraft.MOD_ID,"textures/gui/conversion_table.png");
    
    public PolishMachineScreen(PolishingMachineScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        context.drawTexture(TEXTURE,x,y,0,0,this.backgroundWidth,this.backgroundHeight);
        renderProgressArrow(context,x,y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if (handler.isCrafting() && handler.isRaining()) {
            //context.drawTexture(RenderLayer::getGuiTextured,TEXTURE,x + 85,y + 30,176,0,8,handler.getScaledProgress(),backgroundWidth,backgroundHeight);
            context.drawTexture(TEXTURE_PROGRESS,x + 85,y + 30,176,0,8,handler.getScaledProgress(),this.backgroundWidth,this.backgroundHeight);
        }
    }
}
