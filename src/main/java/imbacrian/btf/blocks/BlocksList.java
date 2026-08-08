package imbacrian.btf.blocks;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.items.BoardColor;
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
	public static Block<?> BLACK_CHOPPING_BOARD;
	public static Block<?> BLUE_CHOPPING_BOARD;
	public static Block<?> BROWN_CHOPPING_BOARD;
	public static Block<?> CYAN_CHOPPING_BOARD;
	public static Block<?> GRAY_CHOPPING_BOARD;
	public static Block<?> GREEN_CHOPPING_BOARD;
	public static Block<?> LIGHTBLUE_CHOPPING_BOARD;
	public static Block<?> LIME_CHOPPING_BOARD;
	public static Block<?> MAGENTA_CHOPPING_BOARD;
	public static Block<?> ORANGE_CHOPPING_BOARD;
	public static Block<?> PINK_CHOPPING_BOARD;
	public static Block<?> PURPLE_CHOPPING_BOARD;
	public static Block<?> RED_CHOPPING_BOARD;
	public static Block<?> SILVER_CHOPPING_BOARD;
	public static Block<?> WHITE_CHOPPING_BOARD;
	public static Block<?> YELLOW_CHOPPING_BOARD;

	public static void Init() {
		CHOPPING_BOARD = buildChoppingBoard("chopping_board", newBlockID(), BoardColor.OAK);
		BLACK_CHOPPING_BOARD = buildChoppingBoard("black.chopping_board", newBlockID(), BoardColor.BLACK);
		BLUE_CHOPPING_BOARD = buildChoppingBoard("blue.chopping_board", newBlockID(), BoardColor.BLUE);
		BROWN_CHOPPING_BOARD = buildChoppingBoard("brown.chopping_board", newBlockID(), BoardColor.BROWN);
		CYAN_CHOPPING_BOARD = buildChoppingBoard("cyan.chopping_board", newBlockID(), BoardColor.CYAN);
		GRAY_CHOPPING_BOARD = buildChoppingBoard("gray.chopping_board", newBlockID(), BoardColor.GRAY);
		GREEN_CHOPPING_BOARD = buildChoppingBoard("green.chopping_board", newBlockID(), BoardColor.GREEN);
		LIGHTBLUE_CHOPPING_BOARD = buildChoppingBoard("lightblue.chopping_board", newBlockID(), BoardColor.LIGHTBLUE);
		LIME_CHOPPING_BOARD = buildChoppingBoard("lime.chopping_board", newBlockID(), BoardColor.LIME);
		MAGENTA_CHOPPING_BOARD = buildChoppingBoard("magenta.chopping_board", newBlockID(), BoardColor.MAGENTA);
		ORANGE_CHOPPING_BOARD = buildChoppingBoard("orange.chopping_board", newBlockID(), BoardColor.ORANGE);
		PINK_CHOPPING_BOARD = buildChoppingBoard("pink.chopping_board", newBlockID(), BoardColor.PINK);
		PURPLE_CHOPPING_BOARD = buildChoppingBoard("purple.chopping_board", newBlockID(), BoardColor.PURPLE);
		RED_CHOPPING_BOARD = buildChoppingBoard("red.chopping_board", newBlockID(), BoardColor.RED);
		SILVER_CHOPPING_BOARD = buildChoppingBoard("silver.chopping_board", newBlockID(), BoardColor.SILVER);
		WHITE_CHOPPING_BOARD = buildChoppingBoard("white.chopping_board", newBlockID(), BoardColor.WHITE);
		YELLOW_CHOPPING_BOARD = buildChoppingBoard("yellow.chopping_board", newBlockID(), BoardColor.YELLOW);
	}

	private static Block<?> buildChoppingBoard(String key, int id, BoardColor color) {
		return new BlockBuilder(MOD_ID)
			.setHardness(0.5F)
			.setResistance(0.5F)
			.setBlockSound(BlockSounds.WOOD)
			.setTileEntity(TileEntityChoppingBoard::new)
			.setUseInternalLight()
			.setLightOpacity(0)
			.setTags(BlockTags.NOT_IN_CREATIVE_MENU)
			.setBlockItem(ItemBlock::new)
			.build(key,id,block -> new BlockLogicChoppingBoard(block, color));
	}

	public static Block<?> getBlockForColor(BoardColor color) {
		if (color == BoardColor.OAK) return CHOPPING_BOARD;
		if (color == BoardColor.BLACK) return BLACK_CHOPPING_BOARD;
		return CHOPPING_BOARD;
	}

	public static BoardColor getColorForBlock(int blockId) {
		if (CHOPPING_BOARD != null && blockId == CHOPPING_BOARD.id()) return BoardColor.OAK;
		if (BLACK_CHOPPING_BOARD != null && blockId == BLACK_CHOPPING_BOARD.id()) return BoardColor.BLACK;
		if (BLUE_CHOPPING_BOARD != null && blockId == BLUE_CHOPPING_BOARD.id()) return BoardColor.BLUE;
		if (BROWN_CHOPPING_BOARD != null && blockId == BROWN_CHOPPING_BOARD.id()) return BoardColor.BROWN;
		if (CYAN_CHOPPING_BOARD != null && blockId == CYAN_CHOPPING_BOARD.id()) return BoardColor.CYAN;
		if (GRAY_CHOPPING_BOARD != null && blockId == GRAY_CHOPPING_BOARD.id()) return BoardColor.GRAY;
		if (GREEN_CHOPPING_BOARD != null && blockId == GREEN_CHOPPING_BOARD.id()) return BoardColor.GREEN;
		if (LIGHTBLUE_CHOPPING_BOARD != null && blockId == LIGHTBLUE_CHOPPING_BOARD.id()) return BoardColor.LIGHTBLUE;
		if (LIME_CHOPPING_BOARD != null && blockId == LIME_CHOPPING_BOARD.id()) return BoardColor.LIME;
		if (MAGENTA_CHOPPING_BOARD != null && blockId == MAGENTA_CHOPPING_BOARD.id()) return BoardColor.MAGENTA;
		if (ORANGE_CHOPPING_BOARD != null && blockId == ORANGE_CHOPPING_BOARD.id()) return BoardColor.ORANGE;
		if (PINK_CHOPPING_BOARD != null && blockId == PINK_CHOPPING_BOARD.id()) return BoardColor.PINK;
		if (PURPLE_CHOPPING_BOARD != null && blockId == PURPLE_CHOPPING_BOARD.id()) return BoardColor.PURPLE;
		if (RED_CHOPPING_BOARD != null && blockId == RED_CHOPPING_BOARD.id()) return BoardColor.RED;
		if (SILVER_CHOPPING_BOARD != null && blockId == SILVER_CHOPPING_BOARD.id()) return BoardColor.SILVER;
		if (WHITE_CHOPPING_BOARD != null && blockId == WHITE_CHOPPING_BOARD.id()) return BoardColor.WHITE;
		if (YELLOW_CHOPPING_BOARD != null && blockId == YELLOW_CHOPPING_BOARD.id()) return BoardColor.YELLOW;
		return null;
	}

}
