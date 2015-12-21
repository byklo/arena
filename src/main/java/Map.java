public class Map {
	
	private int N;
	private int M;

	public Map(int N) {
		this.N = N;
		this.M = N;
	}

	public Map(int N, int M) {
		this.N = N;
		this.M = M;
	}

	public void print() {
		String SPACE = " ";
		String HOR_LINE = "---";
		String VER_LINE = "|";

		String hor_row = SPACE + this.repeat(HOR_LINE + SPACE, this.N);
		String ver_row = VER_LINE + this.repeat(SPACE + SPACE + SPACE + VER_LINE, this.N);

		System.out.println(hor_row);

		for (int n = 0; n < this.M; n++) {
			System.out.println(ver_row);
			System.out.println(hor_row);
		}
	}

	private String repeat(String str, int times) {
		String output = "";
		for(int i = 0; i < times; i++) {
			output += str;
		}
		return output;
	}
}
