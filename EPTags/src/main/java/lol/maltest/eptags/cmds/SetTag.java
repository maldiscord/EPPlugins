package lol.maltest.eptags.cmds;

import lol.maltest.eptags.util.ChatUtil;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.SuffixNode;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Map;

public class SetTag implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        LuckPerms api = LuckPermsProvider.get();
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("mal.tags.set")){
                if(args.length < 2)  {
                    player.sendMessage(ChatUtil.clr("&cUsage: /settag <player> <tag>"));
                } else {
                    if(!(api.getUserManager().getUser(args[0]) == null)) {
                        String Suffix = String.join(" ", args).replace(args[0], "");
                        api.getUserManager().modifyUser(Bukkit.getPlayer(args[0]).getUniqueId(), (User user) -> {
                            user.data().clear(NodeType.SUFFIX::matches);

                            Map<Integer, String> inheritedSuffixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getSuffixes();
                            int priority = inheritedSuffixes.keySet().stream().mapToInt(i -> i + 10).max().orElse(10);

                            Node node = SuffixNode.builder(Suffix, priority).build();

                            user.data().add(node);

                        });
                        player.sendMessage(ChatUtil.clr("&b&lSTAFF &8» &cI have set &b" + args[0] + "&c's tag to&b" + Suffix));
                    } else {
                        player.sendMessage(ChatUtil.clr("&4&lERROR &8» &cThe user &b" + args[0] + " &chas never logged on!"));
                    }
                }
            }
        }
        return false;
    }
}
