package com.rym.arsenal_magitek.common.items;

import com.rym.arsenal_magitek.ArsenalMagitekModMain;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodsMod {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ArsenalMagitekModMain.MOD_ID);
	
	public static final RegistryObject<Item> SUSHI = ITEMS.register("sushi",
	        () -> new SushiItem(new Item.Properties()
	                .food(new Food.Builder().nutrition(4).saturationMod(0.3F).alwaysEat().build())
	                .tab(ItemGroup.TAB_FOOD)));
	
	
	public static final RegistryObject<Item> Rice = ITEMS.register("rice",
	        () -> new RiceItem(new Item.Properties()
					.food(new Food.Builder().nutrition(2).saturationMod(0.3F).alwaysEat().build())
					.tab(ItemGroup.TAB_FOOD)));

	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
