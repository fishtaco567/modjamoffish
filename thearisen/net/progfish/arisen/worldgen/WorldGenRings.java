package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.progfish.arisen.blocks.ArisenBlocks;

public class WorldGenRings extends WorldGenMonumentBase {

	private static final int RING_BLOCK = Block.cobblestoneMossy.blockID;
	
	public WorldGenRings(World worldObj) {
		super(worldObj);
	}
	
	public WorldGenRings() {
		super();
	}

	@Override
	public WorldGenMonumentBase makeGenerator(World world) {
		return new WorldGenRings(world);
	}

	@Override
	public boolean generate(Random rand, int i, int j, int k) {
		j = getTerrainLevelAt(i, k);
		if(rand.nextInt(10) == 0) {
			j += rand.nextInt(20) + 20;
		}
		int size = rand.nextInt(10) + 8;
		genCircle(i, j, k, size - 1, size, RING_BLOCK, 0, 0, 1);
		genCircle(i, j, k, size - 1, size, RING_BLOCK, 0, 1, 1);
		genCircle(i, j, k, size - 1, size, RING_BLOCK, 0, 2, 1);
		
		int x = i - size;
		int y = j - size;
		int z = k - size;
		for(int w = 0; w < size * 2; w++) {
			if(w != size - 1 && w != size + 1) {
				worldObj.setBlock(x, j, k, RING_BLOCK);
				worldObj.setBlock(i, y, k, RING_BLOCK);
				worldObj.setBlock(i, j, z, RING_BLOCK);
			}
			x++;
			y++;
			z++;
		}
		
		worldObj.setBlock(i, j, k, ArisenBlocks.monument.blockID);
		
		return true;
	}

}
