import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int p, limit = 1, result = -1;
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		br.close();
		while (d-->0)
			limit *= 10;
		backTracking(1, 1, 2);
		System.out.println(p==0?1:result);
	}
	
	private static void backTracking(int curP, int curNum, int curMul) {
		for (int i = curMul; i <= 9; i++) {
			int tmp = curNum * i;
			if (tmp >= limit)
				break;
			if (curP >= p)
				result = Math.max(tmp, result);
			else
				backTracking(curP+1, tmp, i);
		}
	}
}
