package lol.maltest.epdonations.cmds;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Discord extends Command {
    public Discord() {
        super("discord");
    }

    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer ){
            ProxiedPlayer player = (ProxiedPlayer) sender;

            player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&7Make sure to check out our &cdiscord &7here: &bdiscord.gg/practice")));
        }
    }
}
