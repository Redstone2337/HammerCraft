package net.redstone233.morehammercraft.core.recipe;

import com.google.common.annotations.VisibleForTesting;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class PolishMachineRecipe implements Recipe<SingleStackRecipeInput> {
    private final ItemStack result;
    private final List<Ingredient> recipeItems;
    private final String group;
    private final int makeTime;


    public PolishMachineRecipe(String group,List<Ingredient> recipeItems,ItemStack result,int makeTime) {
        this.group = group;
        this.result = result;
        this.recipeItems = recipeItems;
        this.makeTime = makeTime;

    }

    public String getGroup() {
        return this.group;
    }

    public ItemStack getResult() {
        return result;
    }

    public int getMakeTime() {
        return makeTime;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return recipeItems.get(0).test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return this.result.copy();
    }

    @VisibleForTesting
    public DefaultedList<Ingredient> getIngredients() {
        return DefaultedList.ofSize(this.recipeItems.size());
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleStackRecipeInput>> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends Recipe<SingleStackRecipeInput>> getType() {
        return Type.INSTANCE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return null;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return null;
    }


    public static class Type implements RecipeType<PolishMachineRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "conversion_table";
    }

    public static class Serializer implements RecipeSerializer<PolishMachineRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "conversion_table";

        public static final MapCodec<PolishMachineRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                (Codec.STRING.optionalFieldOf("group", "").forGetter((recipe) -> recipe.group)),
                (Ingredient.CODEC.listOf().fieldOf("ingredients")).forGetter(PolishMachineRecipe::getIngredients),
                (ItemStack.VALIDATED_CODEC.fieldOf("result")).forGetter(PolishMachineRecipe::getResult),
                (Codec.INT.optionalFieldOf("makes",72)).forGetter(recipe -> recipe.makeTime)
                ).apply(instance,PolishMachineRecipe::new));

    public static final PacketCodec<RegistryByteBuf,PolishMachineRecipe> PACKET_CODEC = PacketCodec.ofStatic(Serializer::write,Serializer::read);

        private static PolishMachineRecipe read(RegistryByteBuf registryByteBuf) {
            String string = registryByteBuf.readString();
            int time = registryByteBuf.readInt();
           DefaultedList<Ingredient> inputs = DefaultedList.ofSize(registryByteBuf.readVarInt());
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i,Ingredient.PACKET_CODEC.decode(registryByteBuf));
            }
            ItemStack result = ItemStack.PACKET_CODEC.decode(registryByteBuf);
            return new PolishMachineRecipe(string,inputs,result,time);
        }

        private static void write(RegistryByteBuf registryByteBuf, PolishMachineRecipe recipe) {
            registryByteBuf.writeString(recipe.group);
            registryByteBuf.writeInt(recipe.makeTime);
            registryByteBuf.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                Ingredient.PACKET_CODEC.encode(registryByteBuf,ingredient);
            }
            ItemStack.PACKET_CODEC.encode(registryByteBuf,recipe.getResult());
        }


        @Override
        public MapCodec<PolishMachineRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, PolishMachineRecipe> packetCodec() {
            return PACKET_CODEC;
        }
    }

}
