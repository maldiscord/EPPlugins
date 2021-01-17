package lol.maltest.eptags.cmds;

import lol.maltest.eptags.util.ChatUtil;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckTag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            LuckPerms api = LuckPermsProvider.get();
            if(player.hasPermission("mal.tags.check")) {
                if (args.length < 1) {
                    player.sendMessage(ChatUtil.clr("&b&lSTAFF &8» &cUsage: /checktag <player>"));
                } else {
                    if(!(api.getUserManager().getUser(args[0]) == null)) {
                        if (api.getUserManager().getUser(args[0]).getCachedData().getMetaData().getSuffix() == null) {
                            player.sendMessage(ChatUtil.clr("&b&lSTAFF &8» &cThe user &b" + args[0] + " &chas no tag."));
                        } else {
                            String suffix = api.getUserManager().getUser(player.getName()).getCachedData().getMetaData().getSuffix();
                            player.sendMessage(ChatUtil.clr("&b&lSTAFF &8» &cThe user &b" + args[0] + " &chas the tag:" + suffix));
                        }
                    } else {
                        player.sendMessage(ChatUtil.clr("&4&lERROR &8» &cThe user &b" + args[0] + " &chas never logged on!"));
                    }
                }
            }
        }
        return false;
    }
}
