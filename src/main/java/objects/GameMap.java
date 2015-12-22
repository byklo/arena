public class GameMap {
	
	private int N;
	private int M;

	public GameMap(int N) {
		this.N = N;
		this.M = N;
	}

	public GameMap(int N, int M) {
		this.N = N;
		this.M = M;
	}

	public int getN() {
		return this.N;
	}

	public int getM() {
		return this.M;
	}
}