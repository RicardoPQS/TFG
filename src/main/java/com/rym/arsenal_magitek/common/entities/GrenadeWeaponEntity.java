package com.rym.arsenal_magitek.common.entities;

import com.rym.arsenal_magitek.init.ModEntities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class GrenadeWeaponEntity extends ThrowableEntity {
    private static final DataParameter<ItemStack> ITEM = EntityDataManager.defineId(GrenadeWeaponEntity.class, DataSerializers.ITEM_STACK);

    public GrenadeWeaponEntity(EntityType<? extends ThrowableEntity> type, World world) {
        super(type, world);
    }

    public GrenadeWeaponEntity(World world, LivingEntity thrower) {
        super(ModEntities.GrenadeWeapon.get(), thrower, world);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(ITEM, ItemStack.EMPTY);
    }

    public void setItem(ItemStack stack) {
        this.entityData.set(ITEM, stack.copy());
    }

    public ItemStack getItem() {
        return this.entityData.get(ITEM);
    }

    @Override
    protected void onHit(RayTraceResult result) {
        if (!this.level.isClientSide) {
            this.level.explode(null, this.getX(), this.getY(), this.getZ(), 3.0F, Explosion.Mode.BREAK);
            this.remove();
        }
        super.onHit(result);
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT nbt) {
        this.setItem(ItemStack.of(nbt.getCompound("Item")));
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT nbt) {
        nbt.put("Item", this.getItem().save(new CompoundNBT()));
    }
    
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}


