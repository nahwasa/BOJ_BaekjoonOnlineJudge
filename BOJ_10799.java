import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		Stack<Object> st = new Stack<Object>();
		int cnt = 0;
		
		for (int i = 0; i < s.length(); i++) {		
			switch (s.charAt(i)) {
			case '(' :
				if (i != s.length()-1 && s.charAt(i+1) == ')') {	// laser
					cnt += st.size();
					i++;
					break;
				}
				st.push(new Object());
				
				break;
			case ')' :
				st.pop();
				cnt++;
				break;
			}
		}
		
		bw.write(cnt + "\n");
		
			
		bw.flush();
		bw.close();
		br.close();
	}	
}
