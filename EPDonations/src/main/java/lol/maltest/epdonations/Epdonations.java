package lol.maltest.epdonations;

import lol.maltest.epdonations.cmds.BoughtAlert;
import lol.maltest.epdonations.cmds.Discord;
import lol.maltest.epdonations.cmds.Ping;
import lol.maltest.epdonations.cmds.Store;
import net.md_5.bungee.api.plugin.Plugin;

public final class Epdonations extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this, new BoughtAlert());
        getProxy().getPluginManager().registerCommand(this, new Ping());
        getProxy().getPluginManager().registerCommand(this, new Discord());
        getProxy().getPluginManager().registerCommand(this, new Store());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
