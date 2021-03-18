import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX_NUM = (10+1)*5;
	private static int n;
	private static int[] dr = {1, 0, 0, 1, 0, 1, 1};	//0~2 : solo, 3~5 : duo, 6 : triple
	private static int[] dg = {0, 1, 0, 1, 1, 0, 1};
	private static int[] db = {0, 0, 1, 0, 1, 1, 1};
	private static int[] fact;
	static long[][][][] dp;
	
	private static int inputToyNum(String s) {
		return Math.min(Integer.parseInt(s), MAX_NUM);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		RemainToy toy = new RemainToy(inputToyNum(st.nextToken()), inputToyNum(st.nextToken()), inputToyNum(st.nextToken()));
		br.close();
		
		calcFactorial(n);
		dp = new long[n+1][toy.r+1][toy.g+1][toy.b+1];
		for (long[][][] a : dp)
			for (long[][] b : a)
				for (long[] c : b)
					Arrays.fill(c, -1L);
		
		System.out.println(calcDP(1, toy));
	}
	
	private static void calcFactorial(int limit) {
		fact = new int[limit+1];
		fact[0] = 1;
		for (int i = 1; i <= limit; i++) {
			fact[i] = fact[i-1] * i;
		}
	}
	
	private static long calcDP(int k, RemainToy toy) {
		// escape condition
		if (k == n+1)
			return 1L;
		if (toy.isDpEx(k))
			return toy.getDp(k);
		
		// calc
		int r = toy.r, g = toy.g, b = toy.b;
		long res = 0L;
		for (int i = 0; i < 7; i++) {
			if ( (k % 3 != 0 && i / 3 == 2) || (k % 2 != 0 && i / 3 == 1) ) continue;
			int npt = k / (i / 3 + 1);	//num per toy
			RemainToy nextToy = new RemainToy(r-dr[i]*npt, g-dg[i]*npt, b-db[i]*npt);
			if (nextToy.isMinus()) continue;
			long calc = fact[k] / (fact[dr[i]*npt] * fact[dg[i]*npt] * fact[db[i]*npt]);
			res += calc * calcDP(k + 1, nextToy);
		}

		toy.setDp(k, res);
		return toy.getDp(k);
	}
}

class RemainToy {
	int r,g,b;
	public RemainToy(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public long getDp(int k) {
		return Main.dp[k][r][g][b];
	}
	
	public void setDp(int k, long val) {
		Main.dp[k][r][g][b] = val;
	}
	
	public boolean isDpEx(int k) {
		return Main.dp[k][r][g][b] >= 0L;
	}
	
	public boolean isMinus() {
		return r < 0 || g < 0 || b < 0;
	}
}
