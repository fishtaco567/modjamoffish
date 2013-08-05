package net.progfish.arisen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import net.minecraft.server.MinecraftServer;
import net.progfish.arisen.blocks.ArisenBlocks;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Config {

	public static void loadConfig() {
		File configFile = new File(getSaveFolderPath() + "config" + File.separator + "arisenmod.cfg");
		boolean created = false;
		if(!configFile.exists() || !configFile.canRead()) {
			try {
				configFile.createNewFile();
				created = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties config = new Properties();
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(created) {
			config.put("Forcefield ID", Integer.toString(ArisenBlocks.forcefieldID));
			config.put("Abyssal Brick ID", Integer.toString(ArisenBlocks.abyssBrickID));
			config.put("Abyssal Barrier ID", Integer.toString(ArisenBlocks.abyssBarrierID));
			config.put("Monument ID", Integer.toString(ArisenBlocks.monumentID));
			config.put("Indicator ID", Integer.toString(ArisenBlocks.indicatorID));		
			FileOutputStream out;
			try {
				out = new FileOutputStream(configFile);
				config.store(out, "");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArisenBlocks.forcefieldID = Integer.parseInt(config.getProperty("Forcefield ID", Integer.toString(ArisenBlocks.forcefieldID)));
		ArisenBlocks.abyssBrickID = Integer.parseInt(config.getProperty("Abyssal Brick ID", Integer.toString(ArisenBlocks.abyssBrickID)));
		ArisenBlocks.abyssBarrierID = Integer.parseInt(config.getProperty("Abyssal Barrier ID", Integer.toString(ArisenBlocks.abyssBarrierID)));
		ArisenBlocks.monumentID = Integer.parseInt(config.getProperty("Monument ID", Integer.toString(ArisenBlocks.monumentID)));
		ArisenBlocks.indicatorID = Integer.parseInt(config.getProperty("Indicator ID", Integer.toString(ArisenBlocks.indicatorID)));
	}
	
	public static String getSaveFolderPath() {
    	if (MinecraftServer.getServer() == null || MinecraftServer.getServer().isSinglePlayer()) {
    		return getClientSidePath() + File.separator;
    	} else {
    		return new File(".").getAbsolutePath() + File.separator;
    	}	
    }
	
	@SideOnly(Side.CLIENT)
	public static String getClientSidePath() {
		return FMLClientHandler.instance().getClient().mcDataDir.getPath();
	}
	
}
