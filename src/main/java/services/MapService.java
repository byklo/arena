import java.util.List;

public class MapService {
	
	private final GameMap map;
	private final PlayerService playerService;
	private final String emptyMap;
	private final String SPACE = " ";
	private final String HOR_LINE = "---";
	private final String VER_LINE = "|";

	public MapService(PlayerService playerService, int N) {
		this.playerService = playerService;
		this.map = new GameMap(N);
		this.emptyMap = this.generateEmptyMap();
	}

	public MapService(PlayerService playerService, int N, int M) {
		this.playerService = playerService;
		this.map = new GameMap(N, M);
		this.emptyMap = this.generateEmptyMap();
	}

	public void initPlayerLocations() {
		// i guess we have to hard-code for 2 teams
		int team1MRow = this.map.getM();
		int team2MRow = 1;
		int startingN;
		int n;

		for (Teams team : Teams.values()) {
			List<Player> players = this.playerService.getPlayersByTeam(team);
			startingN = (this.map.getN() - players.size()) / 2 + 1;
			n = startingN;
			for (Player player : players) {
				// hard-coded i know
				player.setLocation(n++, (team == Teams.team1) ? team1MRow : team2MRow);
			}
		}
	}

	private String generateEmptyMap() {
		StringBuilder output = new StringBuilder();
		String hor_row = SPACE + this.repeat(HOR_LINE + SPACE, this.map.getN());
		String ver_row = VER_LINE + this.repeat(SPACE + SPACE + SPACE + VER_LINE, this.map.getN());

		output.append(hor_row + "\n");

		for (int m = 0; m < this.map.getM(); m++) {
			output.append(ver_row + "\n" + hor_row + "\n");
		}

		output.deleteCharAt(output.length() - 1);
		return output.toString();
	}

	public String updatedMap() {
		StringBuilder output = new StringBuilder(this.emptyMap);
		for (Player player : this.playerService.getAllPlayers()) {
			if (this.isValidLocation(player.getLocation())) {
				int x = player.getLocation().getX();
				int y = player.getLocation().getY();
				int n = this.map.getN();
				int index = 4 * (2 * n * y - n + y + x - 1);
				output.setCharAt(index, player.getName());	
			}
		}
		return output.toString();
	}

	public boolean isValidLocation(Location location) {
		int x = location.getX();
		int y = location.getY();
		return x > 0 && x <= this.map.getN() && y > 0 && y <= this.map.getM();
	}

	public void printMap() {
		System.out.println(this.updatedMap());
	}

	private String repeat(String str, int times) {
		String output = "";
		for(int i = 0; i < times; i++) {
			output += str;
		}
		return output;
	}
}