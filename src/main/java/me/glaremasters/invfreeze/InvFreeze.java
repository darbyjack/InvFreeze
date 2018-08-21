package me.glaremasters.invfreeze;

import me.glaremasters.invfreeze.commands.CommandFreeze;
import me.glaremasters.invfreeze.commands.CommandHelp;
import me.glaremasters.invfreeze.commands.CommandUnFreeze;
import me.glaremasters.invfreeze.events.FreezeCheck;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvFreeze extends JavaPlugin {

    private static Permission perms = null;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        setupPermissions();

        getCommand("freezeon").setExecutor(new CommandFreeze(this));
        getCommand("freezeoff").setExecutor(new CommandUnFreeze(this));
        getCommand("invfreeze").setExecutor(new CommandHelp(this));
        getServer().getPluginManager().registerEvents(new FreezeCheck(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Permission getPermissions() {
        return perms;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager()
                .getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}
