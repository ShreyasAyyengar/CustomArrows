package me.shreyasayyengar.customarrows.events;

import me.shreyasayyengar.customarrows.CustomArrowsPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.ThreadLocalRandom;

public class Hit implements Listener {

    @EventHandler
    private void onHit(ProjectileHitEvent e) {
        Projectile projectile = e.getEntity();
        ProjectileSource shooter = projectile.getShooter();

        if (shooter instanceof Player player) {

            if (e.getHitEntity() != null) {

                Entity hitEntity = e.getHitEntity();
                Location location = hitEntity.getLocation();

                if (player.getInventory().getItemInOffHand().getItemMeta() != null) {

                    ItemMeta itemMeta = player.getInventory().getItemInOffHand().getItemMeta();

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            switch (itemMeta.getLocalizedName()) {
                                case "arrows.diamond" -> {
                                    if (hitEntity.isDead()) {

                                        if (ThreadLocalRandom.current().nextInt(0, 2) == 1) {
                                            hitEntity.getWorld().dropItemNaturally(location, new ItemStack(Material.DIAMOND));
                                        } else
                                            hitEntity.getWorld().dropItemNaturally(location, new ItemStack(Material.GOLD_INGOT));
                                    }

                                }

                                case "arrows.fish" -> {

                                    if (hitEntity instanceof Mob && !(hitEntity instanceof Boss)) {

                                        int randomNum = ThreadLocalRandom.current().nextInt(0, 4);

                                        if (randomNum == 0) {
                                            hitEntity.getWorld().spawnEntity(location, EntityType.COD);
                                        } else if (randomNum == 1) {
                                            hitEntity.getWorld().spawnEntity(location, EntityType.SALMON);
                                        } else if (randomNum == 2) {
                                            hitEntity.getWorld().spawnEntity(location, EntityType.PUFFERFISH);
                                        } else if (randomNum == 3) {
                                            hitEntity.getWorld().spawnEntity(location, EntityType.TROPICAL_FISH);
                                        }
                                    }
                                    hitEntity.remove();

                                }

                                case "arrows.infinity" -> {
                                    if (e.getHitEntity() instanceof Mob mob) {
                                        if (mob.getHealth() > 4) {
                                            mob.setHealth(mob.getHealth() / 2);
                                        }
                                    }
                                }
                            }

                        }
                    }.runTaskLater(CustomArrowsPlugin.getInstance(), 1);

                }
            }
        }
    }
}
