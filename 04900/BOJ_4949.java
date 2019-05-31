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
	
		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;
			
			bw.write(isBalanced(str) + "\n");
		}		
		
		bw.flush();		
		bw.close();
		br.close();
	}

	private static String isBalanced(String str) {
		Stack<Boolean> st = new Stack<Boolean>();
			// false : ()
			// true : []
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(' :
				st.push(false);
				break;
			case '[' :
				st.push(true);
				break;
			case ')' :
				if (st.isEmpty())
					return "no";
				if (st.pop())	// [가 들어있으면
					return "no";
				break;
			case ']' :
				if (st.isEmpty())
					return "no";
				if (!st.pop())
					return "no";
				break;
			}
		}
		
		if (!st.isEmpty())
			return "no";
		return "yes";
	}	
}	
