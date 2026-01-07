package net.lonk.agartha.datagen;

import net.lonk.agartha.AgarthaMod;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;

public class ModDamageTypes {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap);

    public static final ResourceKey<DamageType> AGARTHAN_DAMAGE = registerDamageType("agarthan");
    public static final ResourceKey<DamageType> HEART_ATTACK = registerDamageType("heart_attack");

    private static ResourceKey<DamageType> registerDamageType(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(AgarthaMod.MOD_ID, name));
    }

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(AGARTHAN_DAMAGE, new DamageType(
                "agarthan",
                DamageScaling.NEVER,
                0.1f,
                DamageEffects.HURT,
                DeathMessageType.DEFAULT
        ));

        context.register(HEART_ATTACK, new DamageType(
                "heart_attack",
                DamageScaling.NEVER,
                0.1f,
                DamageEffects.HURT,
                DeathMessageType.DEFAULT
        ));
    }
}
