package lol.maltest.epdonations.cmds;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Store extends Command {
    public Store() {
        super("store", null, "buy");
    }

    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer player = (ProxiedPlayer) sender;

            player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&7Make sure to check out our &cstore &7here: &bstore.eventpractice.club")));
        }
    }
}
