package net.lonk.agartha.entity;

import net.lonk.agartha.AgarthaMod;
import net.lonk.agartha.entity.custom.YakubEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AgarthaMod.MOD_ID);

    public static final RegistryObject<EntityType<YakubEntity>> YAKUB = ENTITY_TYPES.register("yakub",
            () -> EntityType.Builder.of(YakubEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.8f)
                    .build(ResourceLocation.fromNamespaceAndPath(AgarthaMod.MOD_ID, "yakub").toString()));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
