import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	static boolean[][] arr;
	static LinkedList<Integer> ll;
	static int size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		size = Integer.parseInt(br.readLine());
		arr = new boolean[size][size];
		ll = new LinkedList<Integer>();
		
		for (int i = 0; i < size; i++) {
			String s = br.readLine();
			for (int j = 0; j < size; j++) {
				arr[i][j] = s.charAt(j)=='1'?true:false;
			}
		}
				
		Stack<Position> s = new Stack<Position>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j]) {
					arr[i][j] = false;
					s.push(new Position(i, j));
					ll.add(searchAdjacentHouses(s));
				}					
			}
		}
		
		Collections.sort(ll);
		bw.write(ll.size() + "\n");
		Iterator<Integer> it = ll.iterator();
		
		while(it.hasNext())
			bw.write(it.next() + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}	
	
	private static int searchAdjacentHouses(Stack<Position> s) {
		int cnt = 1;		
		
		while (!s.isEmpty()) {
			Position pos = s.pop();
			int i = pos.getI();
			int j = pos.getJ();			
			
			if (i > 0 && arr[i-1][j]) {	// 왼
				cnt++;
				arr[i-1][j] = false;
				s.push(new Position(i-1, j));
			}
			
			if (j > 0 && arr[i][j-1]) {	// 위
				cnt++;
				arr[i][j-1] = false;
				s.push(new Position(i, j-1));
			}
			
			if (i < size-1 && arr[i+1][j]) {	// 우
				cnt++;
				arr[i+1][j] = false;
				s.push(new Position(i+1, j));
			}
			
			if (j < size-1 && arr[i][j+1]) {	// 아래
				cnt++;
				arr[i][j+1] = false;
				s.push(new Position(i, j+1));
			}			
		}
		
		return cnt;
	}
}

class Position {
	private int i;
	private int j;
	
	public Position(int i, int j) {
		this.i = i;
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
}
