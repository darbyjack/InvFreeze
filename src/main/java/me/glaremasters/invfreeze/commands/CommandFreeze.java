package me.glaremasters.invfreeze.commands;

import me.glaremasters.invfreeze.InvFreeze;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.glaremasters.invfreeze.utils.ColorUtil.color;

/**
 * Created by GlareMasters
 * Date: 8/21/2018
 * Time: 1:03 PM
 */
public class CommandFreeze implements CommandExecutor {

    private InvFreeze invFreeze;

    public CommandFreeze(InvFreeze invFreeze) {
        this.invFreeze = invFreeze;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("invfreeze.freeze")) return true;
        }
        Player target = Bukkit.getServer().getPlayer(args[0]);
        if (target == null) return true;
        invFreeze.getPermissions().playerAdd(null, target, "invfreeze.frozen");
        sender.sendMessage(color(invFreeze.getConfig().getString("messages.player-frozen").replace("{player}", target.getName())));
        return true;
    }

}