import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());		
		Hw[] arr = new Hw[N];
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[N] = new Hw(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		HashSet<Integer> hs = new HashSet<Integer>();	// 이미 넣은 시간인지 확인용
		int sum = 0;
		for (Hw h : arr) {
			for (int i = h.dueDate; i >= 1; i--) {
				if (!hs.contains(i)) {
					hs.add(i);
					sum+=h.score;
					break;
				}
			}
		}
		bw.write(sum+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}	
}

class Hw implements Comparable<Hw>{
	int dueDate;
	int score;
	public Hw(int dueDate, int score) {
		super();
		this.dueDate = dueDate;
		this.score = score;
	}
	@Override
	public int compareTo(Hw o) {
		return o.score-this.score;
	}	
}
