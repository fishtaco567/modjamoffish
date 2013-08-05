package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.progfish.arisen.blocks.ArisenBlocks;

public class WorldGenCone extends WorldGenMonumentBase {

	private static final int CONE_BLOCK = Block.cobblestoneMossy.blockID;
	
	public WorldGenCone(World worldObj) {
		super(worldObj);
	}
	
	public WorldGenCone() {
		super();
	}

	@Override
	public WorldGenMonumentBase makeGenerator(World world) {
		return new WorldGenCone(world);
	}

	@Override
	public boolean generate(Random rand, int i, int j, int k) {
		j = getTerrainLevelAt(i, k);
		if(rand.nextInt(10) == 0) {
			j += rand.nextInt(20) + 20;
		}
		int dir = rand.nextInt(6); //x++, x--, y++, y--, z++, z--
		int genDir = 0;
		int xMod = 0;
		int yMod = 0;
		int zMod = 0;
		switch(dir) {
			case 0:
				xMod = 1;
				genDir = 2;
				break;
			case 1:
				xMod = -1;
				genDir = 2;
				break;
			case 2:
				yMod = 1;
				genDir = 0;
				break;
			case 3:
				yMod = -1;
				genDir = 0;
				break;
			case 4:
				zMod = 1;
				genDir = 1;
				break;
			case 5:
				zMod = -1;
				genDir = 1;
				break;
		}
		
		int length = rand.nextInt(5) + 10;
		int size = 1;
		int wMod = rand.nextInt(2) + 2;
		
		for(int w = 0; w < length; w++) {
			genCircle(i, j, k, size - 1, size, CONE_BLOCK, 0, genDir, 5);
			if(w == 0) {
				worldObj.setBlock(i, j, k, ArisenBlocks.monument.blockID);
			}
			i += xMod;
			j += yMod;
			k += zMod;
			if(w % wMod == 0) {
				size++;
			}
		}
		
		return true;
	}

}
