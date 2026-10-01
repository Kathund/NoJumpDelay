package dev.kathund.nojumpdelay.mixin;

import net.minecraft.client.entity.living.player.LocalClientPlayerEntity;
import net.minecraft.entity.living.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
  @Shadow
  private int jumpingCooldown;

  @Inject(method = "mobTick", at = @At("HEAD"))
  private void mobTick(CallbackInfo ci) {
    if ((Object) this instanceof LocalClientPlayerEntity) this.jumpingCooldown = 0;
  }
}
