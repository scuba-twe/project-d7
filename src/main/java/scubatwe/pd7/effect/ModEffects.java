package scubatwe.pd7.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> COPPER_SET_BONUS = registerStatusEffect("copper_set_bonus",
            new CopperSetBonusEffect(StatusEffectCategory.BENEFICIAL, 16750848)
                    .addAttributeModifier(EntityAttributes.MAX_ABSORPTION,
                            Identifier.of(Projectd7.MOD_ID, "copper_set_bonus"), 4.0F,
                            EntityAttributeModifier.Operation.ADD_VALUE));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference
                (Registries.STATUS_EFFECT, Identifier.of(Projectd7.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Projectd7.LOGGER.info("Registering effects for " + Projectd7.MOD_ID);
    }
}
