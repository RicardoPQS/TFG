package com.rym.arsenal_magitek.common.items;

import com.rym.arsenal_magitek.ArsenalMagitekModMain;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolsMod {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ArsenalMagitekModMain.MOD_ID);

	public static final RegistryObject<Item> AxeHoe = ITEMS.register("axe_hoe",
			() -> new AxeHoeItem(ItemTier.DIAMOND, 4.0F, -2.4F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

	public static final RegistryObject<Item> SwordPickaxe = ITEMS.register("sword_pickaxe",
			() -> new SwordPickaxeItem(ItemTier.DIAMOND, 5.0F, -2.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

	public static final RegistryObject<Item> SwordGolden = ITEMS.register("sword_golden",
			() -> new SwordGoldenItem(ItemTier.DIAMOND, 28, -2.4F, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

	public static final RegistryObject<Item> PickaxeGod = ITEMS.register("pickaxe_god",
			() -> new PickaxeGodItem(ItemTier.DIAMOND, 1, -2.8F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

	public static final RegistryObject<Item> GrenadeWeapon = ITEMS.register("grenade_weapon",
			() -> new GrenadeWeaponItem());

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
