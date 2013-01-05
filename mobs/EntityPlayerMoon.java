package net.jlndk.Moonmod.mobs;

import net.jlndk.Moonmod.Moonmod;
import net.jlndk.Moonmod.blocks.BlockMoonTent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Session;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;

public class EntityPlayerMoon extends EntityPlayerSP {

	public int moonAir, maxAir;

	public EntityPlayerMoon(Minecraft minecraft, World world, Session session,
			int i) {
		super(minecraft, world, session, i);
		maxAir = 100;
		moonAir = maxAir;
	}

	@Override
	public void moveEntityWithHeading(float f, float f1) {
		float f2 = 0.91F;
		if (onGround) {
			f2 = 0.5460001F;
			int i = worldObj.getBlockId(MathHelper.floor_double(posX),
					MathHelper.floor_double(boundingBox.minY) - 1,
					MathHelper.floor_double(posZ));
			if (i > 0) {
				f2 = Block.blocksList[i].slipperiness * 0.91F;
			}
		}
		float f3 = 0.1627714F / (f2 * f2 * f2);
		moveFlying(f, f1, onGround ? 0.1F * f3 : 0.02F);
		f2 = 0.91F;
		if (onGround) {
			f2 = 0.5460001F;
			int j = worldObj.getBlockId(MathHelper.floor_double(posX),
					MathHelper.floor_double(boundingBox.minY) - 1,
					MathHelper.floor_double(posZ));
			if (j > 0) {
				f2 = Block.blocksList[j].slipperiness * 0.91F;
			}
		}
		if (isOnLadder()) {
			float f4 = 0.15F;
			if (motionX < (double) (-f4)) {
				motionX = -f4;
			}
			if (motionX > (double) f4) {
				motionX = f4;
			}
			if (motionZ < (double) (-f4)) {
				motionZ = -f4;
			}
			if (motionZ > (double) f4) {
				motionZ = f4;
			}
			fallDistance = 0.0F;
			if (motionY < -0.14999999999999999D) {
				motionY = -0.14999999999999999D;
			}
			if (isSneaking() && motionY < 0.0D) {
				motionY = 0.0D;
			}
		}
		moveEntity(motionX, motionY, motionZ);
		if (isCollidedHorizontally && isOnLadder()) {
			motionY = 0.20000000000000001D;
		}
		motionY -= 0.021D; // 0.08
		motionY *= 0.98000001907348633D;
		motionX *= f2;
		motionZ *= f2;

		double d2 = posX - prevPosX;
		double d3 = posZ - prevPosZ;
		float f5 = MathHelper.sqrt_double(d2 * d2 + d3 * d3) * 4F;
		if (f5 > 1.0F) {
			f5 = 1.0F;
		}
	}

	protected void fall(float f) {
		if (f >= 2.0F) {
			addStat(StatList.distanceFallenStat,
					(int) Math.round((double) f * 100D));
		}
		int i = (int) Math.ceil(f - 6F);
		if (i > 0) {
			attackEntityFrom(null, i);
			int j = worldObj.getBlockId(
					MathHelper.floor_double(posX),
					MathHelper.floor_double(posY - 0.20000000298023224D
							- (double) yOffset), MathHelper.floor_double(posZ));
			if (j > 0) {
				StepSound stepsound = Block.blocksList[j].stepSound;
				worldObj.playSoundAtEntity(this, stepsound.getStepSound(),
						stepsound.getVolume() * 0.5F,
						stepsound.getPitch() * 0.75F);
			}
		}
	}

	@Override
	protected void jump() {
		super.jump();
		if (isSneaking()) {
			motionY = 0.22D;
		} else {
			motionY = 0.41999998688697815D;
		}
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (BlockMoonTent.inTent(worldObj, MathHelper.floor_double(posX),
				MathHelper.floor_double(posY), MathHelper.floor_double(posZ))) {
			moonAir = maxAir;
		}

		ItemStack boots = inventory.armorInventory[0];
		ItemStack legs = inventory.armorInventory[1];
		ItemStack chest = inventory.armorInventory[2];
		ItemStack helm = inventory.armorInventory[3];
		if (!(boots == null || legs == null || chest == null || helm == null)) {
			if (boots.itemID == Moonmod.MoonBoots.shiftedIndex
					&& legs.itemID == Moonmod.MoonPants.shiftedIndex
					&& chest.itemID == Moonmod.MoonChest.shiftedIndex
					&& helm.itemID == Moonmod.MoonHelmet.shiftedIndex) {
				moonAir = maxAir;
			}
		}

		moonAir--;
		int air = (int) ((300.0 / maxAir) * moonAir);

		if (moonAir == -5) {
			moonAir = 0;
			for (int i = 0; i < 8; i++)
				attackEntityFrom(null, 2);
		}
	}

	public void onEntityDeath() {
		}
}
