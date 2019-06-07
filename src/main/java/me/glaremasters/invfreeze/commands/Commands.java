package me.glaremasters.invfreeze.commands;

import co.aikar.commands.ACFBukkitUtil;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Syntax;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Glare
 * Date: 6/6/2019
 * Time: 11:45 PM
 */
@CommandAlias("invfreeze|if")
public class Commands extends BaseCommand {

    private Permission permission;
    private FileConfiguration c;

    public Commands(Permission permission, FileConfiguration c) {
        this.permission = permission;
        this.c = c;
    }

    @Subcommand("freezeon")
    @CommandPermission("invfreeze.freeze")
    @Description("freeze player inventory")
    @Syntax("<player>")
    @CommandCompletion("@players")
    public void onFreeze(Player player, OnlinePlayer target) {
        permission.playerAdd(null, target.getPlayer(), "invfreeze.frozen");
        getCurrentCommandIssuer().sendMessage(ACFBukkitUtil.color(c.getString("messages.player-froze").replace("{player}", target.getPlayer().getName())));
    }

    @Subcommand("freezeoff")
    @CommandPermission("invfreeze.unfreeze")
    @Description("unfreeze player inventory")
    @Syntax("<player>")
    @CommandCompletion("@players")
    public void onUnFreeze(Player player, OnlinePlayer target) {
        permission.playerRemove(null, target.getPlayer(), "invfreeze.frozen");
        getCurrentCommandIssuer().sendMessage(ACFBukkitUtil.color(c.getString("messages.player-unfrozen").replace("{player}", target.getPlayer().getName())));
    }

    @HelpCommand
    public void onHelp(co.aikar.commands.CommandHelp help) {
        help.showHelp();
    }

}
