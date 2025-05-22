package com.rym.arsenal_magitek.client;

import com.rym.arsenal_magitek.client.renderer.GrenadeWeaponRenderer;
import com.rym.arsenal_magitek.init.ModEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = "arsenal_magitek", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
            ModEntities.GrenadeWeapon.get(),
            GrenadeWeaponRenderer::new
        );
    }
}
