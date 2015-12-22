public class Player {
	
	private final char name;
	private Teams team;
	private final Location location;

	public Player(char name) {
		this.name = name;
		this.location = new Location();
	}

	public char getName() {
		return this.name;
	}

	public void setTeam(Teams team) {
		this.team = team;
	}

	public Teams getTeam() {
		return this.team;
	}

	public void setLocation(int x, int y) {
		this.location.set(x, y);
	}

	public Location getLocation() {
		return this.location;
	}
}