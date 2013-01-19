package ru.obsidian_mc.toxuin;

import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.sacredlabyrinth.phaed.simpleclans.ClanPlayer;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;

import com.bekvon.bukkit.residence.event.ResidenceFlagCheckEvent;
import com.bekvon.bukkit.residence.protection.FlagPermissions;

public class SimpleClansResidence extends JavaPlugin implements Listener {
	public static String prefix = null;
	public static Logger log = Logger.getLogger("Minecraft");
	private SimpleClans sc;

	@Override
	public void onEnable(){
		prefix = "[" + this.getDescription().getName()+ "]: ";
		this.getServer().getPluginManager().registerEvents(this, this);
		
		// ADD NEW FLAG
		if (this.getServer().getPluginManager().isPluginEnabled("Residence")) {
			FlagPermissions.addResidenceOnlyFlag("clanmove");
			FlagPermissions.addResidenceOnlyFlag("clanbuild");
			FlagPermissions.addResidenceOnlyFlag("clanuse");
			FlagPermissions.addResidenceOnlyFlag("clancontainer");
		} else {
			log.info(prefix+"ERROR: Residence NOT FOUND!!!");
		}
		
		Plugin plug = getServer().getPluginManager().getPlugin("SimpleClans");
	    if (plug != null) sc = ((SimpleClans) plug); else log.info(prefix+"ERROR: SimpleClans NOT FOUND!!!");
	    
	}
	
	@Override
	public void onDisable(){
		sc = null;
		log.info( prefix + "Disabled.");
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onResidenceFlagCheck(ResidenceFlagCheckEvent event) {
		if (event.getFlagTargetPlayerOrGroup() == null) return;
		if (event.getResidence().getOwner().equals(event.getFlagTargetPlayerOrGroup())) return;
		
		if (event.getFlag().equals("build")) {
			if (!event.getResidence().getPermissions().has("clanbuild", false)) return;
			
			ClanPlayer hostClanPlayer = sc.getClanManager().getClanPlayer(event.getResidence().getOwner());
			if (hostClanPlayer==null) return;
			
			ClanPlayer visitorClanPlayer = sc.getClanManager().getClanPlayer(event.getFlagTargetPlayerOrGroup());
			if (visitorClanPlayer==null) return;
			
			if (hostClanPlayer !=null && visitorClanPlayer != null && visitorClanPlayer.getClan().equals(hostClanPlayer.getClan())) {
				//event.override = true;
				//event.overridevalue = true;
                                event.overrideCheck(true);
			}
			
		} else if (event.getFlag().equals("use")) {
			if (!event.getResidence().getPermissions().has("clanuse", false)) return;
			
			ClanPlayer hostClanPlayer = sc.getClanManager().getClanPlayer(event.getResidence().getOwner());
			if (hostClanPlayer==null) return;
			
			ClanPlayer visitorClanPlayer = sc.getClanManager().getClanPlayer(event.getFlagTargetPlayerOrGroup());
			if (visitorClanPlayer==null) return;
			
			if (hostClanPlayer !=null && visitorClanPlayer != null && visitorClanPlayer.getClan().equals(hostClanPlayer.getClan())) {
				//event.override = true;
				//event.overridevalue = true;
                                event.overrideCheck(true);
			}
		} else if (event.getFlag().equals("move")) {
			if (!event.getResidence().getPermissions().has("clanmove", false)) return;
			
			ClanPlayer hostClanPlayer = sc.getClanManager().getClanPlayer(event.getResidence().getOwner());
			if (hostClanPlayer==null) return;
			
			ClanPlayer visitorClanPlayer = sc.getClanManager().getClanPlayer(event.getFlagTargetPlayerOrGroup());
			if (visitorClanPlayer==null) return;
			
			if (hostClanPlayer !=null && visitorClanPlayer != null && visitorClanPlayer.getClan().equals(hostClanPlayer.getClan())) {
				//event.override = true;
				//event.overridevalue = true;
                                event.overrideCheck(true);
			}
			
		} else if (event.getFlag().equals("container")) {
			if (!event.getResidence().getPermissions().has("clancontainer", false)) return;
			
			ClanPlayer hostClanPlayer = sc.getClanManager().getClanPlayer(event.getResidence().getOwner());
			if (hostClanPlayer==null) return;
			
			ClanPlayer visitorClanPlayer = sc.getClanManager().getClanPlayer(event.getFlagTargetPlayerOrGroup());
			if (visitorClanPlayer==null) return;
			
			if (hostClanPlayer !=null && visitorClanPlayer != null && visitorClanPlayer.getClan().equals(hostClanPlayer.getClan())) {
				//event.override = true;
				//event.overridevalue = true;
                                event.overrideCheck(true);
			}
			
		}
	}
}
