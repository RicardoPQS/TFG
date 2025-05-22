package com.rym.arsenal_magitek.common.items;

import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SwordGoldenItem extends SwordItem {

	public SwordGoldenItem(ItemTier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
		super(tier, attackDamage, attackSpeed, properties);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		World world = attacker.level;

		if (!world.isClientSide && world instanceof ServerWorld) {
			ServerWorld serverWorld = (ServerWorld) world;

			LightningBoltEntity lightning = EntityType.LIGHTNING_BOLT.create(serverWorld);
			if (lightning != null) {
				lightning.setPos(target.getX(), target.getY(), target.getZ());
				serverWorld.addFreshEntity(lightning);
			}
		}

		return super.hurtEnemy(stack, target, attacker);
	}

	public static final SwordGoldenItem SwordGolden = new SwordGoldenItem(
			ItemTier.DIAMOND, 28, -2.4F,
			new Item.Properties().tab(ItemGroup.TAB_COMBAT)
	);
}

