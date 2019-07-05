import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Vector<Integer> v = new Vector<Integer>();
		v.add(0);
		for (int num : arr) {
			if (v.lastElement() < num) {v.add(num); continue;}
			int tmp = Collections.binarySearch(v, num);			
			if (tmp >= 0) v.set(tmp, num);
			else v.set(-tmp-1, num);				
		}
		bw.write((v.size()-1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
