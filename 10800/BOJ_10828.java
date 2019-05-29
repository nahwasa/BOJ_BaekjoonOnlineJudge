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
	
		Stack<Integer> stack = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());		
		for (int i = 0; i < n; i++) {
			String in = br.readLine();
			
			if (in.startsWith("push")) {
				in = in.substring(5);
				stack.push(Integer.parseInt(in));
			} else if (in.startsWith("pop")) {
				if (stack.isEmpty())
					bw.write("-1\n");
				else 
					bw.write(stack.pop() + "\n");
			} else if (in.startsWith("size")) {
				bw.write(stack.size() + "\n");
			} else if (in.startsWith("empty")) {
				if (stack.isEmpty())
					bw.write("1\n");
				else 
					bw.write("0\n");
			} else if (in.startsWith("top")) {
				if (stack.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stack.peek() + "\n");
			}
				
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
