package net.progfish.arisen.commands;

import java.util.Random;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.progfish.arisen.entities.EntityLich;

public class CommandSpawnLich extends CommandBase {
	
	public Random rand = new Random();
	public World worldObj;
	
	@Override
	public String getCommandName() {
		return "lich";
	}
	
	public int getRequiredPermissionLevel() {
        return 0;
    }
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "Spawns a lich. To be used if one is not present in the tower.";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		EntityPlayerMP player = this.getCommandSenderAsPlayer(icommandsender);
		if(!player.worldObj.isRemote) {
			worldObj = player.worldObj;
			EntityLich lich = new EntityLich(player.worldObj);
			lich.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
			player.worldObj.spawnEntityInWorld(lich);  
		}
	}
}
