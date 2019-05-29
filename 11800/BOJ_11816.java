import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		if (str.charAt(1) == 'x') {
			bw.write(hexToDec(str.substring(2)) + "\n");
		} else if (str.charAt(0) == '0') {
			bw.write(octToDec(str.substring(1)) + "\n");
		} else {
			bw.write(str + "\n");
		}
				
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static int octToDec(String str) {
		int result = 0;
		
		int oct = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			result += hexToDec(str.charAt(i)) * oct;
			oct *= 8;
		}
		
		return result;
	}

	private static int hexToDec(String str) {
		int result = 0;
		
		int hex = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			result += hexToDec(str.charAt(i)) * hex;
			hex *= 16;
		}
		
		return result;
	}
	
	private static int hexToDec(char c) {
		switch(c) {
		case 'a':return 10;
		case 'b':return 11;
		case 'c':return 12;
		case 'd':return 13;
		case 'e':return 14;
		case 'f':return 15;
		default : return c - '0';
		}
	}
}
