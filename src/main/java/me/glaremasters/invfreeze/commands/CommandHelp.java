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
public class CommandHelp implements CommandExecutor {

    private InvFreeze invFreeze;

    public CommandHelp(InvFreeze invFreeze) {
        this.invFreeze = invFreeze;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("invfreeze.help")) return true;
        }
        sender.sendMessage(invFreeze.getConfig().getString("messages.freeze"));
        sender.sendMessage(invFreeze.getConfig().getString("messages.unfreeze"));
        return true;
    }

}