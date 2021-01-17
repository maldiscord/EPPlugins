package lol.maltest.epdonations.cmds;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BoughtAlert extends Command {

    public BoughtAlert() {
        super("boughtalert");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if (player.hasPermission("mal.boughtalert")) {
                if (args.length < 2) {
                    player.sendMessage(new TextComponent(ChatColor.RED + "Usage: /boughtalert <player> <item>"));
                } else {
                    String item = String.join(" ", args).replace(args[0], "");
                    ProxyServer.getInstance().broadcast(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&9&lDONATION&7!" +
                            "\n&8&m+--------------------+" +
                            "\n&f" + args[0] + " &7just bought &c" + item + "&7! Buy yours today at &bhttps://store.eventpractice.club &7or using &f/buy &7in game." +
                            "\n&8&m+--------------------+")));
                }
            } else {
                player.sendMessage(new TextComponent(ChatColor.LIGHT_PURPLE + "NO!"));
            }
        } else {
            if (args.length < 2) {
                System.out.println(ChatColor.RED + "Usage: /boughtalert <player> <item>");
            } else {
                String item = String.join(" ", args).replace(args[0], "");
                ProxyServer.getInstance().broadcast(new TextComponent(ChatColor.translateAlternateColorCodes('&', "&9&lDONATION&7!" +
                        "\n&8&m+--------------------+" +
                        "\n&f" + args[0] + " &7just bought &c" + item + "&7! Buy yours today at &bhttps://store.eventpractice.club &7or using &f/buy &7in game." +
                        "\n&8&m+--------------------+")));
            }
        }
    }
}
