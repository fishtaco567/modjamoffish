package net.progfish.arisen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandlerArisen implements IConnectionHandler {

	String message = "An evil lich is living in the area, surviving off of monuments he has placed long ago." +
			" He lives in an enormous purple tower, inaccessable to anyone not affiliated." + 
			" To get in to his tower and again bring peace to minecraftia, you must seek out and destroy his monuments." + 
			" These monuments have created fortifications for themselves, look for odd outcroppings of mossy cobblestone." +
			" Once you've destroyed ten of them, he should be weak enough for you to get in.";
	String message2 = "Good luck.";
	
	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler,
			INetworkManager manager) {
		if(player instanceof EntityPlayerMP) {
			((EntityPlayerMP)((EntityPlayerMP) player)).sendChatToPlayer(ChatMessageComponent.func_111077_e(message));
			((EntityPlayerMP)((EntityPlayerMP) player)).sendChatToPlayer(ChatMessageComponent.func_111077_e(message2));
		}
	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server,
			int port, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler,
			MinecraftServer server, INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionClosed(INetworkManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler,
			INetworkManager manager, Packet1Login login) {
		// TODO Auto-generated method stub
		
	}

}
