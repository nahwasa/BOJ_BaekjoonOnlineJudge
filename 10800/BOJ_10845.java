import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int PUSH	= 1;
	private static final int POP 	= 2;
	private static final int SIZE 	= 3;
	private static final int EMPTY	= 4;
	private static final int FRONT	= 5;
	private static final int BACK 	= 6;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> q = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());	// # of TC.
		int back = 0;	// last integer tmp.
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			
			switch(getOrder(st.nextToken())) {
			case PUSH :
				int tmp = Integer.parseInt(st.nextToken());
				q.offer(tmp);
				back = tmp;				
				break;
			case POP :
				if (!q.isEmpty())
					bw.write(q.poll() + "\n");
				else
					bw.write("-1\n");
				break;
			case SIZE :
				bw.write(q.size() + "\n");				
				break;
			case EMPTY :
				if (q.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case FRONT :
				if (!q.isEmpty())
					bw.write(q.peek() + "\n");
				else
					bw.write("-1\n");
				break;
			case BACK :
				if (!q.isEmpty())
					bw.write(back + "\n");
				else
					bw.write("-1\n");
				break;
			default :
				// TEST CASE ERROR
			}				
		}		
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static int getOrder(String s) {
		if (s.equals("push"))
			return PUSH;
		if (s.equals("pop"))
			return POP;
		if (s.equals("size"))
			return SIZE;
		if (s.equals("empty"))
			return EMPTY;
		if (s.equals("front"))
			return FRONT;
		if (s.equals("back"))
			return BACK;
		
		return -1;
	}
}
