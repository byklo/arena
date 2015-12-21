public class Game {

	private final Map map;

	public Game(int N) {
		this.map = new Map(N);
		this.map.print();
	}

	public Game(int N, int M) {
		this.map = new Map(N, M);
		this.map.print();
	}

	public static void main(String[] args) {
		Game game = new Game(5, 6);
	}
}
