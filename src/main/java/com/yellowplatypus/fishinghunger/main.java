package com.yellowplatypus.FishingHunger;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {	
    
    @Override
    public void onEnable() {
	try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Creating Config.yml");
                saveDefaultConfig();
            }   
        } 
        catch (Exception e) {}
	Bukkit.getServer().getConsoleSender().sendMessage("[FishingHunger] Enabled.");
	Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }
    
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[FishingHunger] Disabled.");
    }
    
    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {
        if (event.getState().equals(PlayerFishEvent.State.FISHING)){
            Player player = event.getPlayer();  
            float penalty = (float)getConfig().getDouble("penalty");
            float exhaustion = player.getExhaustion();
            player.setExhaustion(exhaustion + penalty);
        }
    }    
} 
