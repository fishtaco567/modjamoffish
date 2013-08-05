package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.progfish.arisen.blocks.ArisenBlocks;

public class WorldGenArtifactSphere extends WorldGenMonumentBase {

	private static final int SPHERE_BLOCK = Block.cobblestoneMossy.blockID;
	
	public WorldGenArtifactSphere(World worldObj) {
		super(worldObj);
	}
	
	public WorldGenArtifactSphere() {
		super(null);
	}

	@Override
	public boolean generate(Random rand, int i, int j, int k) {
		System.out.println("Called");
		int size = rand.nextInt(10) + 15;
		
		int terrainLevel = getTerrainLevelAt(i, k);
		if(terrainLevel < 63)
		{
			terrainLevel = 63;
		}
		
		genSphere(i, terrainLevel, k, size - 2, size, SPHERE_BLOCK, 0, 3);
		genCircleOnTerrain(i, k, 0, size, SPHERE_BLOCK, 0, terrainLevel);
		
		int pedHeight = rand.nextInt(3) + 4;
		for(int y = terrainLevel; y < terrainLevel + pedHeight; y++)
		{
			worldObj.setBlock(i, y, k, SPHERE_BLOCK);			
		}
		worldObj.setBlock(i, terrainLevel + pedHeight, k, ArisenBlocks.monument.blockID);
		
		return true;
	}

	@Override
	public WorldGenMonumentBase makeGenerator(World world) {
		return new WorldGenArtifactSphere(world);
	}
	
}
