package net.lonk.agartha.item;

import net.lonk.agartha.AgarthaMod;
import net.lonk.agartha.item.custom.WhiteMonsterItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AgarthaMod.MOD_ID);

    public static final RegistryObject<Item> WHITE_MONSTER = ITEMS.register("white_monster",
            () -> new WhiteMonsterItem(new Item.Properties().rarity(Rarity.RARE).durability(5)));

    public static final RegistryObject<Item> AGARTHIUM = ITEMS.register("agarthium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AGARTHAN_RESIDUE = ITEMS.register("agarthan_residue",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
