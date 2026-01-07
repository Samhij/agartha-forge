package net.lonk.agartha.event;

import net.lonk.agartha.AgarthaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AgarthaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class YakubSpawnHandler {
    private static boolean canSpawn = true;

    @SubscribeEvent
    private static void onServerTick(TickEvent.ServerTickEvent event) {
        for (ServerLevel world : event.getServer().getAllLevels()) {

        }
    }

    private static void handleWorldSpawns(ServerLevel level) {
        if (level == null || !canSpawn) {
            return;
        }

        // Check if we're in Agartha dimension (change line when adding dimension)
        boolean isAgartha = false;

        // In overworld: only spawn at night
        // In Agartha spawn anytime
        if (!isAgartha && !level.isNight()) {
            return;
        }

        // Get spawn chance from game rules
        int baseChance = level.getGameRules().getInt(AgarthaMod.YAKUB_SPAWN_CHANCE);

        // In Agartha, make spawn chance 10x higher (divide by 10)
        int chance = isAgartha ? Math.max(1, baseChance / 10) : baseChance;

        if (level.random.nextInt(chance) != 0) {
            return;
        }

        for (ServerPlayer player : level.players()) {
            // In Agartha, 50% chance per player instead of 10%
            float playerChance = isAgartha ? 0.5f : 0.1f;

            if (level.random.nextFloat() >= playerChance) {
                continue;
            }

            BlockPos spawnPos = findValidSpawnPos(level, player.blockPosition());
            if (spawnPos != null) {
                // Yakub spawning logic here
            }
        }
    }

    private static BlockPos findValidSpawnPos(ServerLevel level, BlockPos center) {
        for (int attempts = 0; attempts < 50; attempts++) {
            int dx = level.random.nextInt(50) - 25;
            int dy = level.random.nextInt(10) - 5;
            int dz = level.random.nextInt(50) - 25;

            BlockPos pos = center.offset(dx, dy, dz);

            BlockPos below = pos.below();
            if (level.getBlockState(below).isRedstoneConductor(level, below)
                    && level.getBlockState(pos).isAir()
                    && level.getBlockState(pos.above()).isAir()) {
                return pos;
            }
        }

        return null;
    }

    public static void resetSpawnFlag() {
        canSpawn = true;
    }
}
