package imbacrian.btf.blocks;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

public class BlocksList {

	public static int initialID = 6000;
	private static final String MOD_ID = BetterThanFishing.MOD_ID;

	public static int newBlockID() {
		return initialID++;
	}

	public static Block<?> CHOPPING_BOARD;
	public static Block<?> DYED_CHOPPING_BOARD;

	public static void Init() {
		CHOPPING_BOARD = new BlockBuilder(MOD_ID)
			.setHardness(0.5F)
			.setResistance(0.5F)
			.setBlockSound(BlockSounds.WOOD)
			.setTileEntity(TileEntityChoppingBoard::new)
			.setUseInternalLight()
			.setLightOpacity(0)
			.setTags(BlockTags.NOT_IN_CREATIVE_MENU)
			.setBlockItem(ItemBlock::new)
			.build("chopping_board", newBlockID(), block -> new BlockLogicChoppingBoard(block));

		DYED_CHOPPING_BOARD = new BlockBuilder(MOD_ID)
			.setHardness(0.5F)
			.setResistance(0.5F)
			.setBlockSound(BlockSounds.WOOD)
			.setTileEntity(TileEntityChoppingBoard::new)
			.setUseInternalLight()
			.setLightOpacity(0)
			.setTags(BlockTags.NOT_IN_CREATIVE_MENU)
			.setBlockItem(ItemBlock::new)
			.build("dyed_chopping_board", newBlockID(), block -> new BlockLogicChoppingBoardPainted(block));
	}

}
