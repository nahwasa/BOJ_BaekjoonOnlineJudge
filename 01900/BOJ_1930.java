import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] base = new int[4];
			for (int i = 0; i < 4; i++)
				base[i] = Integer.parseInt(st.nextToken());			
			int[] comp = new int[4];
			for (int i = 0; i < 4; i++)
				comp[i] = Integer.parseInt(st.nextToken());
			int[][] arr = new int[12][4];
			for (int i = 0; i < 4; i++) {	//make all case
				LinkedList<Integer> ll = new LinkedList<Integer>();
				switch (i) {
				case 0 :
					ll.add(comp[1]);
					ll.add(comp[2]);
					ll.add(comp[3]);
					break;
				case 1 :
					ll.add(comp[2]);
					ll.add(comp[0]);
					ll.add(comp[3]);
					break;
				case 2 :
					ll.add(comp[0]);
					ll.add(comp[1]);
					ll.add(comp[3]);
					break;
				case 3 :
					ll.add(comp[1]);
					ll.add(comp[0]);
					ll.add(comp[2]);
					break;
				}
				for (int k = 0; k < 3; k++) {
					arr[i*3+k][0] = comp[i];
					Iterator<Integer> it = ll.iterator();
					for (int z = 1; z <= 3; z++)
						arr[i*3+k][z] = it.next();
					ll.addFirst(ll.pollLast());	//rotate
				}
			}
			boolean result = false;
			for (int i = 0; i < 12; i++) {
				if (arr[i][0] != base[0])
					continue;
				if (arr[i][1]==base[1]&&arr[i][2]==base[2]&&arr[i][3]==base[3]) {
					result = true;
					break;
				}
			}
			bw.write(result?"1\n":"0\n");
		}
		bw.flush();
		bw.close();
		br.close();		
	}
}
