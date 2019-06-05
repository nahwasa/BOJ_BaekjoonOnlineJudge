import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int cntA = 0;	// 가단조 카운트
		int cntC = 0;	// 다장조 카운트
		char c = 0;
		char e = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "|");
		while (st.hasMoreTokens()) {
			String tmp = st.nextToken();
			c = tmp.charAt(0);
			e = tmp.charAt(tmp.length()-1);

			if (switchProc(c) == 1)		 cntA++;
			else if (switchProc(c) == 2) cntC++;			
		}
		
		bw.write(cntA>cntC?"A-minor": cntC>cntA?"C-major": switchProc(e)==1?"A-minor":"C-major");
		bw.newLine();		
		
		bw.flush();		
		bw.close();
		br.close();
	}
	
	/*
	 * return 	1 : 가단조
	 * 		    	2 : 다장조
	 * 		     -1 : 판단불가
	 */
	static int switchProc(char c) {
		switch (c) {
		case 'A' :
		case 'D' :
		case 'E' :
			return 1;
		case 'C' :
		case 'F' :
		case 'G' :
			return 2;
		default :
			return -1;
		}
	}
}
