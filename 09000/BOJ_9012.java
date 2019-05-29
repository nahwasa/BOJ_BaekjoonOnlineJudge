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
		
		for (int i = 0; i < n; i++) {
			bw.write(isVPS(br.readLine()) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}

	private static String isVPS(String str) {
		Stack<Object> stack = new Stack<Object>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == ')' && stack.isEmpty())
				return "NO";
			
			if (c == '(')
				stack.push(new Object());
			else if (c == ')')
				stack.pop();			
		}
		
		if (stack.isEmpty())
			return "YES";
		else
			return "NO";
	}	
}
