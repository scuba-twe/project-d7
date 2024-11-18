package scubatwe.pd7;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scubatwe.pd7.block.ModBlocks;
import scubatwe.pd7.component.ModDataComponentTypes;
import scubatwe.pd7.effect.ModEffects;
import scubatwe.pd7.item.ModItems;
import scubatwe.pd7.item.ModItemGroups;
import scubatwe.pd7.loot.ModLootTables;
import scubatwe.pd7.recipe.ModRecipeBookCategory;
import scubatwe.pd7.recipe.ModRecipeSerializer;
import scubatwe.pd7.recipe.ModRecipeType;
import scubatwe.pd7.world.gen.ModWorldGeneration;

public class Projectd7 implements ModInitializer {
	public static final String MOD_ID = "pd7";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		ModEffects.registerEffects();

		ModDataComponentTypes.registerDataComponentTypes();

		ModRecipeType.registerModRecipeTypes();
		ModRecipeSerializer.registerModRecipeSerializer();
		ModRecipeBookCategory.registerModRecipeBookCategories();

		ModLootTables.registerModLootTables();

		ModWorldGeneration.generateModWorldGen();
	}
}