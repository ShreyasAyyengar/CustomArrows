package me.shreyasayyengar.customarrows;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class Utility {

    public static String colourise(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    // Supply ItemStacks
    public static ItemStack supplyBundleArrows(boolean shouldIncludeAmount) {
        ItemStack bundleArrows = new ItemStack(Material.ARROW);
        if (shouldIncludeAmount) {
            bundleArrows.setAmount(32);
        }

        ItemMeta arrowMeta = bundleArrows.getItemMeta();
        arrowMeta.setLocalizedName("arrows.bundle");
        arrowMeta.setCustomModelData(100);
        arrowMeta.setDisplayName(colourise("&eBundle of Arrows"));
        arrowMeta.setLore(Collections.singletonList("Fires multiple arrows!"));
        bundleArrows.setItemMeta(arrowMeta);

        return bundleArrows;
    }

    public static ItemStack supplyDiamondArrow(boolean shouldIncludeAmount) {
        ItemStack diamondArrow = new ItemStack(Material.ARROW);
        if (shouldIncludeAmount) {
            diamondArrow.setAmount(16);
        }

        ItemMeta arrowMeta = diamondArrow.getItemMeta();
        arrowMeta.setLocalizedName("arrows.diamond");
        arrowMeta.setCustomModelData(200);
        arrowMeta.setDisplayName(colourise("&bDiamond Arrow"));
        arrowMeta.setLore(Arrays.asList("Killed mobs will drop diamonds and gold!"));
        diamondArrow.setItemMeta(arrowMeta);

        return diamondArrow;
    }

    public static ItemStack supplyEndCrystalArrow(boolean shouldIncludeAmount) {
        ItemStack crystalArrow = new ItemStack(Material.ARROW);

        if (shouldIncludeAmount) {
            crystalArrow.setAmount(16);
        }

        ItemMeta arrowMeta = crystalArrow.getItemMeta();
        arrowMeta.setLocalizedName("arrows.crystal");
        arrowMeta.setCustomModelData(400);
        arrowMeta.setDisplayName(colourise("&dEnd Crystal Arrow"));
        arrowMeta.setLore(Arrays.asList("Fast laser-like projectile", colourise("&aPierces Mobs")));
        crystalArrow.setItemMeta(arrowMeta);

        return crystalArrow;
    }

    public static ItemStack supplyFishArrow(boolean shouldIncludeAmount) {
        ItemStack fishArrow = new ItemStack(Material.ARROW);
        if (shouldIncludeAmount) {
            fishArrow.setAmount(32);
        }

        ItemMeta arrowMeta = fishArrow.getItemMeta();
        arrowMeta.setLocalizedName("arrows.fish");
        arrowMeta.setCustomModelData(500);
        arrowMeta.setDisplayName(colourise("&eFish Arrow"));
        arrowMeta.setLore(Arrays.asList("Turns any hit mob into", "any Minecraft fish variant!"));
        fishArrow.setItemMeta(arrowMeta);

        return fishArrow;
    }

    public static ItemStack supplyInfinityArrow(boolean shouldIncludeAmount) {
        ItemStack infinityArrow = new ItemStack(Material.ARROW);
        if (shouldIncludeAmount) {
            infinityArrow.setAmount(5);
        }

        ItemMeta arrowMeta = infinityArrow.getItemMeta();
        arrowMeta.setLocalizedName("arrows.infinity");
        arrowMeta.setCustomModelData(600);
        arrowMeta.setDisplayName(colourise("&6&lInfinity Arrow"));
        arrowMeta.setLore(Arrays.asList("When shot, deals a lot of damage to the mob!", "Boomerangs back to the player's inventory", "after two seconds!"));
        infinityArrow.setItemMeta(arrowMeta);

        return infinityArrow;
    }


}
