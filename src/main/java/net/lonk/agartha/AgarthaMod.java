package net.lonk.agartha;

import com.mojang.logging.LogUtils;
import net.lonk.agartha.block.ModBlocks;
import net.lonk.agartha.entity.ModEntities;
import net.lonk.agartha.entity.client.YakubModel;
import net.lonk.agartha.entity.client.YakubRenderer;
import net.lonk.agartha.item.ModCreativeModeTabs;
import net.lonk.agartha.item.ModItems;
import net.lonk.agartha.sound.ModSounds;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AgarthaMod.MOD_ID)
public class AgarthaMod {
    public static final String MOD_ID = "agartha";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final GameRules.Key<GameRules.IntegerValue> YAKUB_SPAWN_CHANCE =
            GameRules.register("yakubSpawnChance", GameRules.Category.MOBS, GameRules.IntegerValue.create(1000));

    public static final GameRules.Key<GameRules.IntegerValue> YAKUB_DESPAWN_TIME =
            GameRules.register("yakubDespawnTime", GameRules.Category.MOBS, GameRules.IntegerValue.create(2400));

    public AgarthaMod(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::addCreative);

        ModCreativeModeTabs.register(eventBus);

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModSounds.register(eventBus);
        ModEntities.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    private void addCreative(BuildCreativeModeTabContentsEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.YAKUB.get(), YakubRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(YakubModel.LAYER_LOCATION, YakubModel::createBodyLayer);
        }
    }
}
