import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = 0;
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			cnt += getNumber(str.charAt(i)) + 1;
		}
		
		bw.write(cnt + "\n");
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static int getNumber(char c) {
		switch (c) {
		case 'A' :
		case 'B' :
		case 'C' :
			return 2;
		case 'D' :
		case 'E' :
		case 'F' :
			return 3;
		case 'G' :
		case 'H' :
		case 'I' :
			return 4;
		case 'J' :
		case 'K' :
		case 'L' :
			return 5;
		case 'M' :
		case 'N' :
		case 'O' :
			return 6;
		case 'P' :
		case 'Q' :
		case 'R' :
		case 'S' :
			return 7;
		case 'T' :
		case 'U' :
		case 'V' :
			return 8;
		default :
			return 9;
		}
	}

}
