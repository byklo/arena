public class Game {

	private final Map map;

	public Game(int N) {
		this.map = new Map(N);
		this.map.print();
		System.out.println(N);
	}

	public static void main(String[] args) {
		Game game = new Game(5);
	}
}
