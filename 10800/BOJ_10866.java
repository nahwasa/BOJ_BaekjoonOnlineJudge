import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int PUSH_FRONT	= 1;
	private static final int PUSH_BACK 	= 2;
	private static final int POP_FRONT 	= 3;
	private static final int POP_BACK	= 4;
	private static final int SIZE	= 5;
	private static final int EMPTY 	= 6;
	private static final int FRONT	= 7;
	private static final int BACK 	= 8;
	private static boolean onlyPushCheck = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> dq = new LinkedList<Integer>();
		int n = Integer.parseInt(br.readLine());	// # of TC.

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			
			switch(getOrder(st.nextToken())) {
			case PUSH_FRONT :
				dq.addFirst(Integer.parseInt(st.nextToken()));	
				break;
			case PUSH_BACK :
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case POP_FRONT :
				if (!dq.isEmpty())
					bw.write(dq.pollFirst() + "\n");
				else
					bw.write("-1\n");
				break;
			case POP_BACK :
				if (!dq.isEmpty())
					bw.write(dq.pollLast() + "\n");
				else
					bw.write("-1\n");
				break;
			case SIZE :
				bw.write(dq.size() + "\n");				
				break;
			case EMPTY :
				if (dq.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case FRONT :
				if (!dq.isEmpty())
					bw.write(dq.peekFirst() + "\n");
				else
					bw.write("-1\n");
				break;
			case BACK :
				if (!dq.isEmpty())
					bw.write(dq.peekLast() + "\n");
				else
					bw.write("-1\n");
				break;
			default :
				// TEST CASE ERROR
			}				
		}
		
		if (onlyPushCheck)
			bw.write("\n");
		
		bw.flush();
		br.close();
		bw.close();
	}

	private static int getOrder(String s) {
		if (!s.equals("push_front") && !!s.equals("push_back"))
			onlyPushCheck = false;
		
		if (s.equals("push_front"))
			return PUSH_FRONT;
		if (s.equals("push_back"))
			return PUSH_BACK;
		if (s.equals("pop_front"))
			return POP_FRONT;
		if (s.equals("pop_back"))
			return POP_BACK;		
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
