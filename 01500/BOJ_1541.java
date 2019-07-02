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
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "+-");		
		StringTokenizer st2 = new StringTokenizer(str, "0123456789");		
		int sum = Integer.parseInt(st.nextToken());
		boolean chk = false;
		while (st.hasMoreTokens()) {
			if (!chk&&st2.nextToken().charAt(0) == '-')
				chk = true;
			if (chk) sum -= Integer.parseInt(st.nextToken());
			else     sum += Integer.parseInt(st.nextToken());
		}
		bw.write(sum + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}
