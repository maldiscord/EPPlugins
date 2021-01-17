package lol.maltest.eptags;

import lol.maltest.eptags.cmds.CheckTag;
import lol.maltest.eptags.cmds.DeleteTag;
import lol.maltest.eptags.cmds.SetTag;
import org.bukkit.plugin.java.JavaPlugin;

public final class EPTags extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("settag").setExecutor(new SetTag());
        getCommand("deletetag").setExecutor(new DeleteTag());
        getCommand("checktag").setExecutor(new CheckTag());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
