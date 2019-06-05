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
		
		int chk = 2;	// 소문자만 있으면 뭘로 하든 상관없음
		String s = br.readLine();
		
		if (s.contains("_")) {	// check c or java
			chk = 1;	// c 
		} 
		
		
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) <= 'Z') {	// 언더바나 소문자는 모두 'Z'보다 아스키코드가 높음
				if (chk == 1)	// 대문자에 언더바까지 있으면 판단불가
					chk = -1;
				else
					chk = 2; 	// java
				break;
			}
		
		if (s.charAt(0) == '_' || s.charAt(0) <= 'Z' || s.charAt(s.length()-1) == '_')	// 시작이나 끝이 _이거나, 시작이 대문자면 에러
			chk = -1;
		
		if (s.contains("__"))	// 언더바가 연속으로 오면 에러
			chk = -1;
	
		
		switch (chk) {
		case 1 :
			bw.write(cToJava(s));
			break;
		case 2 :
			bw.write(javaToC(s));
			break;
		default :
			bw.write("Error!\n");
			break;
		}
		
				
		
		bw.flush();		
		bw.close();
		br.close();
	}
	
	static String javaToC(String s) {
		StringBuilder sb = new StringBuilder();
		int gap = 'A'-'a';
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) <= 'Z') {
				sb.append('_');
				sb.append((char)(s.charAt(i) - gap));
			} else {
				sb.append(s.charAt(i));
			}
		}
		sb.append("\n");
		
		return sb.toString();
	}

	static String cToJava(String s) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(s, "_");
		int gap = 'A'-'a';
		
		sb.append(st.nextToken());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();			
			sb.append((char)(tmp.charAt(0) + gap));
			for (int i = 1; i < tmp.length(); i++)
				sb.append(tmp.charAt(i));
		}
		sb.append("\n");
		return sb.toString();		
	}
}
