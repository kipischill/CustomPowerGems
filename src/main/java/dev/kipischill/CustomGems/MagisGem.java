package dev.kipischill.CustomGems;

import dev.iseal.powergems.api.ApiManager;
import dev.iseal.powergems.misc.AbstractClasses.Gem;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MagisGem extends Gem {
    public MagisGem() {
        super("Magisstar");
    }

    @Override
    public void call(Action act, Player plr, ItemStack item) {
        caller = this.getClass();
        super.call(act, plr, item);
    }

    @Override
    protected void rightClick(Player plr) {
        plr.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3, 255));
        plr.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 3, 255));

    }

    @Override
    protected void leftClick(Player plr) {
        plr.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, level - 1));
    }

    @Override
    protected void shiftClick(Player plr) {
        plr.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, level));
        plr.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 200, level / 2));
    }

    public static void main(String[] args) {
        // Get the instance of ApiManager
        ApiManager apiManager = ApiManager.getInstance();

        // Register the gem class
        boolean isRegistered = apiManager.registerGemClass(MagisGem.class);

        // Check if registration was successful
        if (isRegistered) {
            System.out.println("MagisGem registered successfully!");
        } else {
            System.out.println("MagisGem registration failed.");
        }
    }
}
