package com.github.muhdsalm.dynamite;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class DynamiteClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {

		EntityRendererRegistry.register(Dynamite.dynamiteEntityType, (context) ->
				new FlyingItemEntityRenderer(context));
	}
}