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
		boolean left = getBoolean(st.nextToken());
		String op = st.nextToken();
		boolean right = getBoolean(st.nextToken());
		if (op.equals("OR")) bw.write(String.valueOf(left || right));
		else bw.write(String.valueOf(left && right));
		bw.flush();
		br.close();
		bw.close();		
	}
	
	static boolean getBoolean(String s) {
		if (s.equals("true")) return true;
		return false;
	}
}
