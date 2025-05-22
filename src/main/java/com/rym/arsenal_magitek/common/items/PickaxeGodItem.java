package com.rym.arsenal_magitek.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PickaxeGodItem extends PickaxeItem {

	public PickaxeGodItem(IItemTier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

	@Override
	public boolean mineBlock(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		if (!world.isClientSide && entityLiving instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entityLiving;
			int radius = 1;

			for (int dx = -radius; dx <= radius; dx++) {
				for (int dy = -radius; dy <= radius; dy++) {
					for (int dz = -radius; dz <= radius; dz++) {
						BlockPos targetPos = pos.offset(dx, dy, dz);
						if (!targetPos.equals(pos)) {
							BlockState targetState = world.getBlockState(targetPos);
							Block targetBlock = targetState.getBlock();

							if (!targetBlock.isAir(targetState, world, targetPos)) {
								if (net.minecraftforge.common.ForgeHooks.canHarvestBlock(targetState, player, world, targetPos)) {
									world.destroyBlock(targetPos, true, player);
								}
							}
						}
					}
				}
			}
		}
		return super.mineBlock(stack, world, state, pos, entityLiving);
	}


}
