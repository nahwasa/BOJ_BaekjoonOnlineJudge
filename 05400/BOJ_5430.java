import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String order = br.readLine();
			int numOfNumber = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
			
			bw.write(getResult(order, numOfNumber, st) + "\n");			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	private static String getResult(String order, int numOfNumber, StringTokenizer st) {
		int[] n = new int[numOfNumber];
		int start = 0;
		int last = numOfNumber - 1;
		boolean direction = true;	// T:->, F:<-
		
		for (int i = 0; i < numOfNumber; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * order 수행
		 */
		for (int i = 0; i < order.length(); i++) {
			switch(order.charAt(i)) {
			case 'R' :
				direction = !direction;
				break;
			case 'D' :
				if (numOfNumber == 0)
					return "error";
				
				numOfNumber--;
				if (direction)
					start++;
				else
					last--;
			}
		}
		
		
		/*
		 * Arr to String
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if (direction) {
			for (int i = start; i <= last; i++) {
				sb.append(n[i]);
				if (i != last)
					sb.append(",");
			}
		} else {
			for (int i = last; i >= start; i--) {
				sb.append(n[i]);
				if (i != start)
					sb.append(",");
			}
		}
		
		sb.append("]");
		return sb.toString();
	}	
}
