package net.thepigcat76.agric.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.thepigcat76.agric.Agric;
import net.thepigcat76.agric.block.ModBlocks;
import net.thepigcat76.agric.recipe.DryingRackRecipe;

public class DryingRackRecipeCategory implements IRecipeCategory<DryingRackRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Agric.MODID, "gem_infusing");
    public final static ResourceLocation TEXTURE = new ResourceLocation(Agric.MODID, "textures/gui/drying_rack_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public DryingRackRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.DRYING_RACK_ENTITY.get()));
    }

    @Override
    public RecipeType<DryingRackRecipe> getRecipeType() {
        return JeiAgricModPlugin.DRYING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("container.drying_rack");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DryingRackRecipe recipe, IFocusGroup focuses) {

    builder.addSlot(RecipeIngredientRole.INPUT,86,15).addIngredients(recipe.getIngredients().get(0));
    builder.addSlot(RecipeIngredientRole.OUTPUT,86,60).addItemStack(recipe.getResultItem());
}
}
