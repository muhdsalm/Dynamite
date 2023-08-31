package com.github.muhdsalm.dynamite;

import com.github.muhdsalm.dynamite.dynamite.DynamiteEntity;
import com.github.muhdsalm.dynamite.dynamite.DynamiteItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dynamite implements ModInitializer {
	public static final String MOD_ID = "dynamite";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<DynamiteEntity> dynamiteEntityType = Registry.register(Registries.ENTITY_TYPE, new Identifier(MOD_ID, "dynamite"), FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new)
			.dimensions(EntityDimensions.fixed(0.25F, 0.25F))
			.trackRangeBlocks(4).trackedUpdateRate(10)
			.build());
	public static final Item DynamiteItem = new DynamiteItem(new Item.Settings().maxCount(16));



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dynamite"), DynamiteItem);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
			content.addBefore(Items.TNT, DynamiteItem);
		});

		LOGGER.info("Hello Fabric world!");
	}
}