package net.redstone233.morehammercraft.items.funcitem;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.redstone233.morehammercraft.items.ModItems;

public class ColaItem extends Item {
    public static final int MAX_USE_TIME = 32;

    public ColaItem(Settings settings) {
        super(settings);
    }

    public ItemStack getDefaultStack() {
        ItemStack itemStack = super.getDefaultStack();
        //itemStack.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent((RegistryEntry<Potion>) ModItems.IRON_COLA));
        itemStack.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER));
        return itemStack;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)playerEntity, stack);
        }

        if (!world.isClient) {
//            PotionContentsComponent potionContentsComponent = stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
//            potionContentsComponent.forEachEffect(effect -> {
//                if (effect.getEffectType().value().isInstant()) {
//                    effect.getEffectType().value().applyInstantEffect(playerEntity, playerEntity, user, effect.getAmplifier(), 1.0);
//                } else {
//                    user.addStatusEffect(effect);
//                }
//            });
            user.setOnFireFor(20);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,1, false,false,false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK,600,4,false,false,false));
            if (user instanceof PlayerEntity) {
                ((PlayerEntity) user).sendMessage(Text.translatable("coal.mhc.use.success"),true);
            }
        }

        if (playerEntity != null) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            stack.decrementUnlessCreative(1, playerEntity);
        }

        if (playerEntity == null || !playerEntity.isInCreativeMode()) {
            if (stack.isEmpty()) {
                return new ItemStack(ModItems.IRON_CAN);
            }

            if (playerEntity != null) {
                playerEntity.getInventory().insertStack(new ItemStack(ModItems.IRON_CAN));
            }
        }

        user.emitGameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        ItemStack itemStack = context.getStack();
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)itemStack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
        BlockState blockState = world.getBlockState(blockPos);
        if (context.getSide() != Direction.DOWN && blockState.isIn(BlockTags.CONVERTABLE_TO_MUD) && potionContentsComponent.matches(Potions.WATER)) {
            world.playSound((PlayerEntity)null, blockPos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (playerEntity != null) {
                playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(ModItems.IRON_CAN)));
                playerEntity.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
                //playerEntity.sendMessage(Text.translatable("coal.mhc.use.success"),true);
            }
            //playerEntity.sendMessage(Text.translatable("coal.mhc.use.success"),true);
            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld)world;

                for(int i = 0; i < 5; ++i) {
                    serverWorld.spawnParticles(ParticleTypes.SPLASH, (double)blockPos.getX() + world.random.nextDouble(), (double)(blockPos.getY() + 1), (double)blockPos.getZ() + world.random.nextDouble(), 1, 0.0, 0.0, 0.0, 1.0);
                }
            }

            world.playSound((PlayerEntity)null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent((Entity)null, GameEvent.FLUID_PLACE, blockPos);
            world.setBlockState(blockPos, Blocks.MUD.getDefaultState());
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }


//    @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//        World world = context.getWorld();
//        BlockPos blockPos = context.getBlockPos();
//        PlayerEntity playerEntity = context.getPlayer();
//        ItemStack itemStack = context.getStack();
//        PotionContentsComponent potionContentsComponent = itemStack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
//        BlockState blockState = world.getBlockState(blockPos);
//        if (context.getSide() != Direction.DOWN && blockState.isIn(BlockTags.CONVERTABLE_TO_MUD) && potionContentsComponent.matches(Potions.WATER)) {
//            world.playSound(null, blockPos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1.0F, 1.0F);
//            playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(ModItems.IRON_CAN)));
//            playerEntity.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
//            if (!world.isClient) {
//                ServerWorld serverWorld = (ServerWorld)world;
//
//                for (int i = 0; i < 5; i++) {
//                    serverWorld.spawnParticles(
//                            ParticleTypes.SPLASH,
//                            (double)blockPos.getX() + world.random.nextDouble(),
//                            (double)(blockPos.getY() + 1),
//                            (double)blockPos.getZ() + world.random.nextDouble(),
//                            1,
//                            0.0,
//                            0.0,
//                            0.0,
//                            1.0
//                    );
//                }
//            }
//
//            world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
//            world.emitGameEvent(null, GameEvent.FLUID_PLACE, blockPos);
//            world.setBlockState(blockPos, Blocks.MUD.getDefaultState());
//            return ActionResult.SUCCESS;
//        } else {
//            return ActionResult.PASS;
//        }
//    }

    public Text getName(ItemStack stack) {
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent)stack.get(DataComponentTypes.POTION_CONTENTS);
        return potionContentsComponent != null ? potionContentsComponent.getName(this.translationKey + ".effect.") : super.getName(stack);
    }
}
