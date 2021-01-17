package lol.maltest.eptags.cmds;

import javafx.print.PageLayout;
import lol.maltest.eptags.util.ChatUtil;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.PrefixNode;
import net.luckperms.api.node.types.SuffixNode;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class DeleteTag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            LuckPerms api = LuckPermsProvider.get();
            if (player.hasPermission("mal.tags.delete")) {
                if (args.length < 1) {
                    player.sendMessage(ChatUtil.clr("&b&lSTAFF &8» &cUsage: /deletetag <player>"));
                } else {
                    if(!(api.getUserManager().getUser(args[0]) == null)) {
                        if (api.getUserManager().getUser(args[0]).getCachedData().getMetaData().getSuffix() == null) {
                            player.sendMessage(ChatUtil.clr("&b&lSTAFF &8» &cThe user &b" + args[0] + " &chas no tag scam!!!!"));
                        } else {
                            String suffix = api.getUserManager().getUser(player.getName()).getCachedData().getMetaData().getSuffix();
                            api.getUserManager().modifyUser(Bukkit.getPlayer(args[0]).getUniqueId(), (User user) -> {
                                user.data().clear(NodeType.SUFFIX::matches);
                            });
                            player.sendMessage(ChatUtil.clr("&b&lSTAFF &8» &cI have deleted &b" + args[0] + "&c's tag:&b" + suffix + " &csuccessfully"));
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
