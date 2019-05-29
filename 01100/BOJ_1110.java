import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int in = Integer.parseInt(br.readLine());
		String n = ""; 
		
		if (in < 10)
			n = "0" + in;
		else 
			n+= in;
		
		int cnt = 1;
		String tmp = n.toString();
		
		for(;;cnt++) {
			tmp = method(tmp);
			if (tmp.equals(n))
				break;
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static String method(String n) {
		int left = n.charAt(0) - '0';
		int right = n.charAt(1) - '0';
		
		int tmp = left + right;
		if (tmp >= 10)
			tmp %= 10;
		
		return "" + right + tmp;
	}
}
