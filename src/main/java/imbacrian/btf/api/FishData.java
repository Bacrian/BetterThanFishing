package imbacrian.btf.api;

import imbacrian.btf.items.FishCategory;
import net.minecraft.core.item.Item;

public class FishData {
	public final Item item;
	public final int weight;
	public final boolean nether;
	public final FishCategory category;

	public FishData(Item item, int weight, boolean nether, FishCategory category) {
		this.item = item;
		this.weight = weight;
		this.nether = nether;
		this.category = category;
	}
}
