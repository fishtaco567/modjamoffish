package net.progfish.arisen.proxy;

import net.progfish.arisen.client.render.ArisenRenderRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void initRenderers() {
		ArisenRenderRegistry.init();
	}
	
}
