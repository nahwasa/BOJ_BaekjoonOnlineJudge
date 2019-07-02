import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Ppl[] arr = new Ppl[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Ppl(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				Ppl.compareBig(arr[i], arr[j]);
			}
		}
		for (Ppl p : arr)
			bw.write(p.cnt+1 + " ");
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();		
	}
}
class Ppl {
	int x, y, cnt;
	public Ppl(int x, int y) {
		this.x = x;
		this.y = y;
		this.cnt = 0;
	}
	static void compareBig(Ppl a, Ppl b) {
		if (a.x > b.x && a.y > b.y)
			b.cnt++;
		else if (b.x > a.x && b.y > a.y)
			a.cnt++;
	}
}
