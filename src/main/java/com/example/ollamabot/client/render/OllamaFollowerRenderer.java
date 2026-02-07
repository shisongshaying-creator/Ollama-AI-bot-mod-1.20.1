package com.example.ollamabot.client.render;

import com.example.ollamabot.OllamaBotMod;
import com.example.ollamabot.entity.OllamaFollowerEntity;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class OllamaFollowerRenderer extends MobRenderer<OllamaFollowerEntity, SheepModel<OllamaFollowerEntity>> {
    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/sheep/sheep.png");

    public OllamaFollowerRenderer(EntityRendererProvider.Context context) {
        super(context, new SheepModel<>(context.bakeLayer(ModelLayers.SHEEP)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(OllamaFollowerEntity entity) {
        return TEXTURE;
    }
}
