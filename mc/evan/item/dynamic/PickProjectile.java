package mc.evan.item.dynamic;

import mc.evan.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PickProjectile extends EntityThrowable
{
	private World w;
	private ItemStack pick;
	private EntityPlayer player;
	
    public PickProjectile(World par1World)
    {
        super(par1World);
    }

    public PickProjectile(ItemStack par1ItemStack, World par1World, EntityPlayer par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
        pick = par1ItemStack;
        player = par2EntityLivingBase;
        
        
    }

    @SideOnly(Side.CLIENT)
    public PickProjectile(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	
        if (this.worldObj.isRemote == true){
        	for(int i=0;i<128;i++){
        	Particle.IOPARTICLE.spawnParticle(this.worldObj, this.posX, this.posY, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        	}
        }
        
        if (par1MovingObjectPosition.entityHit != null)
        {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote)
        {
        	++pick.stackSize;
        	player.inventory.addItemStackToInventory(pick);
            if (this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.getThrower();

                if (!entityplayermp.playerNetServerHandler.connectionClosed && entityplayermp.worldObj == this.worldObj)
                {
                    PickTeleportEvent event = new PickTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ);
                    if (!MinecraftForge.EVENT_BUS.post(event))
                    {
                        if (this.getThrower().isRiding())
                        {
                            this.getThrower().mountEntity((Entity)null);
                        }
    
                        this.getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                        this.getThrower().fallDistance = 0.0F;
                    }
                }
            }

            this.setDead();
        }
    }
}
