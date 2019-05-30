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
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		bw.write(minAdd(a, b) + " " + maxAdd(a, b) + "\n");		
		
		bw.flush();
		br.close();
		bw.close();		
	}	
	
	private static int minAdd(String a, String b) {
		return Integer.parseInt(a.replace('6', '5'))
				+ Integer.parseInt(b.replace('6', '5'));
		
	}
	
	private static int maxAdd(String a, String b) {
		return Integer.parseInt(a.replace('5', '6'))
				+ Integer.parseInt(b.replace('5', '6'));
	}
}
