package net.progfish.arisen.entities;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.Entity;
import net.progfish.arisen.ArisenMod;

public class ArisenEntityRegistry {

	private static int entityID = 0;
	
	public static void init(FMLInitializationEvent event) {
		addMapping(EntityLich.class, "Lich", 64, 1, true, false);
		addMobName("Lich", "Lich");
	}
	
	public static void addMapping(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, boolean spawnerOrEgg) {
		if(spawnerOrEgg) {
			EntityRegistry.registerModEntity(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), ArisenMod.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		} else {
			EntityRegistry.registerModEntity(entityClass, entityName, ++entityID, ArisenMod.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		}
	}
	
	public static void addMobName(String longName, String shortName)
	{
		LanguageRegistry.instance().addStringLocalization("entity.arisen." + longName + ".name", shortName);
	}
	
}
