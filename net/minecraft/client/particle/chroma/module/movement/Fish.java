package net.minecraft.client.particle.chroma.module.movement;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.particle.chroma.event.EventTarget;
import net.minecraft.client.particle.chroma.event.events.EventUpdate;
import net.minecraft.client.particle.chroma.module.Category;
import net.minecraft.client.particle.chroma.module.Module;

public class Fish extends Module
{
	public Fish()
	{
		super("Fish", 95, Category.MOVEMENT);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event)
	{
        EntityPlayerSP player = mc.thePlayer;
        
        if (!player.isInWater() || player.isSneaking())
        {
            return;
        }
        
        player.motionY += 0.02;
	}
}