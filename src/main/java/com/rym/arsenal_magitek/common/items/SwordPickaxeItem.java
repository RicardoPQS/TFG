package com.rym.arsenal_magitek.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import java.util.HashSet;
import java.util.Set;

public class SwordPickaxeItem extends ToolItem {

    // Bloques efectivos como un pico
	private static final Set<Block> EFFECTIVE_BLOCKS = new HashSet<Block>() {{
	    add(Blocks.STONE);
	    add(Blocks.COBBLESTONE);
	    add(Blocks.IRON_ORE);
	    add(Blocks.COAL_ORE);
	    add(Blocks.DIAMOND_ORE);
	    add(Blocks.GOLD_ORE);
	    add(Blocks.REDSTONE_ORE);
	    add(Blocks.EMERALD_ORE);
	    add(Blocks.NETHERRACK);
	}};

    public SwordPickaxeItem(IItemTier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(attackDamage, attackSpeed, tier, EFFECTIVE_BLOCKS, properties);
    }
    

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Comportamiento de espada: daña enemigos
        stack.hurtAndBreak(1, attacker, (e) -> e.broadcastBreakEvent(Hand.MAIN_HAND));
        return true;
    }
    
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (EFFECTIVE_BLOCKS.contains(state.getBlock())) {
            return 17.0F;
        }
        return super.getDestroySpeed(stack, state);
    }
    
    public boolean canHarvestBlock(BlockState state, ItemStack stack) {
        return this.getTier().getLevel() >= state.getHarvestLevel();
    }



}
