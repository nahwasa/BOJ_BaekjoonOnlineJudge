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
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		if (a > b) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		
		if (b == a) {
			bw.write("0\n");
			bw.flush();
			br.close();
			bw.close();	
			return;
		}
				
		StringBuffer sb = new StringBuffer();
		
		for (long i = a+1; i < b; i++) {
			sb.append(i);
			if (i != b-1)
				sb.append(" ");
		}	// faster than 'sb.append(i + " ");' or String s, s += i + " "; 

		bw.write(b-a-1 + "\n");
		bw.write(sb.toString() + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
}
