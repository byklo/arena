public class Game {

	private final MapService mapService;
	private final PlayerService playerService;
	private final BattleService battleService;

	public Game(int N) {
		this.playerService = new PlayerService();
		this.mapService = new MapService(this.playerService, N);
		this.battleService = new BattleService();
	}

	public Game(int N, int M) {
		this.playerService = new PlayerService();
		this.mapService = new MapService(this.playerService, N, M);
		this.battleService = new BattleService();
	}

	public void run() {
		System.out.println("Game has started.");
		// game loop
	}

	public void addPlayer(Teams team, Player player) {
		this.playerService.addPlayer(team, player);
	}

	public void addPlayersToMap() {
		this.mapService.initPlayerLocations();
	}

	public void info() {
		this.playerService.info();
	}

	public void draw() {
		this.mapService.printMap();
	}

	public static void main(String[] args) {
		Game game = new Game(5, 6);
		game.addPlayer(Teams.team1, new Player('X'));
		game.addPlayer(Teams.team2, new Player('Y'));
		game.addPlayersToMap();
		game.info();
		game.draw();
	}
}