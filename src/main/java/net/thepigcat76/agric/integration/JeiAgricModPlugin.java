package net.thepigcat76.agric.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.thepigcat76.agric.Agric;
import net.thepigcat76.agric.block.ModBlocks;
import net.thepigcat76.agric.recipe.DryingRackRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JeiAgricModPlugin implements IModPlugin {
    public static RecipeType<DryingRackRecipe> DRYING_TYPE =
            new RecipeType<>(DryingRackRecipeCategory.UID, DryingRackRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Agric.MODID, "jei_plugin");
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                DryingRackRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<DryingRackRecipe> recipesDrying = rm.getAllRecipesFor(DryingRackRecipe.Type.INSTANCE);
        registration.addRecipes(DRYING_TYPE, recipesDrying);
    }
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.DRYING_RACK_ENTITY.get()), new RecipeType<>(DryingRackRecipeCategory.UID, DryingRackRecipe.class));
    }
}
