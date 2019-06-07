package me.glaremasters.invfreeze;

import co.aikar.commands.PaperCommandManager;
import me.glaremasters.invfreeze.commands.Commands;
import me.glaremasters.invfreeze.events.FreezeCheck;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvFreeze extends JavaPlugin {

    private static Permission perms = null;
    private PaperCommandManager commandManager;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();
        setupPermissions();

        commandManager = new PaperCommandManager(this);
        commandManager.enableUnstableAPI("help");
        commandManager.registerCommand(new Commands(perms, getConfig()));
        getServer().getPluginManager().registerEvents(new FreezeCheck(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager()
                .getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
}
