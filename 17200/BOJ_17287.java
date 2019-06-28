import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int[] score = new int[100];
		Stack<Integer> stk = new Stack<Integer>();
		LinkedList<Integer> ll;
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case '[' :
				stk.push(-3);
				break;
			case '{' :
				stk.push(-2);
				break;
			case '(' :
				stk.push(-1);
				break;
			case ']' :
				ll = new LinkedList<Integer>();
				while (true) {
					int tmp = stk.pop();					
					if (tmp == -3)
						break;
					else
						ll.add(tmp);									
				}
				for (int tt : ll) {
					score[tt] += 3;
					stk.push(tt);
				}
				break;
			case '}' :
				ll = new LinkedList<Integer>();
				while (true) {
					int tmp = stk.pop();					
					if (tmp == -2)
						break;
					else
						ll.add(tmp);									
				}
				for (int tt : ll) {
					score[tt] += 2;
					stk.push(tt);
				}		
				break;
			case ')' :
				ll = new LinkedList<Integer>();
				while (true) {
					int tmp = stk.pop();					
					if (tmp == -1)
						break;
					else
						ll.add(tmp);									
				}
				for (int tt : ll) {
					score[tt] += 1;
					stk.push(tt);
				}		
				break;
			default :
				stk.push(idx++);
			}
		}
		int max = 0;		
		for (int scr : score) {			
			if (scr > max)
				max = scr;
		}		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
