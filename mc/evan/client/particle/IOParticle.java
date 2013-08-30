package mc.evan.client.particle;

import mc.evan.item.ItemsCPick;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;


public class IOParticle extends EntityFX {

	public IOParticle(World world, double x, double y, double z,
			double motionx, double motiony, double motionz) {
		super(world, x, y, z, motionx, motiony, motionz);

		func_110125_a(ItemsCPick.ioparticle);
		particleScale = 1;
	}

	@Override
	public int getFXLayer() {
		return 2;
	}
}
