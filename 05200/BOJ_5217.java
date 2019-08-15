import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int n = Integer.parseInt(br.readLine());
			bw.write("Pairs for " + n + ": ");
			boolean flag = false;
			for (int i = 1; i < 11; i++) {
				for (int j = i+1; j < 12; j++) {
					if (i + j > n)
						break;
					if (i + j == n) {
						if (!flag) {
							bw.write(i + " " + j);
							flag = true;
						} else {
							bw.write(", " + i + " " + j);
						}
					}
				}
			}
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
