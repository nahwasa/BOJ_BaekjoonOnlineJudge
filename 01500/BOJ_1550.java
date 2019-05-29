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
		int result = 0;
		
		int hex = 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			result += hexToDec(str.charAt(i)) * hex;
			hex *= 16;
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		br.close();
		bw.close();		
	}	
	
	private static int hexToDec(char c) {
		switch(c) {
		case 'A':return 10;
		case 'B':return 11;
		case 'C':return 12;
		case 'D':return 13;
		case 'E':return 14;
		case 'F':return 15;
		default : return c - '0';
		}
	}
}
