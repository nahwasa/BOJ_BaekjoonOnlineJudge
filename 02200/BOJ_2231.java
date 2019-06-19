import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean chk = false;
		for (int i = 1; i <= 1000000; i++) {
			int tmp = i + sumEachNum(i);
			if (tmp == N) {
				bw.write(i + "\n");
				chk = true;
				break;
			}
		}
		if(!chk) bw.write("0\n");
		bw.flush();
		br.close();
		bw.close();		
	}

	private static int sumEachNum(int num) {
		if (num/10 == 0) return num;
		return num%10 + sumEachNum(num/10);
	}	
}
