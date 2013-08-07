package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.progfish.arisen.WorldSaveHandler;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator {

	public static WorldGenHandler instance = new WorldGenHandler();
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(WorldSaveHandler.instance.isReady != true) {
			WorldSaveHandler.instance.init();
		}
		
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
		if(biome != BiomeGenBase.hell && biome != BiomeGenBase.sky)
		{
			boolean lichTower = false;
			Random lichTowerRand = new Random(world.getSeed());
			if(x == 0 && z == 0) {
				new WorldGenLichTower(world).generate(rand, x, 0, z);
				lichTower = true;
			}
			
			if(WorldSaveHandler.instance.coordList.contains(new ChunkCoordinates(x, 0, z))) {
				if(!lichTower) {
					new WorldGenMonument(world).generate(rand, x, rand.nextInt(127), z);
				} else {
					WorldSaveHandler.instance.removeCoord(new ChunkCoordinates(x, 0, z));
				}
			}
		}
	}
	
}
