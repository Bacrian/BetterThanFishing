package imbacrian.btf.items;

public enum BoardColor {
	OAK("oak"),
	BLACK("black"),
	BLUE("blue"),
	BROWN("brown"),
	CYAN("cyan"),
	GRAY("gray"),
	GREEN("green"),
	LIGHTBLUE("lightblue"),
	LIME("lime"),
	MAGENTA("magenta"),
	ORANGE("orange"),
	PINK("pink"),
	PURPLE("purple"),
	RED("red"),
	SILVER("silver"),
	WHITE("white"),
	YELLOW("yellow");

	private final String color;

	BoardColor(String color) {
		this.color = color;
	}

	public String getBoardColor() {
		return color;
	}
}
