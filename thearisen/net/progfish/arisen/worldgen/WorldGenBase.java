package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public abstract class WorldGenBase {

	protected static final int MID_HEIGHT = 63;
	
	protected World worldObj;
	
	public WorldGenBase(World worldObj) {
		this.worldObj = worldObj;
	}

	/**
	 * Called to generate the structure described by the subclass of this class
	 * which implements this method.
	 * @param rand A random initialized with the world seed and chunk coords
	 * @param i The x coordinate to generate at
	 * @param j The y coordinate to generate at
	 * @param k The z coordinate to generate at
	 * @return Whether the generation was successful
	 */
	public abstract boolean generate(Random rand, int i, int j, int k);
	
	/**
	 * Generates a filled circle
	 * @param i The x coordinate to generate at
	 * @param j The y coordinate to generate at
	 * @param k The z coordinate to generate at
	 * @param innerRadius The radius of the circle that forms the inner boundary of the circle gened
	 * @param outerRadius The radius of the circle that forms the outer boundary of the circle gened
	 * @param blockID The block ID to generate
	 * @param metadata The metadata to generate
	 * @param dir 0 = x, z; 1 = x, y; 2 = y, z
	 * @param options 1: Overwrite blocks 2: Delete non-terrain blocks inside 4: Delete all blocks inside; 8: Overwrite non-opaque blocks Can add
	 */
	protected void genCircle(int i, int j, int k, double innerRadius, double outerRadius, int blockID, int metadata, int dir, int options) {
		double outerSq = outerRadius * outerRadius;
		double innerSq = innerRadius * innerRadius;
		for(int x = -(int)outerRadius - 1; x < outerRadius + 1; x++) {
			for(int y = -(int)outerRadius - 1; y < outerRadius + 1; y++) {
				int distanceSq = (x * x) + (y * y);
				if(innerSq <= distanceSq && distanceSq <= outerSq)
				{
					int id;
					switch(dir) {
						case 0:
							id = worldObj.getBlockId(i + x, j, k + y);
							if((options & 1) == 1 || id == 0 || (!Block.blocksList[id].isOpaqueCube() && (options & 8) == 8))
								worldObj.setBlock(i + x, j, k + y, blockID, metadata, 3);
							break;
						case 1:
							id = worldObj.getBlockId(i + x, j + y, k);
							if((options & 1) == 1 || id == 0 || (!Block.blocksList[id].isOpaqueCube() && (options & 8) == 8))
								worldObj.setBlock(i + x, j + y, k, blockID, metadata, 3);
							break;
						case 2:
							id = worldObj.getBlockId(i, j + x, k + y);
							if((options & 1) == 1 || id == 0 || (!Block.blocksList[id].isOpaqueCube() && (options & 8) == 8))
								worldObj.setBlock(i, j + x, k + y, blockID, metadata, 3);
					}
				}
				
				if((options & 2) == 2 && innerSq > distanceSq) {
					int id = 0;
					switch(dir) {
						case 0:
							id = worldObj.getBlockId(i + x, j, k + y);
							break;
						case 1:
							id = worldObj.getBlockId(i + x, j + y, k);
							break;
						case 2:
							id = worldObj.getBlockId(i, j + x, k + y);
					}
					if(!(id == Block.grass.blockID || id == Block.dirt.blockID || id == Block.stone.blockID || id == Block.sand.blockID))
					{
						switch(dir) {
							case 0:
								worldObj.setBlock(i + x, j, k + y, 0);
								break;
							case 1:
								worldObj.setBlock(i + x, j + y, k, 0);
								break;
							case 2:
								worldObj.setBlock(i, j + x, k + y, 0);
						}	
					}
				}
				if((options & 4) == 4 && innerSq > distanceSq) {
					switch(dir) {
						case 0:
							worldObj.setBlock(i + x, j, k + y, 0);
							break;
						case 1:
							worldObj.setBlock(i + x, j + y, k, 0);
							break;
						case 2:
							worldObj.setBlock(i, j + x, k + y, 0);
					}
				}				
			}
		}
	}
	
	/**
	 * Generates a filled sphere
	 * @param i The x coordinate to generate at
	 * @param j The y coordinate to generate at
	 * @param k The z coordinate to generate at
	 * @param innerRadius The radius of the sphere that forms the inner boundary of the sphere gened
	 * @param outerRadius The radius of the sphere that forms the outer boundary of the sphere gened
	 * @param blockID The block ID to generate
	 * @param metadata The metadata to generate
	 * @param options 1: Overwrite blocks 2: Delete non-terrain blocks inside 4: Delete all blocks inside; Can add
	 */
	protected void genSphere(int i, int j, int k, double innerRadius, double outerRadius, int blockID, int metadata, int options) {
		double outerSq = outerRadius * outerRadius;
		double innerSq = innerRadius * innerRadius;
		for(int x = -(int)outerRadius - 1; x < outerRadius + 1; x++) {
			for(int y = -(int)outerRadius - 1; y < outerRadius + 1; y++) {
				for(int z = -(int)outerRadius - 1; z < outerRadius + 1; z++) {
					int distanceSq = (x * x) + (y * y) + (z * z);
					
					if((options & 2) == 2 && innerSq > distanceSq) {
						int id = worldObj.getBlockId(i + x, j + y, k + z);
						if(!(id == Block.grass.blockID || id == Block.dirt.blockID || id == Block.stone.blockID || id == Block.sand.blockID))
						{
							worldObj.setBlock(i + x, j + y, k + z, 0);
						}
					}
					
					if((options & 4) == 4 && innerSq > distanceSq) {
						worldObj.setBlock(i + x, j + y, k + z, 0);
					}
					
					if(innerSq < distanceSq && distanceSq < outerSq && (worldObj.getBlockId(i + x, j + y, k + z) == 0 || ((options & 1) == 1))) {
						worldObj.setBlock(i + x, j + y, k + z, blockID, metadata, 3);
					}
				}
			}
		}
	}
	
	public void genCircleOnTerrain(int i, int k, double innerRadius, double outerRadius, int id, int meta, int lowest) {
		double outerSq = outerRadius * outerRadius;
		double innerSq = innerRadius * innerRadius;
		for(int x = -(int)outerRadius - 1; x < outerRadius + 1; x++) {
			for(int y = -(int)outerRadius - 1; y < outerRadius + 1; y++) {
				int distanceSq = (x * x) + (y * y);
				if(innerSq <= distanceSq && distanceSq <= outerSq)
				{
					int terrainLevel = getTerrainLevelAt(x + i, y + k);
					worldObj.setBlock(x + i, terrainLevel < lowest ? lowest : terrainLevel, y + k, id, meta, 3);
				}			
			}
		}
	}
	
	protected int getTerrainLevelAt(int i, int k) {
		for(int j = 127; j > 0; j--)
		{
			int id = worldObj.getBlockId(i, j, k);
			if(id == Block.grass.blockID || id == Block.dirt.blockID || id == Block.stone.blockID || id == Block.sand.blockID)
			{
				return j;
			}
		}
		return MID_HEIGHT;
	}
		
}
