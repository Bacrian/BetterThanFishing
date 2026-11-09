package imbacrian.btf;

import net.minecraft.core.enums.ArtType;

public class BTFPaintings {
	public static ArtType FIH;
	public static ArtType FISH_PROFILE;
	public static ArtType IM_UNDER_THE_WATER;
	public static ArtType THEY_STARIN;
	public static ArtType YOU_KNOW;

	//I kinda like this little goober, just because it looks cute tho.
	public static ArtType BOYFISHER;

	public static ArtType THIS_IS_FINE;
	public static ArtType GOLD_TUNA;

	public static void InitPaintings() {
		FIH = new ArtType("fih","Fih","","btf:art/fih", 64,48);
		FISH_PROFILE = new ArtType("fish_profile", "Fish", "", "btf:art/fish_profile",64,48);
		IM_UNDER_THE_WATER = new ArtType("im_under_the_water", "Hello, I'm under the water, please help", "Just Sul", "btf:art/imunderthewater",32,48);
		THEY_STARIN = new ArtType("they_starin", "They Starin'", "", "btf:art/theystarin",32,32);
		YOU_KNOW = new ArtType("you_know", "You know what that means","FISH", "btf:art/youknowwhatthatmeans",16,16);
		// Yes, I drew the mofo, I took the time and effort to replicate the style by hand.
		BOYFISHER = new ArtType("boyfisher","Boyfisher", "Edit by: Bacrian", "btf:art/boyfisher",64,64);
		THIS_IS_FINE = new ArtType("this_is_fine", "This is fine", "Edit by: Bacrian", "btf:art/thisisfine",32,32);
		GOLD_TUNA = new ArtType("gold_tuna", "Golden Tuna", "Bacrian", "btf:art/gold_tuna", 16,16);
	}
}
