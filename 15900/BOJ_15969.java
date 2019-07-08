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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int min = 1000;		
		while(N-->0) {
			int num = Integer.parseInt(st.nextToken());
			if (num>max)max=num;
			if (num<min)min=num;
		}
		bw.write((max-min)+"\n");
		bw.flush();
		br.close();
		bw.close();
	}	
}
