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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Stack<Sum> stk = new Stack<Sum>();
		for (int i = 0; i < N; i++)
			stk.push(new Sum(i, arr[i]));
		while (!stk.isEmpty()) {
			Sum s = stk.pop();
			int idx = s.pos;
			int sum = s.sum;
			if (sum == S)
				cnt++;
			for (int i = idx+1; i < N; i++)
				stk.push(new Sum(i, arr[i] + sum));
		}		
		bw.write(cnt+"\n");
		bw.flush();
		br.close();
		bw.close();		
	}
}

class Sum {
	int pos;
	int sum;
	public Sum(int pos, int sum) {
		super();
		this.pos = pos;
		this.sum = sum;
	}
}
