package lol.maltest.epdonations.cmds;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Ping extends Command {
    public Ping(){
        super("ping");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;

            player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&7Your ping to &bEventPractice &7servers is: &c" + player.getPing())));
        }
    }
}
