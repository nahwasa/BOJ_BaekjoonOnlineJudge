import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		if (n == 64) {
			bw.write("1\n");
			bw.flush();
			br.close();
			bw.close();	
			return;
		}
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(64);
		
		while (true) {
			int tmp = s.pop();
			if (( getSum(s) + tmp / 2 ) >= n) {
				s.push(tmp / 2);
			} else {
				s.push(tmp / 2);
				s.push(tmp / 2);
			}
			
			if (( getSum(s) == n)) {
				bw.write(s.size() + "\n");
				break;
			}
		}
		
		bw.flush();
		br.close();
		bw.close();		
	}
	
	private static int getSum(Stack<Integer> s) {
		Iterator<Integer> it = s.iterator();
		int sum = 0;
		while (it.hasNext()) {
			sum += it.next();
		}
		return sum;
	}
}
