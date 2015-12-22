import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class PlayerService {

	private final Map<Teams, List<Player>> teams;
	private final List<Player> players;

	public PlayerService() {
		teams = new HashMap<Teams, List<Player>>();
		players = new ArrayList<Player>();

		for (Teams team : Teams.values()) {
			teams.put(team, new ArrayList<Player>());
		}
	}

	public void addPlayer(Teams team, Player player) {
		player.setTeam(team);
		teams.get(team).add(player);
		players.add(player);
	}

	public List<Player> getPlayersByTeam(Teams team) {
		return this.teams.get(team);
	}

	public List<Player> getAllPlayers() {
		return this.players;
	}

	public void info() {
		System.out.println("-> PlayerService.info()");
		for (Teams team : Teams.values()) {
			System.out.println("  " + team);
			for (Player player : teams.get(team)) {
				System.out.println("    - " + player.getName());
				System.out.println("      " + player.getTeam());
				System.out.println("      " + player.getLocation().toString());
			}
		}
	}
}