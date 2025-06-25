package com.tmquan2508.optabfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroup.DisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.enchantment.Enchantments.*;

public class OpTabFabric implements ModInitializer {
    public static final String MOD_ID = "optabfabric";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "optab"));

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(Items.NETHERITE_SWORD))
                .displayName(Text.literal("Op Tab"))
                .entries((displayContext, entries) -> {
                    getItems(displayContext).forEach(entries::add);
                })
                .build());

        LOGGER.info("Initialized OpTab!");
    }

    public List<ItemStack> getItems(DisplayContext displayContext) {
        List<ItemStack> stacks = new ArrayList<>();

        RegistryWrapper.WrapperLookup registryLookup = displayContext.lookup();
        RegistryWrapper<Enchantment> enchantmentRegistry = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        RegistryEntry<Enchantment> SHARPNESS_ENTRY = enchantmentRegistry.getOrThrow(SHARPNESS);
        RegistryEntry<Enchantment> FIRE_ASPECT_ENTRY = enchantmentRegistry.getOrThrow(FIRE_ASPECT);
        RegistryEntry<Enchantment> MENDING_ENTRY = enchantmentRegistry.getOrThrow(MENDING);
        RegistryEntry<Enchantment> UNBREAKING_ENTRY = enchantmentRegistry.getOrThrow(UNBREAKING);
        RegistryEntry<Enchantment> FEATHER_FALLING_ENTRY = enchantmentRegistry.getOrThrow(FEATHER_FALLING);
        RegistryEntry<Enchantment> PROTECTION_ENTRY = enchantmentRegistry.getOrThrow(PROTECTION);
        RegistryEntry<Enchantment> BLAST_PROTECTION_ENTRY = enchantmentRegistry.getOrThrow(BLAST_PROTECTION);
        RegistryEntry<Enchantment> PROJECTILE_PROTECTION_ENTRY = enchantmentRegistry.getOrThrow(PROJECTILE_PROTECTION);
        RegistryEntry<Enchantment> FIRE_PROTECTION_ENTRY = enchantmentRegistry.getOrThrow(FIRE_PROTECTION);
        RegistryEntry<Enchantment> EFFICIENCY_ENTRY = enchantmentRegistry.getOrThrow(EFFICIENCY);
        RegistryEntry<Enchantment> FORTUNE_ENTRY = enchantmentRegistry.getOrThrow(FORTUNE);
        RegistryEntry<Enchantment> SILK_TOUCH_ENTRY = enchantmentRegistry.getOrThrow(SILK_TOUCH);
        RegistryEntry<Enchantment> RESPIRATION_ENTRY = enchantmentRegistry.getOrThrow(RESPIRATION);
        RegistryEntry<Enchantment> THORNS_ENTRY = enchantmentRegistry.getOrThrow(THORNS);

        ItemStack sharp32ksword = new ItemStack(Items.NETHERITE_SWORD);
        sharp32ksword.addEnchantment(SHARPNESS_ENTRY, 127);
        sharp32ksword.addEnchantment(FIRE_ASPECT_ENTRY, 127);
        sharp32ksword.addEnchantment(MENDING_ENTRY, 127);
        sharp32ksword.addEnchantment(UNBREAKING_ENTRY, 127);
        sharp32ksword.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Sword"));
        stacks.add(sharp32ksword);

        ItemStack sharp32kaxe = new ItemStack(Items.NETHERITE_AXE);
        sharp32kaxe.addEnchantment(EFFICIENCY_ENTRY, 127);
        sharp32kaxe.addEnchantment(SHARPNESS_ENTRY, 127);
        sharp32kaxe.addEnchantment(FIRE_ASPECT_ENTRY, 127);
        sharp32kaxe.addEnchantment(MENDING_ENTRY, 127);
        sharp32kaxe.addEnchantment(UNBREAKING_ENTRY, 127);
        sharp32kaxe.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Axe"));
        stacks.add(sharp32kaxe);

        ItemStack eff32kpickaxe = new ItemStack(Items.NETHERITE_PICKAXE);
        eff32kpickaxe.addEnchantment(EFFICIENCY_ENTRY, 127);
        eff32kpickaxe.addEnchantment(FORTUNE_ENTRY, 10);
        eff32kpickaxe.addEnchantment(MENDING_ENTRY, 127);
        eff32kpickaxe.addEnchantment(UNBREAKING_ENTRY, 127);
        eff32kpickaxe.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Pickaxe"));
        stacks.add(eff32kpickaxe);

        ItemStack silktouchpickaxe = new ItemStack(Items.NETHERITE_PICKAXE);
        silktouchpickaxe.addEnchantment(EFFICIENCY_ENTRY, 127);
        silktouchpickaxe.addEnchantment(SILK_TOUCH_ENTRY, 1);
        silktouchpickaxe.addEnchantment(MENDING_ENTRY, 127);
        silktouchpickaxe.addEnchantment(UNBREAKING_ENTRY, 127);
        silktouchpickaxe.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Silk Touch Pickaxe"));
        stacks.add(silktouchpickaxe);

        ItemStack eff32kshovel = new ItemStack(Items.NETHERITE_SHOVEL);
        eff32kshovel.addEnchantment(EFFICIENCY_ENTRY, 127);
        eff32kshovel.addEnchantment(FORTUNE_ENTRY, 10);
        eff32kshovel.addEnchantment(MENDING_ENTRY, 127);
        eff32kshovel.addEnchantment(UNBREAKING_ENTRY, 127);
        eff32kshovel.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Shovel"));
        stacks.add(eff32kshovel);

        ItemStack all32khelmet = new ItemStack(Items.NETHERITE_HELMET);
        all32khelmet.addEnchantment(PROTECTION_ENTRY, 127);
        all32khelmet.addEnchantment(FIRE_PROTECTION_ENTRY, 127);
        all32khelmet.addEnchantment(BLAST_PROTECTION_ENTRY, 127);
        all32khelmet.addEnchantment(PROJECTILE_PROTECTION_ENTRY, 127);
        all32khelmet.addEnchantment(RESPIRATION_ENTRY, 127);
        all32khelmet.addEnchantment(THORNS_ENTRY, 127);
        all32khelmet.addEnchantment(MENDING_ENTRY, 127);
        all32khelmet.addEnchantment(UNBREAKING_ENTRY, 127);
        all32khelmet.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Helmet"));
        stacks.add(all32khelmet);

        ItemStack all32kchestplate = new ItemStack(Items.NETHERITE_CHESTPLATE);
        all32kchestplate.addEnchantment(PROTECTION_ENTRY, 127);
        all32kchestplate.addEnchantment(FIRE_PROTECTION_ENTRY, 127);
        all32kchestplate.addEnchantment(BLAST_PROTECTION_ENTRY, 127);
        all32kchestplate.addEnchantment(PROJECTILE_PROTECTION_ENTRY, 127);
        all32kchestplate.addEnchantment(THORNS_ENTRY, 127);
        all32kchestplate.addEnchantment(MENDING_ENTRY, 127);
        all32kchestplate.addEnchantment(UNBREAKING_ENTRY, 127);
        all32kchestplate.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Chestplate"));
        stacks.add(all32kchestplate);

        ItemStack all32kleggings = new ItemStack(Items.NETHERITE_LEGGINGS);
        all32kleggings.addEnchantment(PROTECTION_ENTRY, 127);
        all32kleggings.addEnchantment(FIRE_PROTECTION_ENTRY, 127);
        all32kleggings.addEnchantment(BLAST_PROTECTION_ENTRY, 127);
        all32kleggings.addEnchantment(PROJECTILE_PROTECTION_ENTRY, 127);
        all32kleggings.addEnchantment(THORNS_ENTRY, 127);
        all32kleggings.addEnchantment(MENDING_ENTRY, 127);
        all32kleggings.addEnchantment(UNBREAKING_ENTRY, 127);
        all32kleggings.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Leggings"));
        stacks.add(all32kleggings);

        ItemStack all32kboots = new ItemStack(Items.NETHERITE_BOOTS);
        all32kboots.addEnchantment(PROTECTION_ENTRY, 127);
        all32kboots.addEnchantment(FIRE_PROTECTION_ENTRY, 127);
        all32kboots.addEnchantment(BLAST_PROTECTION_ENTRY, 127);
        all32kboots.addEnchantment(PROJECTILE_PROTECTION_ENTRY, 127);
        all32kboots.addEnchantment(THORNS_ENTRY, 127);
        all32kboots.addEnchantment(FEATHER_FALLING_ENTRY, 127);
        all32kboots.addEnchantment(MENDING_ENTRY, 127);
        all32kboots.addEnchantment(UNBREAKING_ENTRY, 127);
        all32kboots.set(DataComponentTypes.CUSTOM_NAME, Text.literal("OP Boots"));
        stacks.add(all32kboots);

        stacks.add(new ItemStack(Blocks.COMMAND_BLOCK));
        stacks.add(new ItemStack(Blocks.BARRIER));
        stacks.add(new ItemStack(Blocks.STRUCTURE_BLOCK));
        stacks.add(new ItemStack(Blocks.STRUCTURE_VOID));
        stacks.add(new ItemStack(Blocks.LIGHT));
        stacks.add(new ItemStack(Items.COMMAND_BLOCK_MINECART));
        stacks.add(new ItemStack(Blocks.DRAGON_EGG));
        stacks.add(new ItemStack(Items.DEBUG_STICK));
        stacks.add(new ItemStack(Blocks.SPAWNER));
        stacks.add(new ItemStack(Items.KNOWLEDGE_BOOK));

        return stacks;
    }
}