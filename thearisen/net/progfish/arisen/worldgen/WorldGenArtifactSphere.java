package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenArtifactSphere extends WorldGenBase {

	public WorldGenArtifactSphere(World worldObj) {
		super(worldObj);
	}

	@Override
	public boolean generate(Random rand, int i, int j, int k) {
		System.out.println("Called");
		int size = rand.nextInt(10) + 15;
		for(int x = i - size; x < i + size; x++) {
			for(int z = k - size; z < k + size; z++) {
				if(getTerrainLevelAt(x, z) < MID_HEIGHT)
				{
					System.out.println("Failed at: " + x + ", " + z);
					return false;
				}
			}
		}
		
		genSphere(i, getTerrainLevelAt(i, k), k, size - 2, size, Block.stone.blockID, 0, 5);
		
		return true;
	}

	
	
}
