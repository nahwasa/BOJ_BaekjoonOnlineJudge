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
		Ppl[] arr = new Ppl[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Ppl(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		bw.write(arr[0].nation + " " + arr[0].num + "\n");
		int tmp = arr[0].nation;
		bw.write(arr[1].nation + " " + arr[1].num + "\n");
		if (tmp == arr[1].nation) {
			
			for (Ppl p : arr) {
				if (p.nation != tmp) {
					bw.write(p.nation + " " + p.num + "\n");
					break;
				}
			}
			
		} else {
			bw.write(arr[2].nation + " " + arr[2].num + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class Ppl implements Comparable<Ppl> {
	int nation;
	int num;
	int score;	
	
	public Ppl(int nation, int num, int score) {
		super();
		this.nation = nation;
		this.num = num;
		this.score = score;
	}

	@Override
	public int compareTo(Ppl o) {		
		return o.score-this.score;
	}
}
