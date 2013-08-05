package net.progfish.arisen.worldgen;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
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

	private static final int TOWER_BLOCK = ArisenBlocks.abyssBrick.blockID;
	
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
		
		int perFloorLowest = 0;
		int perFloorHighest = 127;
		
		int tempSize = size;
		
		ArrayList<Integer> floors = new ArrayList();
		
		for(int y = lowest; y < lowest + height; y++) {
			if(y % perFloor == 0) {
				floors.add(y);
				if(perFloorLowest == 0)
				{
					perFloorLowest = y;
				}
				genCircle(i, y, k, 0, tempSize, TOWER_BLOCK, 0, 0, 5);
				if(y + perFloor >= lowest + height)
				{
					perFloorHighest = y;
					EntityLich lich = new EntityLich(worldObj);
					lich.setPosition(i, y + 2, k);
					worldObj.spawnEntityInWorld(lich); 
					break;
				}
			}
			if(y % perIncrease == 0) {
				tempSize++;
			}
		}
		
		tempSize = size;
		for(int y = lowest; y < lowest + height; y++) {
			if(y % perFloor != 0)
			{
				genCircle(i, y, k, tempSize - 1, tempSize, TOWER_BLOCK, 0, 0, 5);
			}
			if(((y % perFloor != 0) && (y < perFloorHighest && y > perFloorLowest)))
			{
				float zRad = (float) Math.cos(stepsRads);
				float xRad = (float) Math.sin(stepsRads);
				for(int w = 1; w < 4; w++) {
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y, (int)(zRad * (tempSize - 1 - w) + k), TOWER_BLOCK);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) + 1, y, (int)(zRad * (tempSize - 1 - w) + k), TOWER_BLOCK);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) - 1, y, (int)(zRad * (tempSize - 1 - w) + k), TOWER_BLOCK);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y, (int)(zRad * (tempSize - 1 - w) + k) + 1, TOWER_BLOCK);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y, (int)(zRad * (tempSize - 1 - w) + k) - 1, TOWER_BLOCK);
					
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 1, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) + 1, y + 1, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) - 1, y + 1, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 1, (int)(zRad * (tempSize - 1 - w) + k) + 1, 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 1, (int)(zRad * (tempSize - 1 - w) + k) - 1, 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 2, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) + 1, y + 2, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) - 1, y + 2, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 2, (int)(zRad * (tempSize - 1 - w) + k) + 1, 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 2, (int)(zRad * (tempSize - 1 - w) + k) - 1, 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 3, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) + 1, y + 3, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i) - 1, y + 3, (int)(zRad * (tempSize - 1 - w) + k), 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 3, (int)(zRad * (tempSize - 1 - w) + k) + 1, 0);
					worldObj.setBlock((int)(xRad * (tempSize - 1 - w) + i), y + 3, (int)(zRad * (tempSize - 1 - w) + k) - 1, 0);
				}
				stepsRads += steps;
			}
			
			if(y % perWindow == 0 || (y - 1) % perWindow == 0) {
				for(float rads = 0; rads <= 2 * PI; rads += windowStep) {
					float xRad = (float) Math.cos(rads);
					float zRad = (float) Math.sin(rads);
					worldObj.setBlock((int)(xRad * (tempSize - 1) + i), y, (int)(zRad * (tempSize - 1) + k), ArisenBlocks.forcefield.blockID);
					worldObj.setBlock((int)(xRad * (tempSize) + i), y, (int)(zRad * (tempSize) + k), ArisenBlocks.forcefield.blockID);
				}
			}
			
			if(y % perIncrease == 0) {
				tempSize++;
			}
		}
		
		genHalfSphere(i, lowest + height, k, tempSize - 1, tempSize, ArisenBlocks.forcefield.blockID, 0);

		stepsRads = -(steps / 3);
		for(int w = 0; w < 3; w++)
		{
			float xRad = (float) Math.cos(stepsRads);
			float zRad = (float) Math.sin(stepsRads);
			worldObj.setBlock((int)(xRad * (size) + i), perFloorLowest + 1, (int)(zRad * (size) + k), ArisenBlocks.abyssBarrier.blockID);
			worldObj.setBlock((int)(xRad * (size) + i), perFloorLowest + 2, (int)(zRad * (size) + k), ArisenBlocks.abyssBarrier.blockID);
			System.out.println((int)(xRad * (size) + i) + ", " + (perFloorLowest + 2) + ", " + (int)(zRad * (size) + k));
			stepsRads += (steps / 3);
			for(int x = 0; x < 12; x++)
			{
				int y = x / 2 - 1;
				worldObj.setBlock((int)(xRad * (size + x + 1) + i), perFloorLowest + 1 + y, (int)(zRad * (size + x + 1) + k), 0);
				worldObj.setBlock((int)(xRad * (size + x + 1) + i), perFloorLowest + 2 + y, (int)(zRad * (size + x + 1) + k), 0);
				worldObj.setBlock((int)(xRad * (size + x + 1) + i), perFloorLowest + 3 + y, (int)(zRad * (size + x + 1) + k), 0);
			}
		}
		
		for(int floor : floors)
		{
			makeSpawner(rand, i, floor, k);
			makeSpawner(rand, i + 1, floor, k);
			makeSpawner(rand, i - 1, floor, k);
			makeSpawner(rand, i, floor, k + 1);
			makeSpawner(rand, i, floor, k - 1);
			makeChest(rand, i, floor + 1, k);
			
			worldObj.setBlock((int)(i + size / 1.7), floor + 1, (int)(k + size / 1.7), Block.obsidian.blockID);
			worldObj.setBlock((int)(i - size / 1.7), floor + 1, (int)(k + size / 1.7), Block.obsidian.blockID);
			worldObj.setBlock((int)(i - size / 1.7), floor + 1, (int)(k - size / 1.7), Block.obsidian.blockID);
			worldObj.setBlock((int)(i + size / 1.7), floor + 1, (int)(k - size / 1.7), Block.obsidian.blockID);
			worldObj.setBlock((int)(i + size / 1.7), floor + 2, (int)(k + size / 1.7), Block.obsidian.blockID);
			worldObj.setBlock((int)(i - size / 1.7), floor + 2, (int)(k + size / 1.7), Block.obsidian.blockID);
			worldObj.setBlock((int)(i - size / 1.7), floor + 2, (int)(k - size / 1.7), Block.obsidian.blockID);
			worldObj.setBlock((int)(i + size / 1.7), floor + 2, (int)(k - size / 1.7), Block.obsidian.blockID);
			if(rand.nextInt(3) == 0)
			{
				worldObj.setBlock((int)(i + size / 1.7), floor + 3, (int)(k - size / 1.7), Block.lavaMoving.blockID);
			}
		}
		
		return true;
	}
	
	private void makeSpawner(Random rand, int i, int j, int k) {
		worldObj.setBlock(i, j, k, Block.mobSpawner.blockID);
		
		TileEntityMobSpawner spawner = (TileEntityMobSpawner) worldObj.getBlockTileEntity(i, j, k);
		spawner.getSpawnerLogic().setMobID(pickMob(rand));
	}
	
	private String pickMob(Random rand) {
		switch(rand.nextInt(3)) {
			case 0:
				return "Zombie";
			case 1:
				return "Spider";
			case 2:
				return "Skeleton";
			default:
				return "Zombie";
		}
	}
	
	private void makeChest(Random rand, int i, int j, int k) {
		worldObj.setBlock(i, j, k, Block.chest.blockID);
		
		TileEntityChest chest = (TileEntityChest) worldObj.getBlockTileEntity(i, j, k);
		int amountOfLoot = rand.nextInt(3) + 2;
		for(int w = 0; w < amountOfLoot; w++) {
			chest.setInventorySlotContents(rand.nextInt(chest.getSizeInventory()), getLoot(rand));
		}
	}
	
	private ItemStack getLoot(Random rand)
	{
		switch(rand.nextInt(16)) {
			case 0:
				return new ItemStack(Item.bow, 1, 0);
			case 1:
				return new ItemStack(Item.axeStone, 1, 0);
			case 2:
				return new ItemStack(Block.cobblestone, 64, 0);
			case 3:
				return new ItemStack(Item.bread, 3, 0);
			case 4:
				return new ItemStack(Item.pickaxeStone, 1, 0);
			case 5:
				return new ItemStack(Item.coal, 64, 0);
			case 6:
				return new ItemStack(Item.shovelStone, 5, 0);
			case 7:
				return new ItemStack(Item.plateChain, 1, 0);
			case 8:
				return new ItemStack(Item.bootsChain, 1, 0);
			case 9:
				return new ItemStack(Item.legsChain, 1, 0);
			case 10:
				return new ItemStack(Item.swordIron, 1, 0);
			case 11:
				return new ItemStack(Item.swordStone, 1, 0);
			case 12:
				return new ItemStack(Item.leather, 5, 0);
			case 13:
				return new ItemStack(Item.ingotIron, 5, 0);
			case 14:
				return new ItemStack(Item.helmetChain, 3, 0);
			default:
				return new ItemStack(Item.bakedPotato, 10, 0);
		}
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
