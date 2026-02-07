package com.example.ollamabot.registry;

import com.example.ollamabot.OllamaBotMod;
import com.example.ollamabot.entity.OllamaFollowerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OllamaBotMod.MODID);

    public static final RegistryObject<EntityType<OllamaFollowerEntity>> OLLAMA_FOLLOWER =
            ENTITY_TYPES.register("ollama_follower",
                    () -> EntityType.Builder.of(OllamaFollowerEntity::new, MobCategory.CREATURE)
                            .sized(0.9f, 1.3f)
                            .build("ollama_follower"));

    public static final AttributeSupplier.Builder OLLAMA_FOLLOWER_ATTRIBUTES =
            OllamaFollowerEntity.createAttributes();

    private ModEntities() {
    }
}
