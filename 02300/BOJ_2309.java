import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] height = new int[9];
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < 8; i++) {
			int j = i + 1;
			
			for (; j < 9; j++) {
				int sum = 0;
				for (int k = 0; k < 9; k++) {
					if (k != i && k != j) {
						sum += height[k];						
					}					
				}
				
				if (sum == 100) {
					List<Integer> arr = new LinkedList<Integer>();
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j)
							arr.add(height[k]);
					}
					Collections.sort(arr);
					Iterator<Integer> it = arr.iterator();
					while (it.hasNext())
						bw.write(it.next() + "\n");
					
					bw.flush();
					br.close();
					bw.close();
					return;
				}
			}			
		}		
	}	
}
