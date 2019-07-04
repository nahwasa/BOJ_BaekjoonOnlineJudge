import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		double e = 0.0;
		bw.write("n e\n" + 
				"- -----------\n");
		for (int i = 0; i <= 9; i++) {
			e += 1.0/factorial(i);
			String format = "";
			switch(i) {
			case 0 : case 1 : format="%d %.0f\n"; break;
			case 2 : format="%d %.1f\n"; break;
			default : format="%d %.9f\n";
			}
			bw.write(String.format(format, i, e));
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static int factorial(int num) {
		if (num == 0) return 1;
		int result = 1;
		for (int i = 1; i <= num; i++)
			result*=i;
		return result;
	}
}
