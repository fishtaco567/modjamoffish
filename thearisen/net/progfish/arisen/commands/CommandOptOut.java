package net.progfish.arisen.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import net.progfish.arisen.Config;

public class CommandOptOut extends CommandBase {

	@Override
	public String getCommandName() {
		return "optout";
	}
	
	public int getRequiredPermissionLevel() {
        return 0;
    }
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "Stops the lich paragraph from being sent on join for or whoever this command is pointed at.";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(astring.length == 0)	{
			Config.addOptOut(icommandsender.getCommandSenderName());
			this.getCommandSenderAsPlayer(icommandsender).sendChatToPlayer(ChatMessageComponent.func_111077_e("You have added yourself to the opt out list."));
		} else {
			Config.addOptOut(astring[0]);
			this.getCommandSenderAsPlayer(icommandsender).sendChatToPlayer(ChatMessageComponent.func_111077_e("You have added " + astring[0] + " to the opt out list."));
		}
	}

}
