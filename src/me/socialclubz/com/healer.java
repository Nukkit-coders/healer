package me.socialclubz.com;

import cn.nukkit.Player;
import cn.nukkit.PlayerFood;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.MainLogger;
import java.io.File;
import java.util.LinkedHashMap;

public class healer
        extends PluginBase
        implements Listener
{
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
        getDataFolder().mkdir();

        Config config = new Config(new File(
                getDataFolder(), "config.yml"), 2, new LinkedHashMap() {});
        config.save();
        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Enabled!       |");
        getServer().getLogger().info("|       Healer        |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|      augesrob       |");
        getServer().getLogger().info("-----------------------");
    }

    public void onDisable()
    {
        getServer().getLogger().info("-----------------------");
        getServer().getLogger().info("|      Disabled!      |");
        getServer().getLogger().info("|       Healer        |");
        getServer().getLogger().info("|         by          |");
        getServer().getLogger().info("|      augesrob       |");
        getServer().getLogger().info("-----------------------");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player)sender;
        if (commandLabel.equalsIgnoreCase("heal"))
        {
            player.heal(20.0F);
            player.sendMessage("Some stranger Healed you with a kiss");
        }
        if (commandLabel.equalsIgnoreCase("eat"))
        {
            PlayerFood f = player.getFoodData();
            f.setLevel(20);
            player.sendMessage("You have been feed by the gods");
        }
        if (commandLabel.equalsIgnoreCase("ext"))
        {
            player.isOnFire();
            player.extinguish();
            player.sendMessage("Water was thrown on you");
        }
        if (commandLabel.equalsIgnoreCase("healer"))
        {
            player.heal(20.0F);
            PlayerFood f = player.getFoodData();
            f.setLevel(20);
            player.isOnFire();
            player.extinguish();
            player.sendMessage("You are relaxed after some fun");
        }
        return false;
    }
}
