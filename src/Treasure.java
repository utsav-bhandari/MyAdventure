/** A treasure. */
public class Treasure {

	/** A description of this treasure. */
	private String description;

	/** This treasure's name. */
	private String name;

	private String emoticon;
	private final int ID;

	/**
	 * @param name
	 *            This treasure's name.
	 *            The value of this treasure.
	 * @param description
	 *            A description of this treasure.
	 */
	public Treasure(String name, String emoticon, String description, int ID) {
		this.name = name;
		this.emoticon = emoticon;
		this.description = description;
		this.ID = ID;
	}

	/** Returns a description of this treasure. */
	public String getDescription() {
		return this.description;
	}

	/** Returns this treasure's name. */
	public String getName() {
		return this.name;
	}

	public String getNameWithEmoji() {
		return this.name + emoticon;
	}
	public int getID() {
		return this.ID;
	}
}
