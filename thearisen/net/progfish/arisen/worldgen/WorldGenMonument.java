package net.progfish.arisen.worldgen;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.World;

public class WorldGenMonument extends WorldGenBase {

	public static WorldGenMonumentBase[] factories = new WorldGenMonumentBase[] {new WorldGenArtifactSphere()};
	
	public WorldGenMonument(World worldObj) {
		super(worldObj);
	}

	@Override
	public boolean generate(Random rand, int i, int j, int k) {
		factories[rand.nextInt(factories.length)].makeGenerator(worldObj).generate(rand, i, j, k);
		return true;
	}

}
