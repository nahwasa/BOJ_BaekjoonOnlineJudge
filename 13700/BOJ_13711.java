import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++)
			hm.put(Integer.parseInt(st.nextToken()), i);
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)	
			arr[i] = hm.get(Integer.parseInt(st.nextToken()));
		Vector<Integer> vec = new Vector<Integer>();	
		for (int i : arr)
			if (vec.isEmpty()) vec.add(i);
			else if (vec.lastElement() < i) vec.add(i);
			else vec.set(-Collections.binarySearch(vec, i)-1, i);
		bw.write((vec.size())+"\n");
		bw.flush();
		bw.close();
		br.close(); 
	}
}
