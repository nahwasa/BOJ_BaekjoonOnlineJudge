import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cnt = new int[3];
		for (int i = 0; i < 3; i++)
			cnt[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int result = 0;
		for (int i = 0; i < 3; i++) {
			cnt[i] -= Integer.parseInt(st.nextToken());
			if (cnt[i] < 0)
				result-=cnt[i];
		}
		bw.write(result+"\n");		
		bw.flush();
		bw.close();
		br.close();
	}	
}
