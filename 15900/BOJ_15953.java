import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	static int[] cp1;
	static int[] cp2;
	static int idx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		initPrice();
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tmp1 = cp1[Integer.parseInt(st.nextToken())];
			int tmp2 = cp2[Integer.parseInt(st.nextToken())];			
			bw.write(String.format("%d\n", (tmp1+tmp2)*10000));
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void initPrice() {
		cp1 = new int[101];
		cp2 = new int[65];
		idx = 1;
		setPrice(cp1, 500, 1);
		setPrice(cp1, 300, 2);
		setPrice(cp1, 200, 3);
		setPrice(cp1, 50, 4);
		setPrice(cp1, 30, 5);
		setPrice(cp1, 10, 6);
		idx = 1;
		setPrice(cp2, 512, 1);	
		setPrice(cp2, 256, 2);
		setPrice(cp2, 128, 4);
		setPrice(cp2, 64, 8);
		setPrice(cp2, 32, 16);
	}
	
	private static void setPrice(int[] cp, int price, int num) {
		while (num-->0)
			cp[idx++] = price;
	}
}
