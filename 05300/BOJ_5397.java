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
    	  bw.write(getPassword(br.readLine()) + "\n");
      }     
      
      bw.flush();
      br.close();
      bw.close();      
   }

	private static String getPassword(String s) {
		Stack<Character> l = new Stack<Character>();
		Stack<Character> r = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '<' :
				if (!l.isEmpty())
					r.push(l.pop());
				break;
			case '>' :
				if (!r.isEmpty())
					l.push(r.pop());
				break;
			case '-' :
				if (!l.isEmpty())
					l.pop();
				break;
			default :
				l.push(s.charAt(i));
			}
		}
		
		while(!l.isEmpty())
			r.push(l.pop());
		
		StringBuffer sb = new StringBuffer();
		
		while(!r.isEmpty())
			sb.append(r.pop());
		return sb.toString();
	}
}
