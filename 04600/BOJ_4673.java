import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] num = new boolean[10001];
		
		for(int i = 1; i <= 10000; i++) {
			int r = d(i + "");
			if (r <= 10000)
				num[r] = true;
		}
		
		for(int i = 1; i <= 10000; i++) {
			if (!num[i])
				bw.write(i + "\n");
		}
	
		bw.flush();
		bw.close();
		
	}
	
	private static int d(String n) {
		int result = Integer.parseInt(n);
		for (int i = 0; i < n.length(); i++) {
			result += n.charAt(i) - '0';
		}
		
		return result;
	}
}
