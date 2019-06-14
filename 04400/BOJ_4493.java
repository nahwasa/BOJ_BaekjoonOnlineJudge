import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			int cnt1 = 0;
			int cnt2 = 0;
			int N = Integer.parseInt(br.readLine());
			while(N-->0) {
				String s = br.readLine();
				switch (s) {
				case "R R" :
				case "P P" :
				case "S S" :
					break;
				case "R S" :
				case "P R" :
				case "S P" :
					cnt1++;
					break;
				default :
					cnt2++;
					break;
				}
			}			
			if (cnt1==cnt2)
				bw.write("TIE\n");
			else if (cnt1>cnt2)
				bw.write("Player 1\n");
			else
				bw.write("Player 2\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
