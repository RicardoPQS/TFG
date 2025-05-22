package com.rym.arsenal_magitek.common.items;

import java.util.Random;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SushiItem extends Item {
    private static final Random RANDOM = new Random();

    public SushiItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
        if (!world.isClientSide()) {
            int roll = RANDOM.nextInt(10);

            EffectInstance effect = null;
            switch (roll) {
                case 0:
                    effect = new EffectInstance(Effects.HEAL, 100, 1);
                    break;
                case 1:
                    effect = new EffectInstance(Effects.DAMAGE_BOOST, 600, 1);
                    break;
                case 2:
                    effect = new EffectInstance(Effects.SATURATION, 200, 1);
                    break;
                case 3:
                    effect = new EffectInstance(Effects.REGENERATION, 600, 1);
                    break;
                case 4:
                    effect = new EffectInstance(Effects.MOVEMENT_SPEED, 600, 1);
                    break;
                case 5:
                    effect = new EffectInstance(Effects.FIRE_RESISTANCE, 600, 0);
                    break;
                case 6:
                    effect = new EffectInstance(Effects.JUMP, 600, 1);
                    break;
                case 7:
                    effect = new EffectInstance(Effects.DAMAGE_RESISTANCE, 600, 0);
                    break;
                case 8:
                    effect = new EffectInstance(Effects.INVISIBILITY, 600, 0);
                    break;
                case 9:
                    effect = new EffectInstance(Effects.CONFUSION, 400, 0); // efecto negativo
                    break;
            }

            if (effect != null) {
                entity.addEffect(effect);
            }
        }

        return super.finishUsingItem(stack, world, entity);
    }
}
