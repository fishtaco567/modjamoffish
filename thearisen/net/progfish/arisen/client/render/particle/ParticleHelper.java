package net.progfish.arisen.client.render.particle;

import java.io.File;
import java.util.HashMap;

public class ParticleHelper {

	public static final String PARTICLES_PATH = "particles" + File.separator;
	
	public static HashMap<String, String> nameTextureMap;
	
	public static void addMapping(String name, String tex) {
		nameTextureMap.put(name, tex);
	}
	
	public static String getTexture(String name) {
		return nameTextureMap.get(name);
	}
	
	static {
		nameTextureMap = new HashMap();
		addMapping("lich1", PARTICLES_PATH + "lich1.png");
		addMapping("lich2", PARTICLES_PATH + "lich2.png");
		addMapping("lich3", PARTICLES_PATH + "lich3.png");
		addMapping("riftsmall", PARTICLES_PATH + "riftsmall.png");
	}
	
}
