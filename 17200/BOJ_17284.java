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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca = 5000;
		while (st.hasMoreTokens())
			switch(st.nextToken()) {
			case "1" : ca-=500; break;
			case "2" : ca-=800; break;
			case "3" : ca-=1000; break;
			}
		bw.write(ca+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
