package com.rym.arsenal_magitek.client.renderer;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.client.Minecraft;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.rym.arsenal_magitek.common.entities.GrenadeWeaponEntity;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

@OnlyIn(Dist.CLIENT)
public class GrenadeWeaponRenderer extends EntityRenderer<GrenadeWeaponEntity> {

    private final ItemRenderer itemRenderer;

    public GrenadeWeaponRenderer(EntityRendererManager renderManager) {
        super(renderManager);
        this.itemRenderer = Minecraft.getInstance().getItemRenderer();
    }

    @Override
    public void render(GrenadeWeaponEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack,
                       IRenderTypeBuffer buffer, int packedLight) {

        ItemStack stack = entity.getItem();

        matrixStack.pushPose();
        matrixStack.translate(0.0D, 0.0D, 0.0D); // Puedes probar con 0.25D, 0.1D, etc.

        matrixStack.mulPose(Vector3f.YP.rotationDegrees(-entityYaw));
        
        float ageInTicks = entity.tickCount + partialTicks;
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(ageInTicks * 20F));
        
        itemRenderer.renderStatic(stack, ItemCameraTransforms.TransformType.GROUND, packedLight,
                OverlayTexture.NO_OVERLAY, matrixStack, buffer);
        matrixStack.popPose();

        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(GrenadeWeaponEntity entity) {
        return null; // Usamos renderizado por ítem, no textura directa
    }
}
