package me.shreyasayyengar.customarrows;

import me.shreyasayyengar.customarrows.events.Hit;
import me.shreyasayyengar.customarrows.events.Launch;
import me.shreyasayyengar.customarrows.events.PickUp;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomArrowsPlugin extends JavaPlugin {

    private static CustomArrowsPlugin INSTANCE;

    public static CustomArrowsPlugin getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {
        INSTANCE = this;

        registerCommands();
        registerEvents();
        registerRecipes();
    }

    private void registerRecipes() {

        ShapedRecipe bundleRecipe = new ShapedRecipe(new NamespacedKey(this, "arrow_bundle"), Utility.supplyBundleArrows(true));
        bundleRecipe.shape("111", "111", "111");
        bundleRecipe.setIngredient('1', Material.ARROW);
        this.getServer().addRecipe(bundleRecipe);

        ShapedRecipe diamondRecipe = new ShapedRecipe(new NamespacedKey(this, "arrow_diamond"), Utility.supplyDiamondArrow(true));
        diamondRecipe.shape("^^^", "^B^", "^^^");
        diamondRecipe.setIngredient('^', Material.DIAMOND);
        diamondRecipe.setIngredient('B', new RecipeChoice.ExactChoice(Utility.supplyBundleArrows(true)));
        this.getServer().addRecipe(diamondRecipe);

        ShapedRecipe fishRecipe = new ShapedRecipe(new NamespacedKey(this, "arrow_fish"), Utility.supplyFishArrow(true));
        fishRecipe.shape("^#^", "#A#", "^#^");
        fishRecipe.setIngredient('^', Material.SALMON);
        fishRecipe.setIngredient('#', Material.COD);
        fishRecipe.setIngredient('A', Material.ARROW);
        this.getServer().addRecipe(fishRecipe);

        ShapelessRecipe endCrystalRecipe = new ShapelessRecipe(new NamespacedKey(this, "arrow_crystal"), Utility.supplyEndCrystalArrow(true));
        endCrystalRecipe.addIngredient(1, Material.END_CRYSTAL);
        endCrystalRecipe.addIngredient(new RecipeChoice.ExactChoice(Utility.supplyFishArrow(false)));
        this.getServer().addRecipe(endCrystalRecipe);

        ShapelessRecipe infinityRecipe = new ShapelessRecipe(new NamespacedKey(this, "arrow_infinity"), Utility.supplyInfinityArrow(true));
        infinityRecipe.addIngredient(new RecipeChoice.ExactChoice(Utility.supplyBundleArrows(false)));
        infinityRecipe.addIngredient(new RecipeChoice.ExactChoice(Utility.supplyDiamondArrow(false)));
        infinityRecipe.addIngredient(new RecipeChoice.ExactChoice(Utility.supplyEndCrystalArrow(false)));
        infinityRecipe.addIngredient(new RecipeChoice.ExactChoice(Utility.supplyFishArrow(false)));
        infinityRecipe.addIngredient(1, Material.DIAMOND_BLOCK);
        this.getServer().addRecipe(infinityRecipe);


    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new Launch(), this);
        this.getServer().getPluginManager().registerEvents(new Hit(), this);
        this.getServer().getPluginManager().registerEvents(new PickUp(), this);
    }

    private void registerCommands() {

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
