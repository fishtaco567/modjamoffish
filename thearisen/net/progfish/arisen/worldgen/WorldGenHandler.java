package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.progfish.arisen.MonumentHandler;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator {

	public static WorldGenHandler instance = new WorldGenHandler();
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(MonumentHandler.instance.isReady != true) {
			MonumentHandler.instance.init();
		}
		
		int x = chunkX * 16;
		int z = chunkZ * 16;
		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
		if(biome != BiomeGenBase.hell && biome != BiomeGenBase.sky)
		{
			boolean lichTower = false;
			Random lichTowerRand = new Random(world.getSeed());
			int lichTowerX = ((lichTowerRand.nextInt(32) * 16) - (16 * 16));
			int lichTowerZ = ((lichTowerRand.nextInt(32) * 16) - (16 * 16));
			if(x == lichTowerX && z == lichTowerZ) {
				new WorldGenLichTower(world).generate(rand, x, 0, z);
				lichTower = true;
			}
			
			if(MonumentHandler.instance.coordList.contains(new ChunkCoordinates(x, 0, z))) {
				if(!lichTower) {
					new WorldGenMonument(world).generate(rand, x, rand.nextInt(127), z);
				} else {
					MonumentHandler.instance.removeCoord(new ChunkCoordinates(x, 0, z));
				}
			}
		}
	}
	
}
