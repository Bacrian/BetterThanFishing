package imbacrian.btf.blocks;

import imbacrian.btf.BTFConfig;
import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlock;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;

public class BlocksList {

	public static int initialID = 6200;
	private static final String MOD_ID = BetterThanFishing.MOD_ID;

	public static int newBlockID() {
		return initialID++;
	}

	public static Block<?> CHOPPING_BOARD;
	public static Block<?> DYED_CHOPPING_BOARD;
	public static Block<?> TACKLE_BOX;
	public static Block<?> DYED_TACKLE_BOX;
	public static Block<?> CROPS_RICE;

	private static boolean hasInit = false;

	public static void Init() {
		if (!hasInit) {
			hasInit = true;
			initialID = BTFConfig.blockStart;
			initBlocks();
		}
	}

	public static void initBlocks() {
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

		TACKLE_BOX = new BlockBuilder(MOD_ID)
			.setHardness(2.5F)
			.setResistance(2.5F)
			.setBlockSound(BlockSounds.WOOD)
			.setTileEntity(TileEntityTackleBox::new)
			.setUseInternalLight()
			.setLightOpacity(0)
			.setTags(BlockTags.NOT_IN_CREATIVE_MENU)
			.setBlockItem(ItemBlock::new)
			.build("tackle_box", newBlockID(), block -> new BlockLogicTackleBox(block));

		DYED_TACKLE_BOX = new BlockBuilder(MOD_ID)
			.setHardness(2.5F)
			.setResistance(2.5F)
			.setBlockSound(BlockSounds.WOOD)
			.setTileEntity(TileEntityTackleBox::new)
			.setUseInternalLight()
			.setLightOpacity(0)
			.setTags(BlockTags.NOT_IN_CREATIVE_MENU)
			.setBlockItem(ItemBlock::new)
			.build("dyed_tackle_box", newBlockID(), block -> new BlockLogicTackleBoxPainted(block));

		CROPS_RICE = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRASS)
			.setHardness(0.0F)
			.setTags(BlockTags.BROKEN_BY_FLUIDS, BlockTags.NOT_IN_CREATIVE_MENU)
			.build("crops_rice", newBlockID(), block -> new BlockLogicCropsRice(block));
	}

}
