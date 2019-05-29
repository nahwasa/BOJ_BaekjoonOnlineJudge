import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		StringBuffer sb = new StringBuffer();
		List<Integer> num = new LinkedList<Integer>();
		
		for(int i = 0; i < n; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		
		for (int i = 1; i <= n; i++) {
			s.push(i);
			sb.append("+\n");
			
			while (!s.isEmpty() && !num.isEmpty() && s.peek().equals(num.get(0))) {
				s.pop();
				num.remove(0);
				sb.append("-\n");
			}			
		}
		
		if (s.isEmpty() && num.isEmpty())
			bw.write(sb.toString());
		else
			bw.write("NO\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
