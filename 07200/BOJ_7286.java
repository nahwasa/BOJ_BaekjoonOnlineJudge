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
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int[] arr = new int[1001];
			int N = Integer.parseInt(br.readLine());
			while (N-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for (int i = start; i < end; i++) 
					arr[i]++;				
			}
			for (int i = 0; i <= 1000; i++)
				if (arr[i]!=0) bw.write((char)(arr[i] - 1 + 'A'));
			bw.newLine();
		}
		br.close();
		bw.close();		
	}
}
