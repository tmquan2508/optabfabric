package com.tmquan2508.optabfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

import static net.minecraft.enchantment.Enchantments.*;

public class OpTabFabric implements ModInitializer {
    public static final String MOD_ID = "optabfabric";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "optab"));

    private static final int OP_LEVEL = 127;
    private static final int FORTUNE_LEVEL = 10;
    private static final int SILK_TOUCH_LEVEL = 1;

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(Items.COMMAND_BLOCK))
                .displayName(Text.literal("Op Tab"))
                .entries(this::populateItems)
                .build());

        LOGGER.info("Initialized OpTab!");
    }

    private void populateItems(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries) {
        var enchantmentLookup = displayContext.lookup().getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        addOpTools(entries::add, enchantmentLookup);
        addOpArmor(entries::add, enchantmentLookup);
        addSpecialItems(entries::add);
    }

    private void addOpTools(Consumer<ItemStack> entries, RegistryWrapper<Enchantment> enchantmentLookup) {
        entries.accept(createEnchantedItem(Items.NETHERITE_SWORD, "OP Sword", builder -> {
            builder.add(enchantmentLookup.getOrThrow(SHARPNESS), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(FIRE_ASPECT), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(MENDING), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(UNBREAKING), OP_LEVEL);
        }));
        entries.accept(createEnchantedItem(Items.NETHERITE_AXE, "OP Axe", builder -> {
            builder.add(enchantmentLookup.getOrThrow(EFFICIENCY), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(SHARPNESS), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(FIRE_ASPECT), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(MENDING), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(UNBREAKING), OP_LEVEL);
        }));
        entries.accept(createEnchantedItem(Items.NETHERITE_PICKAXE, "OP Pickaxe", builder -> {
            builder.add(enchantmentLookup.getOrThrow(EFFICIENCY), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(FORTUNE), FORTUNE_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(MENDING), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(UNBREAKING), OP_LEVEL);
        }));
        entries.accept(createEnchantedItem(Items.NETHERITE_PICKAXE, "OP Silk Touch Pickaxe", builder -> {
            builder.add(enchantmentLookup.getOrThrow(EFFICIENCY), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(SILK_TOUCH), SILK_TOUCH_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(MENDING), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(UNBREAKING), OP_LEVEL);
        }));
        entries.accept(createEnchantedItem(Items.NETHERITE_SHOVEL, "OP Shovel", builder -> {
            builder.add(enchantmentLookup.getOrThrow(EFFICIENCY), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(FORTUNE), FORTUNE_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(MENDING), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(UNBREAKING), OP_LEVEL);
        }));
    }

    private void addOpArmor(Consumer<ItemStack> entries, RegistryWrapper<Enchantment> enchantmentLookup) {
        Consumer<ItemEnchantmentsComponent.Builder> baseArmorEnchants = builder -> {
            builder.add(enchantmentLookup.getOrThrow(PROTECTION), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(FIRE_PROTECTION), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(BLAST_PROTECTION), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(PROJECTILE_PROTECTION), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(THORNS), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(MENDING), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(UNBREAKING), OP_LEVEL);
        };

        entries.accept(createEnchantedItem(Items.NETHERITE_HELMET, "OP Helmet", builder -> {
            baseArmorEnchants.accept(builder);
            builder.add(enchantmentLookup.getOrThrow(RESPIRATION), OP_LEVEL);
        }));
        entries.accept(createEnchantedItem(Items.NETHERITE_CHESTPLATE, "OP Chestplate", baseArmorEnchants));
        entries.accept(createEnchantedItem(Items.NETHERITE_LEGGINGS, "OP Leggings", baseArmorEnchants));
        entries.accept(createEnchantedItem(Items.NETHERITE_BOOTS, "OP Boots", builder -> {
            baseArmorEnchants.accept(builder);
            builder.add(enchantmentLookup.getOrThrow(FEATHER_FALLING), OP_LEVEL);
            builder.add(enchantmentLookup.getOrThrow(SOUL_SPEED), OP_LEVEL);
        }));
    }

    private void addSpecialItems(Consumer<ItemStack> entries) {
        entries.accept(new ItemStack(Blocks.COMMAND_BLOCK));
        entries.accept(new ItemStack(Blocks.BARRIER));
        entries.accept(new ItemStack(Blocks.STRUCTURE_BLOCK));
        entries.accept(new ItemStack(Blocks.STRUCTURE_VOID));
        entries.accept(new ItemStack(Blocks.LIGHT));
        entries.accept(new ItemStack(Items.COMMAND_BLOCK_MINECART));
        entries.accept(new ItemStack(Blocks.DRAGON_EGG));
        entries.accept(new ItemStack(Items.DEBUG_STICK));
        entries.accept(new ItemStack(Blocks.SPAWNER));
        entries.accept(new ItemStack(Items.KNOWLEDGE_BOOK));
    }

    private ItemStack createEnchantedItem(ItemConvertible item, String name, Consumer<ItemEnchantmentsComponent.Builder> enchantmentApplier) {
        ItemStack stack = new ItemStack(item);
        stack.set(DataComponentTypes.CUSTOM_NAME, Text.literal(name));

        var enchantmentsBuilder = new ItemEnchantmentsComponent.Builder(ItemEnchantmentsComponent.DEFAULT);
        enchantmentApplier.accept(enchantmentsBuilder);

        stack.set(DataComponentTypes.ENCHANTMENTS, enchantmentsBuilder.build());
        return stack;
    }
}