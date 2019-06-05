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
				
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			Stack<Character> stk = new Stack<Character>();
			
			for (int j = 0; j < s.length(); j++) {
				if (!stk.isEmpty() && stk.peek() == s.charAt(j)) {
					stk.pop();
					continue;
				}
				
				stk.push(s.charAt(j));		
			}
			
			if (stk.isEmpty())
				cnt++;
		}
		
		bw.write(cnt + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
