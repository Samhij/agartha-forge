package net.lonk.agartha.item;

import net.lonk.agartha.AgarthaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AgarthaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AGARTHAN_ITEMS_TAB = CREATIVE_MODE_TABS.register("agarthan_items",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.WHITE_MONSTER.get()))
                    .title(Component.translatable("itemGroup.agarthan_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WHITE_MONSTER.get());
                        pOutput.accept(ModItems.AGARTHIUM.get());
                        pOutput.accept(ModItems.AGARTHAN_RESIDUE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> AGARTHAN_BLOCKS_TAB = CREATIVE_MODE_TABS.register("agarthan_blocks",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.WHITE_MONSTER.get()))
                    .title(Component.translatable("itemGroup.agarthan_blocks"))
                    .withTabsBefore(ResourceLocation.tryBuild(AgarthaMod.MOD_ID, "agarthan_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.WHITE_MONSTER.get());
                    }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
