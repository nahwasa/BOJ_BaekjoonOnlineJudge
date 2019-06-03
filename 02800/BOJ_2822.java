import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Score[] arr = new Score[8];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Score(Integer.parseInt(br.readLine()), i+1);
		}
		
		Arrays.sort(arr, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {				
				return o2.score - o1.score;
			}			
		});
		
		arr = Arrays.copyOf(arr, 5);
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i].score;
		
		
		Arrays.sort(arr, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {				
				return o1.idx - o2.idx;
			}			
		});
		
		bw.write(sum + "\n");
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i].idx + "");
			if (i != arr.length-1)
				bw.write(" ");
			else
				bw.write("\n");
		}
		
		
		bw.flush();		
		bw.close();
		br.close();
	}
}	

class Score {
	int score;
	int idx;
	
	public Score(int score, int idx) {
		this.score = score;
		this.idx = idx;
	}
}
