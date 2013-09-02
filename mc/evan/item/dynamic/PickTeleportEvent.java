package mc.evan.item.dynamic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.entity.living.LivingEvent;


@Cancelable
public class PickTeleportEvent extends LivingEvent
{

    public double targetX;
    public double targetY;
    public double targetZ;
    public float attackDamage;

    public PickTeleportEvent(EntityLivingBase entity, double targetX, double targetY, double targetZ)
    {
        super(entity);
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetZ = targetZ;
    }
}
