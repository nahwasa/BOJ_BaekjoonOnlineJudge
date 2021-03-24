import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// input & init
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] cnt = new int[1000001];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]]++;
		}
		Stack<Node> stack = new Stack<>();
		
		// proc
		int[] res = new int[n];
		for (int i = n-1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek().cnt <= cnt[arr[i]])
				stack.pop();
			int nfg = -1;
			if (!stack.isEmpty())
				nfg = stack.peek().num;
			res[i] = nfg;
			stack.add(new Node(arr[i], cnt[arr[i]]));
		}
		
		// output
		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}

class Node {
	int num;
	int cnt;
	public Node(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}
