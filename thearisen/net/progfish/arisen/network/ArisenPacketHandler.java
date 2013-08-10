package net.progfish.arisen.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ChunkCoordinates;
import net.progfish.arisen.WorldSaveHandlerClient;
import net.progfish.arisen.WorldSaveHandlerServer;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class ArisenPacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		if(packet.channel.equals("monuments")) {
			DataInputStream dis = new DataInputStream(new ByteArrayInputStream(packet.data));
			
			ArrayList<ChunkCoordinates> locs = new ArrayList();
			boolean lichKilled = false;
			try {
				lichKilled = dis.readBoolean();
				int length = dis.readInt();
				for(int i = 0; i < length; i++) {
					int x = dis.readInt();
					int y = dis.readInt();
					int z = dis.readInt();
					locs.add(new ChunkCoordinates(x, y, z));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			WorldSaveHandlerClient.setInfo(locs, lichKilled);
		}
	}
	
	public static Packet250CustomPayload getMonumentPacket() {
		if(!WorldSaveHandlerServer.instance.isReady) {
			WorldSaveHandlerServer.instance.init();
		}
		ArrayList<ChunkCoordinates> locs = WorldSaveHandlerServer.instance.getCoordList();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);

		try {
			dos.writeBoolean(WorldSaveHandlerServer.instance.getLichKilled());
			dos.writeInt(locs.size());
			for(ChunkCoordinates loc : locs) {
				dos.writeInt(loc.posX);
				dos.writeInt(loc.posY);
				dos.writeInt(loc.posZ);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "monuments";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		
		return packet;
	}

}
