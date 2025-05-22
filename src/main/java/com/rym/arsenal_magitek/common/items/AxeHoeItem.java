package com.rym.arsenal_magitek.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassPathBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Direction;

import java.util.HashSet;
import java.util.Set;

public class AxeHoeItem extends ToolItem {

	private static final Set<Block> EFFECTIVE_BLOCKS = new HashSet<Block>() {{
	    add(Blocks.OAK_LOG);
	    add(Blocks.SPRUCE_LOG);
	    add(Blocks.BIRCH_LOG);
	    add(Blocks.JUNGLE_LOG);
	    add(Blocks.ACACIA_LOG);
	    add(Blocks.DARK_OAK_LOG);
	    add(Blocks.STRIPPED_OAK_LOG);
	    add(Blocks.COARSE_DIRT);
	    add(Blocks.PODZOL);
	}};

    public AxeHoeItem(IItemTier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(attackDamage, attackSpeed, tier, EFFECTIVE_BLOCKS, properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getItemInHand();
        Direction face = context.getClickedFace();

        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        // Simula comportamiento de una azada
        if (face != Direction.DOWN && world.getBlockState(pos.above()).isAir()) {
            if (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT) {
                BlockState newState = Blocks.FARMLAND.defaultBlockState();
                world.setBlock(pos, newState, 11);
                stack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(context.getHand()));
                return ActionResultType.SUCCESS;
            }
        }

        return super.useOn(context); // Fallback: comportamiento normal
    }
}
