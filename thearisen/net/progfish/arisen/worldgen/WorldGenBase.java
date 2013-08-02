package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.world.World;

public abstract class WorldGenBase {

	public World worldObj;
	
	public WorldGenBase(World worldObj) {
		
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
	 * @param shouldReplace Whether the circle should generate over another block
	 */
	public void genCircle(int i, int j, int k, double innerRadius, double outerRadius, int blockID, int metadata, int dir, boolean shouldReplace) {
		double outerSq = outerRadius * outerRadius;
		double innerSq = innerRadius * innerRadius;
		for(int x = -(int)outerRadius; x < outerRadius; x++) {
			for(int y = -(int)outerRadius; y < outerRadius; y++) {
				int distanceSq = (x * x) + (y * y);
				if(innerSq < distanceSq && distanceSq < outerSq)
				{
					switch(dir) {
						case 0:
							if(worldObj.getBlockId(i + x, j, k + y) == 0 || shouldReplace)
							worldObj.setBlock(i + x, j, k + y, blockID, metadata, 3);
						case 1:
							if(worldObj.getBlockId(i + x, j + y, k) == 0 || shouldReplace)
							worldObj.setBlock(i + x, j + y, k, blockID, metadata, 3);
						case 2:
							if(worldObj.getBlockId(i, j + x, k + y) == 0 || shouldReplace)
							worldObj.setBlock(i, j + x, k + y, blockID, metadata, 3);
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
	 * @param shouldReplace Whether the sphere should generate over another block
	 */
	public void genSphere(int i, int j, int k, double innerRadius, double outerRadius, int blockID, int metadata, boolean shouldReplace) {
		double outerSq = outerRadius * outerRadius;
		double innerSq = innerRadius * innerRadius;
		for(int x = -(int)outerRadius; x < outerRadius; x++) {
			for(int y = -(int)outerRadius; y < outerRadius; y++) {
				for(int z = -(int)outerRadius; z < outerRadius; z++) {
					int distanceSq = (x * x) + (y * y) + (z * z);
					if(innerSq < distanceSq && distanceSq < outerSq && (worldObj.getBlockId(i + x, j + y, k + z) == 0 || shouldReplace))
					{
						worldObj.setBlock(i + x, j + y, k + z, blockID, metadata, 3);
					}
				}
			}
		}
	}
		
}
