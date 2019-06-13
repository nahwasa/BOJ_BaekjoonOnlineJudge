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
		boolean[] cup = new boolean[4];
		cup[1] = true;
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			boolean tmp = cup[a];
			cup[a] = cup[b];
			cup[b] = tmp;
		}
		for (int i = 1; i < 4; i++)
			if (cup[i])
				bw.write(i+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
