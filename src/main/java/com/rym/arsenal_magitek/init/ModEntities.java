package com.rym.arsenal_magitek.init;

import com.rym.arsenal_magitek.ArsenalMagitekModMain;
import com.rym.arsenal_magitek.common.entities.GrenadeWeaponEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			ArsenalMagitekModMain.MOD_ID);

	public static final RegistryObject<EntityType<GrenadeWeaponEntity>> GrenadeWeapon = ENTITIES
			.register("grenade_weapon",
					() -> EntityType.Builder
							.<GrenadeWeaponEntity>of(GrenadeWeaponEntity::new, EntityClassification.MISC)
							.sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build("grenade_weapon"));
}
