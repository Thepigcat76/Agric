package net.thepigcat76.agric.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.thepigcat76.agric.Agric;
import org.jetbrains.annotations.Nullable;

public class CentrifugeRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItem;

    public CentrifugeRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id =id;
        this.output = output;
        this.recipeItem = recipeItems;
    }

    @Override
    public boolean matches (SimpleContainer pContainer, Level pLevel){
        if (pLevel.isClientSide()) {
            return false;
        }

        return recipeItem.get(0).test(pContainer.getItem(0));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItem;
    }

    @Override
    public ItemStack assemble (SimpleContainer pContainer){
        return output;
    }

    @Override
    public boolean canCraftInDimensions ( int pWidth, int pHeight){
        return true;
    }

    @Override
    public ItemStack getResultItem () {
        return output.copy();
    }

    @Override
    public ResourceLocation getId () {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer () {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType () {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<CentrifugeRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "centrifuging";
    }

    public static class Serializer implements RecipeSerializer<CentrifugeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Agric.MODID, "centrifuging");

        @Override
        public CentrifugeRecipe fromJson(ResourceLocation id, JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }
            return new CentrifugeRecipe(id, output, inputs);
        }

        @Override
        public @Nullable CentrifugeRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf pBuffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            ItemStack output = pBuffer.readItem();
            return new CentrifugeRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CentrifugeRecipe pRecipe) {
            pBuffer.writeInt(pRecipe.getIngredients().size());

            for (Ingredient ing : pRecipe.getIngredients()) {
                ing.toNetwork(pBuffer);
            }
            pBuffer.writeItemStack(pRecipe.getResultItem(), false);
        }
    }
}