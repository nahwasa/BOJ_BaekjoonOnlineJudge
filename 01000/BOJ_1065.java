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
		int result = 0;
		
		if (in <= 99)
			result += in;
		else {
			result = 99;
			for (int i = 100; i <= in; i++) {
				if (i == 1000) {
					break;
				}
				
				if (isHansu(i + "")) {
					result++;
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static boolean isHansu(String n) {
		int a = n.charAt(0) - '0';
		int b = n.charAt(1) - '0';
		int c = n.charAt(2) - '0';
		
		if (a - b == b - c)
			return true;		
		return false;
	}
}
