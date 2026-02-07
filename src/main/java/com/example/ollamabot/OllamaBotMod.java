package com.example.ollamabot;

import com.example.ollamabot.registry.ModEntities;
import com.example.ollamabot.registry.ModItems;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(OllamaBotMod.MODID)
public class OllamaBotMod {
    public static final String MODID = "ollamabot";

    public OllamaBotMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);

        modEventBus.addListener(this::registerAttributes);
        modEventBus.addListener(this::addCreativeTabs);
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.OLLAMA_FOLLOWER.get(), ModEntities.OLLAMA_FOLLOWER_ATTRIBUTES.build());
    }

    private void addCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == net.minecraft.world.item.CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.OLLAMA_FOLLOWER_SPAWN_EGG);
        }
    }
}
