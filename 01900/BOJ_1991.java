import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Node[] arr = new Node[26];
		for (int i = 0; i < 26; i++)
			arr[i] = new Node((char)('A'+i));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx1 = st.nextToken().charAt(0)-'A';
			int idx2 = st.nextToken().charAt(0)-'A';
			int idx3 = st.nextToken().charAt(0)-'A';
			if (idx2 != '.'-'A')
				arr[idx1].l = arr[idx2];
			if (idx3 != '.'-'A')
				arr[idx1].r = arr[idx3];
		}
		preorder(arr[0]);
		System.out.println();
		inorder(arr[0]);
		System.out.println();
		postorder(arr[0]);
		System.out.println();
		bw.flush();
		bw.close();
		br.close();
	}

	private static void preorder(Node node) {
		if (node!=null)
			System.out.print(node.c);
		if (node.l!=null)
			preorder(node.l);
		if (node.r!=null)
			preorder(node.r);
	}
	
	private static void inorder(Node node) {		
		if (node.l!=null)
			inorder(node.l);
		if (node!=null)
			System.out.print(node.c);
		if (node.r!=null)
			inorder(node.r);
	}
	
	private static void postorder(Node node) {		
		if (node.l!=null)
			postorder(node.l);
		if (node.r!=null)
			postorder(node.r);
		if (node!=null)
			System.out.print(node.c);
	}
}

class Node {
	Node l,r;
	char c;
	public Node(Node l, Node r, char c) {
		this.l = l;
		this.r = r;
		this.c = c;
	}	
	public Node(char c) {
		this.l = null;
		this.r = null;
		this.c = c;
	}	
}
