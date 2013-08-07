package net.progfish.arisen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.Configuration;
import net.progfish.arisen.blocks.ArisenBlocks;
import net.progfish.arisen.client.item.ArisenItems;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Config {

	private static Configuration config;
	private static File optOutFile;
	public static ArrayList<String> optOutList = new ArrayList();
	
	public static void loadConfig(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		optOutFile = new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + "arisenopt.cfg");
		if(optOutFile.exists() && optOutFile.canRead()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(optOutFile));
				while(reader.ready()) {
					optOutList.add(reader.readLine());
				}
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				optOutFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ArisenBlocks.forcefieldID = config.getBlock("Forcefield", ArisenBlocks.forcefieldID).getInt();
		ArisenBlocks.abyssBrickID = config.getBlock("AbyssBrick", ArisenBlocks.abyssBrickID).getInt();
		ArisenBlocks.abyssBarrierID = config.getBlock("AbyssBarrier", ArisenBlocks.abyssBarrierID).getInt();
		ArisenBlocks.monumentID = config.getBlock("Monument", ArisenBlocks.monumentID).getInt();
		ArisenBlocks.indicatorID = config.getBlock("Indicator", ArisenBlocks.indicatorID).getInt();
		
		ArisenItems.monumentDustID = config.getItem("MonumentDust", ArisenItems.monumentDustID).getInt();
		ArisenItems.monumentFinderID = config.getItem("MonumentFinder", ArisenItems.monumentFinderID).getInt();
	}
	
	public static void addOptOut(String name) {
		optOutList.add(name);
		save();
	}
	
	public static void save()
	{
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(optOutFile));
			for(String name : optOutList) {
				writer.println(name);
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
