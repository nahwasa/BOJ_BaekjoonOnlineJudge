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
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Num> stk = new Stack<Num>();
		stk.push(new Num(Integer.parseInt(st.nextToken())));
		for (int i = 1; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			while (!stk.isEmpty() && stk.peek().num < tmp)
				arr[stk.pop().idx] = tmp;
			stk.push(new Num(tmp));
		}
		while (!stk.isEmpty())
			arr[stk.pop().idx] = -1;
		for (int i : arr)
			bw.write(i + " ");
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();
	}
}

class Num {
	static int cnt = 0;
	int idx, num;
	public Num(int num) {
		super();		
		this.num = num;
		this.idx = cnt++;
	}	
}
