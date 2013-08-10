package net.progfish.arisen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.progfish.arisen.network.ArisenPacketHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class WorldSaveHandlerServer {

	private File saveFile;
	private ArrayList<ChunkCoordinates> coordList = new ArrayList();
	private boolean lichKilled = false;
	public boolean isReady = false;
	
	public static WorldSaveHandlerServer instance = new WorldSaveHandlerServer();
	
	public WorldSaveHandlerServer() {
		
	}
	
	public void init() {
		if(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0) != null)
		{
			saveFile = new File(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0).getChunkSaveLocation(), "arisen.txt");
			if(saveFile.exists() && saveFile.canRead()) {
				load(saveFile);
			} else {
				try {
					if(saveFile.createNewFile())
					{
						create(saveFile);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			isReady = true;
		}
	}
	
	public void setLichKilled(Boolean killed) {
		this.lichKilled = killed;
		MinecraftServer.getServer().getConfigurationManager().sendPacketToAllPlayers(ArisenPacketHandler.getMonumentPacket());
	}
	
	public boolean getLichKilled() {
		return this.lichKilled;
	}
	
	public void removeCoord(ChunkCoordinates c) {
		coordList.remove(c);
		MinecraftServer.getServer().getConfigurationManager().sendPacketToAllPlayers(ArisenPacketHandler.getMonumentPacket());
	}
	
	public void addCoord(ChunkCoordinates c) {
		coordList.add(c);
		MinecraftServer.getServer().getConfigurationManager().sendPacketToAllPlayers(ArisenPacketHandler.getMonumentPacket());
	}
	
	public ArrayList<ChunkCoordinates> getCoordList() {
		return coordList;
	}
	
	public void load(File f) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			while(reader.ready()) {
				String string = reader.readLine();
				if(string.equals("lich")) {
					lichKilled = false;
				} else if(string.equals("lichkill")) {
					lichKilled = true;
				} else {
					String[] coords = string.split(" ");
					coordList.add(new ChunkCoordinates(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2])));
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void create(File f) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter(f));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int minDistSquared = 36;
		int created = 0;
		Random rand = new Random(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0).getSeed());
		int lastX = Integer.MAX_VALUE;
		int lastZ = Integer.MAX_VALUE;
		for(int i = 0; i < 1000; i++) {
			int x = rand.nextInt(64) - 32;
			int z = rand.nextInt(64) - 32;
			int distSquared = x * x + z * z;
			if(distSquared >= minDistSquared) {
				x *= 16;
				z *= 16;
				addCoord(new ChunkCoordinates(x, 0, z));
				lastX = x;
				lastZ = z;
				writer.println(x + " " + "0" + " " + z);
				created++;
			}
			if(created == 12 ) {
				writer.println("lich");
				break;
			}
		}
		writer.close();
	}
	
	public static void close() {
		if(instance != null && instance.saveFile != null)
		{
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(new FileWriter(instance.saveFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(ChunkCoordinates coords : instance.coordList) {
				writer.println(coords.posX + " " + "0" + " " + coords.posZ);
			}
			if(!instance.lichKilled) {
				writer.println("lich");
			} else {
				writer.println("lichkill");
			}
			writer.close();
		}
		instance = new WorldSaveHandlerServer();
	}
	
}
