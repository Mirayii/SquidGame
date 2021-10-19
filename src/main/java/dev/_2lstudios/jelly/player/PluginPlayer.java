package dev._2lstudios.jelly.player;

import net.kyori.adventure.sound.Sound;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import dev._2lstudios.jelly.utils.ServerUtils;
import org.jetbrains.annotations.NotNull;

public class PluginPlayer {
    private final Player player;

    public PluginPlayer(final Player player) {
        this.player = player;
    }

    public Player getBukkitPlayer() {
        return this.player;
    }

    public void playSound(final @NotNull Sound sound) {
        this.getBukkitPlayer().playSound(sound, Sound.Emitter.self());
    }

    public void teleport(final Location loc) {
        this.getBukkitPlayer().teleport(loc);
    }

    public void sendTitle(final String title, final String subtitle, final int duration) {
        this.sendTitle(title, subtitle, 2, duration * 20, 2);
    }

    @SuppressWarnings("deprecation")
    public void sendTitle(final String title, final String subtitle, final int fadeInTime, final int showTime,
            final int fadeOutTime) {
        if (ServerUtils.isLegacy()) {
            this.getBukkitPlayer().resetTitle();
            this.getBukkitPlayer().sendTitle(title, subtitle);
        } else {
            this.getBukkitPlayer().sendTitle(title, subtitle, fadeInTime, showTime, fadeOutTime);
        }
    }

    public void playSound(org.bukkit.Sound sound) {
        if (sound != null) {
            this.getBukkitPlayer().playSound(this.getBukkitPlayer().getLocation(), sound, 1, 1);
        }
    }
}
