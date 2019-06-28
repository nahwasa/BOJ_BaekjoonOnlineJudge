import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Pos[] arr = new Pos[N];
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[N] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		for (Pos p : arr)
			bw.write(String.format("%d %d\n", p.x, p.y));
		bw.flush();		
		bw.close();
		br.close();
	}
}

class Pos implements Comparable<Pos>{
	int x;
	int y;
	
	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pos o) {
		if (this.x==o.x)
			return this.y-o.y;
		return this.x-o.x;
	}
}
