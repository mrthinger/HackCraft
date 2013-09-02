package mc.evan.client.particle;

import mc.evan.item.ItemsCPick;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class SixtyNineParticle extends EntityFX {

	
	public SixtyNineParticle(World world, double x, double y, double z,
			double motionx, double motiony, double motionz) {
		super(world, x, y, z, motionx, motiony, motionz);

		func_110125_a(ParticleInitializer.sixtynineparticle);
		particleScale = 1.5F;
		particleMaxAge = 20;
	}

	@Override
	public int getFXLayer() {
		return 2;
	}
}
