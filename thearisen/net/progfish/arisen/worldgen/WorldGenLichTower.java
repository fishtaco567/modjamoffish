package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.progfish.arisen.ArisenMod;
import net.progfish.arisen.blocks.ArisenBlocks;
import net.progfish.arisen.entities.EntityLich;

public class WorldGenLichTower extends WorldGenBase {

	private static final float PI = 3.14159265F;
	private static final int MAX_TERRAIN_HEIGHT = 127;
	private static final int MAX_RADIUS = 15;
	private static final int MIN_RADIUS = 10;
	private static final int NUM_OF_WINDOWS = 8;
	private static final int WINDOW_DISPLACE = 8;
	private static final int MAX_INCREASE_DISPLACE = 9;
	private static final int MIN_INCREASE_DISPLACE = 6;
	private static final int MAX_FLOOR_DISPLACE = 8;
	private static final int MIN_FLOOR_DISPLACE = 5;
	
	public WorldGenLichTower(World worldObj) {
		super(worldObj);
	}

	@Override
	public boolean generate(Random rand, int i, int j, int k) {
		int lowest = MAX_TERRAIN_HEIGHT;
		int size = rand.nextInt(MAX_RADIUS - MIN_RADIUS) + MIN_RADIUS;
		for(int x = i - size; x < i + size; x++) {
			for(int z = k - size; z < k + size; z++) {
				int tLevel = getTerrainLevelAt(x, z);
				if(tLevel < MID_HEIGHT - 5) {
					System.out.println("Failed at: " + x + ", " + z);
					return false;
				} else if(tLevel < lowest) {
					lowest = tLevel;
				}
			}
		}
		
		int circumference = (int)PI * size * 2;
		
		float steps = (4 * PI) / circumference;
		float stepsRads = 0;
		
		float windowStep = (2 * PI) / NUM_OF_WINDOWS;
		float perWindow = WINDOW_DISPLACE;
		
		int perIncrease = rand.nextInt(MAX_INCREASE_DISPLACE - MIN_INCREASE_DISPLACE) + MIN_INCREASE_DISPLACE;
		int perFloor = rand.nextInt(MAX_FLOOR_DISPLACE - MIN_FLOOR_DISPLACE) + MIN_FLOOR_DISPLACE;
		
		int height = perFloor * (rand.nextInt(3) + 5) + 3;
		
		int tempSize = size;
		for(int y = lowest; y < lowest + height; y++) {
			if(y % perFloor == 0) {
				genCircle(i, y, k, 0, tempSize, Block.netherBrick.blockID, 0, 0, 8);
				if(y + perFloor > lowest + height)
				{
					System.out.println("sp");
					EntityLich lich = new EntityLich(worldObj);
					lich.setPosition(i, y + 2, k);
					ArisenMod.proxy.spawnEntity(lich);
					break;
				}
			}
			if(y % perIncrease == 0) {
				tempSize++;
			}
		}
		
		for(int y = lowest; y < lowest + height; y++) {
			genCircle(i, y, k, size - 1, size, Block.netherBrick.blockID, 0, 0, 8);
			float xRad = (float) Math.cos(stepsRads);
			float zRad = (float) Math.sin(stepsRads);
			for(int w = 1; w < 4; w++) {
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y, (int)(zRad * (size - 1 - w) + k), Block.netherBrick.blockID);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) + 1, y, (int)(zRad * (size - 1 - w) + k), Block.netherBrick.blockID);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) - 1, y, (int)(zRad * (size - 1 - w) + k), Block.netherBrick.blockID);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y, (int)(zRad * (size - 1 - w) + k) + 1, Block.netherBrick.blockID);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y, (int)(zRad * (size - 1 - w) + k) - 1, Block.netherBrick.blockID);
				
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 1, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) + 1, y + 1, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) - 1, y + 1, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 1, (int)(zRad * (size - 1 - w) + k) + 1, 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 1, (int)(zRad * (size - 1 - w) + k) - 1, 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 2, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) + 1, y + 2, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) - 1, y + 2, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 2, (int)(zRad * (size - 1 - w) + k) + 1, 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 2, (int)(zRad * (size - 1 - w) + k) - 1, 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 3, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) + 1, y + 3, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i) - 1, y + 3, (int)(zRad * (size - 1 - w) + k), 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 3, (int)(zRad * (size - 1 - w) + k) + 1, 0);
				worldObj.setBlock((int)(xRad * (size - 1 - w) + i), y + 3, (int)(zRad * (size - 1 - w) + k) - 1, 0);
			}
			stepsRads += steps;
			
			if(y % perWindow == 0 || (y - 1) % perWindow == 0) {
				for(float rads = 0; rads <= 2 * PI; rads += windowStep) {
					xRad = (float) Math.cos(rads);
					zRad = (float) Math.sin(rads);
					worldObj.setBlock((int)(xRad * (size - 1) + i), y, (int)(zRad * (size - 1) + k), ArisenBlocks.forcefield.blockID);
					worldObj.setBlock((int)(xRad * (size) + i), y, (int)(zRad * (size) + k), ArisenBlocks.forcefield.blockID);
				}
			}
			
			if(y % perIncrease == 0) {
				size++;
			}
		}
		
		genHalfSphere(i, lowest + height, k, size - 1, size, ArisenBlocks.forcefield.blockID, 0);
		
		return true;
	}
	
	private void genHalfSphere(int i, int j, int k, float innerRadius, float outerRadius, int blockID, int metadata)
	{
		double outerSq = outerRadius * outerRadius;
		double innerSq = innerRadius * innerRadius;
		for(int x = -(int)outerRadius - 1; x < outerRadius + 1; x++) {
			for(int y = 0; y < outerRadius + 1; y++) {
				for(int z = -(int)outerRadius - 1; z < outerRadius + 1; z++) {
					int distanceSq = (x * x) + (y * y) + (z * z);
					
					if(innerSq < distanceSq && distanceSq < outerSq) {
						worldObj.setBlock(i + x, j + y, k + z, blockID, metadata, 3);
					}
				}
			}
		}
	}

}
