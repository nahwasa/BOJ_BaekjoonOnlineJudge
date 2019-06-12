import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<String>();
		int sum = A + B;
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		while(A-->0)
			hs.add(st.nextToken());
		st = new StringTokenizer(br.readLine());
		while(B-->0)
			if(hs.contains(st.nextToken())) cnt++;
		bw.write((sum - 2*cnt) + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
