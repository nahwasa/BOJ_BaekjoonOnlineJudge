import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] cntFinger = new int[8];
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++)
			cntFinger[fingerUsed(str.charAt(i))]++;
		
		for (int i = 0; i < cntFinger.length; i++)
			bw.write(cntFinger[i] + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
	
	private static int fingerUsed(char c) {
		if (c >= 'A' && c <= 'Z')	// 대문자로 들어오면 소문자로.
			c = (char) (c - ('A'-'a'));
		
		switch (c) {
		case '1' :
		case 'q' :
		case 'a' :
		case 'z' :
		case '`' :
			return 0;
		case '2' :
		case 'w' :
		case 's' :
		case 'x' :
			return 1;
		case '3' :
		case 'e' :
		case 'd' :
		case 'c' :
			return 2;
		case '4' :
		case 'r' :
		case 'f' :
		case 'v' :
		case '5' :
		case 't' :
		case 'g' :
		case 'b' :
			return 3;
		case '8' :
		case 'i' :
		case 'k' :
		case ',' :
			return 5;
		case '9' :
		case 'o' :
		case 'l' :
		case '.' :
			return 6;
		case '0' :
		case 'p' :
			return 7;
		default :
			if (('0' <= c && '9' >= c) || ('a' <= c && 'z' >= c))
				return 4;
			else
				return 7;
		}
	}
}	
