package net.progfish.arisen.worldgen;

import java.util.Random;

import net.minecraft.world.World;

public abstract class WorldGenMonumentBase extends WorldGenBase {

	public WorldGenMonumentBase(World worldObj) {
		super(worldObj);
	}
	
	public abstract WorldGenMonumentBase makeGenerator(World world);

}
