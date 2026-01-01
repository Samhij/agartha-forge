package net.lonk.agartha.datagen;

import net.lonk.agartha.AgarthaMod;
import net.lonk.agartha.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnglishLangProvider extends LanguageProvider {
    public ModEnglishLangProvider(PackOutput output) {
        super(output, AgarthaMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        this.addItem(ModItems.WHITE_MONSTER, "White Monster");
        this.addItem(ModItems.AGARTHIUM, "Agarthium");
        this.addItem(ModItems.AGARTHAN_RESIDUE, "Agarthan Residue");

        this.add("itemGroup.agarthan_items", "Agarthan Items");
        this.add("itemGroup.agarthan_blocks", "Agarthan Blocks");
    }
}
