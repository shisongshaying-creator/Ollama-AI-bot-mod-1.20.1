package com.example.ollamabot.client;

import com.example.ollamabot.OllamaBotMod;
import com.example.ollamabot.client.render.OllamaFollowerRenderer;
import com.example.ollamabot.registry.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OllamaBotMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class OllamaBotClient {
    private OllamaBotClient() {
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.OLLAMA_FOLLOWER.get(), OllamaFollowerRenderer::new);
    }
}
