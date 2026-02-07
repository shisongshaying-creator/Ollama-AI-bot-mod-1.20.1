package com.example.ollamabot.registry;

import com.example.ollamabot.OllamaBotMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OllamaBotMod.MODID);

    public static final RegistryObject<Item> OLLAMA_FOLLOWER_SPAWN_EGG =
            ITEMS.register("ollama_follower_spawn_egg",
                    () -> new SpawnEggItem(ModEntities.OLLAMA_FOLLOWER, 0xead9c4, 0x5a4738,
                            new Item.Properties()));

    private ModItems() {
    }
}
