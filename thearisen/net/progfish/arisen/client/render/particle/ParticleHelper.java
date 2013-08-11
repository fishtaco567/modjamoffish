package net.progfish.arisen.client.render.particle;

import java.io.File;
import java.util.HashMap;

public class ParticleHelper {

	public static HashMap<String, String> nameTextureMap;
	
	public static void addMapping(String name, String tex) {
		nameTextureMap.put(name, tex);
	}
	
	public static String getTexture(String name) {
		return nameTextureMap.get(name);
	}
	
	static {
		nameTextureMap = new HashMap();
		addMapping("lich1", "particles" + File.separator + "lich1.png");
		addMapping("lich2", "particles" + File.separator + "lich2.png");
		addMapping("lich3", "particles" + File.separator + "lich3.png");
	}
	
}
