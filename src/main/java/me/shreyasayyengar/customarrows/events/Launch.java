package me.shreyasayyengar.customarrows.events;

import me.shreyasayyengar.customarrows.CustomArrowsPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Launch implements Listener {

    @EventHandler
    private void onLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof Player player) {

            Projectile projectile = e.getEntity();
            Vector projectileVector = projectile.getVelocity();
            Location projectileLocation = projectile.getLocation();

            if (player.getInventory().getItemInOffHand().getItemMeta() != null) {
                ItemMeta itemMeta = player.getInventory().getItemInOffHand().getItemMeta();

                switch (itemMeta.getLocalizedName()) {
                    case "arrows.bundle" -> {
                        Arrow one = player.getWorld().spawnArrow(e.getEntity().getLocation().add(0.2, 0, 0.2), projectileVector, 1, 1);
                        Arrow two = player.getWorld().spawnArrow(e.getEntity().getLocation().add(0.4, 0, 0.4), projectileVector, 1, 1);
                        Arrow three = player.getWorld().spawnArrow(e.getEntity().getLocation().add(-0.2, 0, -0.2), projectileVector, 1, 1);
                        Arrow four = player.getWorld().spawnArrow(e.getEntity().getLocation().add(-0.4, 0, -0.4), projectileVector, 1, 1);

                        one.setVelocity(projectileVector);
                        one.setBounce(false);
                        two.setVelocity(projectileVector);
                        two.setBounce(false);
                        three.setVelocity(projectileVector);
                        three.setBounce(false);
                        four.setVelocity(projectileVector);
                        four.setBounce(false);

                    }

                    case "arrows.crystal" -> projectile.setGravity(false);

                    case "arrows.infinity" -> {

                        ItemStack arrow = player.getInventory().getItemInOffHand().clone();
                        arrow.setAmount(1);

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                player.getInventory().addItem(arrow);
                            }
                        }.runTaskLater(CustomArrowsPlugin.getInstance(), 40);
//                        {
//
//                            final Location[] loc = new Location[1];
//                            new BukkitRunnable() {
//
//                                @Override
//                                public void run() {
//                                    loc[0] = projectile.getLocation();
//                                    projectile.remove();
//                                }
//                            }.runTaskLater(CustomArrowsPlugin.getInstance(), 40);
//
//
//                            new BukkitRunnable() {
//                                @Override
//                                public void run() {
//                                    Vector direction = player.getLocation().subtract(loc[0]).toVector();
//
//                                    Entity returningArrow = loc[0].getWorld().spawnEntity(loc[0].add(0, 1, 0), EntityType.ARROW);
//
//                                    new BukkitRunnable() {
//
//                                        @Override
//                                        public void run() {
//                                            returningArrow.setVelocity(direction);
//                                        }
//                                    }.runTaskLater(CustomArrowsPlugin.getInstance(), 1);
//
//                                    returningArrow.setGlowing(true);
//                                }
//                            }.runTaskLater(CustomArrowsPlugin.getInstance(), 41);
//                        }
                    }
                }
            }
        }
    }
}
