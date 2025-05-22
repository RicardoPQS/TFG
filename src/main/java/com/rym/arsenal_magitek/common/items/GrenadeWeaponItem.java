package com.rym.arsenal_magitek.common.items;

import com.rym.arsenal_magitek.common.entities.GrenadeWeaponEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class GrenadeWeaponItem extends Item {

	public GrenadeWeaponItem() {
		super(new Item.Properties().tab(ItemGroup.TAB_COMBAT));
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getItemInHand(hand);

		if (!player.abilities.instabuild) {
			stack.shrink(1);
		}

		world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW,
				SoundCategory.PLAYERS, 0.5F, 0.4F / (world.random.nextFloat() * 0.4F + 0.8F));

		if (!world.isClientSide) {
			GrenadeWeaponEntity ball = new GrenadeWeaponEntity(world, player);
			ball.setItem(new ItemStack(this));
			ball.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 1.5F, 1.0F);
			world.addFreshEntity(ball);
		}

		player.awardStat(Stats.ITEM_USED.get(this));
		return ActionResult.sidedSuccess(stack, world.isClientSide());
	}
}
