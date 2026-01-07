package net.lonk.agartha.entity.client;

import net.lonk.agartha.AgarthaMod;
import net.lonk.agartha.entity.custom.YakubEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class YakubRenderer extends MobRenderer<YakubEntity, YakubModel> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(AgarthaMod.MOD_ID, "textures/entity/yakub.png");

    public YakubRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new YakubModel(pContext.bakeLayer(YakubModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(YakubEntity pEntity) {
        return TEXTURE;
    }
}
