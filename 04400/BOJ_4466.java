import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static int M = 0;
	static int[] arr = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stack<Character> st = new Stack<Character>();
		for (int tc = 1; tc <= N; tc++) {
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);				
				if (c != ')') {
					st.push(s.charAt(i));
					continue;
				}
				char[] op = new char[2];
				int opIdx = 0;
				boolean isOr = true;
				while (!st.isEmpty()) {
					char tmp = st.pop();
					if (tmp == '(')
						break;
					switch(tmp) {
					case 't' : case 'f' : op[opIdx++] = tmp; break;
					case '!' : 
						char opTmp = op[opIdx-1];
						op[opIdx-1] = opTmp=='t'?'f':'t';
						break;
					case '|' : isOr = true; break;
					case '&' : isOr = false; break;						
					}
				}
				char result = '\0';
				if (!isOr && (op[0] == 't' && op[1] == 't'))
					result = 't';
				else if (isOr && (op[0] == 't' || op[1] == 't'))
					result = 't';
				else
					result = 'f';
				st.push(result);
			}
			String ans = "";
			while (!st.isEmpty()) {
				ans = st.pop() + ans;
			}
			
			if (ans.equals("t = t") || ans.equals("f = f") || ans.equals("!f = t") || ans.equals("!t = f"))
				bw.write(String.format("%d: Good brain\n", tc));
			else
				bw.write(String.format("%d: Bad brain\n", tc));			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
