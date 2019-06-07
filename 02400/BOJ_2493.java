import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Top> stk = new Stack<Top>();
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			while (!stk.isEmpty() && stk.peek().height <= h)
				stk.pop();
			bw.write((stk.isEmpty()?"0":stk.peek().idx)+(i==N-1?"\n":" "));
			stk.push(new Top(h, i+1));
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}

class Top {
	int height;
	int idx;
	
	public Top(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}
}
