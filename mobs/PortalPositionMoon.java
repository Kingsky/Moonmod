package net.jlndk.Moonmod.mobs;

import net.jlndk.Moonmod.world.TeleporterMoon;
import net.minecraft.util.ChunkCoordinates;

public class PortalPositionMoon extends ChunkCoordinates
{
    public long field_85087_d;

    final TeleporterMoon field_85088_e;

    public PortalPositionMoon(TeleporterMoon par1TeleporterMoon, int par2, int par3, int par4, long par5)
    {
        super(par2, par3, par4);
        this.field_85088_e = par1TeleporterMoon;
        this.field_85087_d = par5;
    }
}
