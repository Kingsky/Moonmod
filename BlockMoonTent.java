package net.jlndk.moonmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMoonTent extends Block {

	public BlockMoonTent(int i, int j) {
		super(i, j, Material.cloth);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	@Override
	public String getTextureFile(){
		return "/jlndk/moonmod/Blocks.png";
	}

	@Override
	public void onBlockAdded(World world, int i, int j, int k) {
		world.setBlockMetadata(i, j, k, 0);
	}

	@Override
	public void onBlockClicked(World world, int i, int j, int k,
			EntityPlayer entityplayer) {
		if (world.getBlockMetadata(i, j, k) == 1) {
			setHardness(-1);
		} else
			setHardness(0.6F);
	}

	public boolean onblockActivated(World world, int i, int j, int k,
			EntityPlayer ep) {
		int slot = ep.inventory.currentItem;
		ItemStack is = ep.inventory.mainInventory[slot];
		if (is == null || is.itemID != mod_moonmod.SonicScrew.shiftedIndex)
			return false;

		if (!(is.getItemDamage() < mod_moonmod.screwUses))
			return false;

		is.damageItem(1, ep);

		if (world.getBlockMetadata(i, j, k) == 1) {
			destroyTent(i, j, k, world, ep);
		} else {
			if (!checkBasis(i, j, k, ep, world))
				return false;
			buildTent(i, j, k, world);
		}
		return true;
	}

	private boolean checkBasis(int x, int y, int z, EntityPlayer ep, World wd) {
		for (int i = x - 2; i < x + 2; i++) {
			for (int j = z - 3; j < z + 4; j++) {
				if (!wd.getBlockMaterial(i, y, j).isSolid()) {
					ep.addChatMessage("Cannot build tent here.");
					return false;
				}
				for (int k = y + 1; k < y + 5; k++) {
					if (!wd.isAirBlock(i, k, j)) {
						ep.addChatMessage("Cannot build tent here.");
						return false;
					}
				}
			}
		}
		return true;
	}

	private void buildTent(int x, int y, int z, World wd) {
		int block;
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 8; j++) {
					if (k == 0 && j == 4 && i == 3)
						continue;

					block = tentScheme[k][j][i];

					if (block <= 0)
						continue;
					wd.setBlock(i + x - 3, k + y, j + z - 4, block);
					wd.setBlockMetadata(i + x - 3, k + y, j + z - 4, 1);

					if (block == d) {
						int meta = 3;
						if (k > 1)
							meta = 11;
						wd.setBlockMetadata(i + x - 3, k + y, j + z - 4, meta);
					}
				}
			}
		}
		wd.setBlockMetadata(x, y, z, 1);
	}

	private void destroyTent(int x, int y, int z, World wd, EntityPlayer ep) {
		wd.setBlockMetadataWithNotify(x, y, z, 0);
		int block;
		for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 8; j++) {
					if (tentScheme[k][j][i] == -1)
						continue;

					block = wd.getBlockId(i + x - 3, k + y, j + z - 4);
					if (block == 0) {
						continue;
					} else if (block == this.blockID)
						continue;
					else if (block != tentScheme[k][j][i]) {
						Block.blocksList[block].dropBlockAsItem(wd, i + x - 3,
								k + y, j + z - 4, wd.getBlockMetadata(
										i + x - 3, k + y, j + z - 4), j);
					}

					block = 0;
					if (k == 0) {
						block = wd.getBlockId(x, y - 1, z);
					}
					wd.setBlockWithNotify(i + x - 3, k + y, j + z - 4, block);
				}
			}
		}
	}

	private int b = mod_moonmod.ReinfCloth.blockID;
	private int d = Block.doorWood.blockID;
	private int[][][] tentScheme = new int[][][] {
			new int[][] { new int[] { -1, b, b, b, b, b, -1 },
					new int[] { b, b, b, b, b, b, b },
					new int[] { b, b, b, b, b, b, b },
					new int[] { b, b, b, b, b, b, b },
					new int[] { b, b, b, b, b, b, b },
					new int[] { b, b, b, b, b, b, b },
					new int[] { -1, b, b, b, b, b, -1 },
					new int[] { -1, -1, b, b, b, -1, -1 } },

			new int[][] { new int[] { -1, b, b, b, b, b, -1 },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { b, 0, 0,/**/0, 0, 0, b },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { -1, b, 0, 0, 0, b, -1 },
					new int[] { -1, -1, b, d, b, -1, -1 } },

			new int[][] { new int[] { -1, b, b, b, b, b, -1 },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { b, 0, 0, 0, 0, 0, b },
					new int[] { -1, b, 0, 0, 0, b, 0 },
					new int[] { -1, -1, b, d, b, -1, -1 } },

			new int[][] { new int[] { -1, -1, b, b, b, -1, -1 },
					new int[] { -1, b, 0, 0, 0, b, -1 },
					new int[] { -1, b, 0, 0, 0, b, -1 },
					new int[] { -1, b, 0, 0, 0, b, -1 },
					new int[] { -1, b, 0, 0, 0, b, -1 },
					new int[] { -1, b, 0, 0, 0, b, -1 },
					new int[] { -1, -1, b, b, b, -1, -1 },
					new int[] { -1, -1, -1, b, -1, -1, -1 } },

			new int[][] { new int[] { -1, -1, -1, -1, -1, -1, -1 },
					new int[] { -1, -1, b, b, b, -1, -1 },
					new int[] { -1, -1, b, b, b, -1, -1 },
					new int[] { -1, -1, b, b, b, -1, -1 },
					new int[] { -1, -1, b, b, b, -1, -1 },
					new int[] { -1, -1, b, b, b, -1, -1 },
					new int[] { -1, -1, -1, -1, -1, -1, -1 },
					new int[] { -1, -1, -1, -1, -1, -1, -1 } } };


public static boolean inTent(World wd, int x, int y, int z) {
	int sides = 0;
	boolean ceil = false;
	for (int i = -5; i < 128; i++) {
		if (wd.getBlockId(x, y + i, z) == mod_moonmod.reinfID
				|| wd.getBlockId(x, y + i, z) == mod_moonmod.aluingotID) {
			ceil = true;
			break;
		}
	}
	if (!ceil)
		return false;

	for (int i = -32; i <= 0; i++) {
		if (wd.getBlockId(x + i, y, z) == mod_moonmod.reinfID
				|| wd.getBlockId(x + i, y, z) == mod_moonmod.aluingotID) {
			sides++;
			break;
		}
	}

	for (int i = -32; i <= 0; i++) {
		if (wd.getBlockId(x - i, y, z) == mod_moonmod.reinfID
				|| wd.getBlockId(x - i, y, z) == mod_moonmod.aluingotID) {
			sides++;
			break;
		}
	}

	for (int i = -32; i <= 0; i++) {
		if (wd.getBlockId(x, y, z + i) == mod_moonmod.reinfID
				|| wd.getBlockId(x, y, z + i) == mod_moonmod.aluingotID) {
			sides++;
			break;
		}
	}

	for (int i = -32; i <= 0; i++) {
		if (wd.getBlockId(x, y, z - i) == mod_moonmod.reinfID
				|| wd.getBlockId(x, y, z - i) == mod_moonmod.aluingotID) {
			sides++;
			break;
		}
	}

	if (sides >= 3)
		return true;
	else
		return false;
}
}