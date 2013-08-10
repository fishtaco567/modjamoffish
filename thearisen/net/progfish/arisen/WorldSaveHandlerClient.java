package net.progfish.arisen;

import java.io.File;
import java.util.ArrayList;

import net.minecraft.util.ChunkCoordinates;

public class WorldSaveHandlerClient {

	public static ArrayList<ChunkCoordinates> coordList = new ArrayList();
	public static boolean lichKilled = false;
	public static boolean isReady = false;
	
	public static void setInfo(ArrayList<ChunkCoordinates> list, boolean killed) {
		coordList = list;
		lichKilled = killed;
		isReady = true;
		
	}
	
	public static ChunkCoordinates getNearestMonument(double par2, double par4) {
		double distance = Integer.MAX_VALUE;
		int coord = -1;
		for(int i = 0; i < coordList.size(); i++)
		{
			ChunkCoordinates coords = coordList.get(i);
			double td = Math.sqrt((par2 - coords.posX) * (par2 - coords.posX) + (par4 - coords.posZ) * (par4 - coords.posZ));
			if(td < distance) {
				distance = td;
				coord = i;
			}
		}
		if(coord != -1)
		{
			return coordList.get(coord);
		}
		return new ChunkCoordinates(0, 0, 0);
	}
	
}
