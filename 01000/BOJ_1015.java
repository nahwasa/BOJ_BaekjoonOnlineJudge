import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Num[] arr = new Num[N];
		Num[] orderArr = new Num[N];
		for (int i = 0; i < N; i++) {
			orderArr[i] = arr[i] = new Num(Integer.parseInt(st.nextToken()), 0);
			
		}
		Arrays.sort(orderArr);
		for (int i = 0; i < N; i++)
			orderArr[i].order = i;
		for (Num tmp : arr) {
			bw.write(tmp.order + " ");
		}
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}	
}

class Num implements Comparable<Num> {
	int num;
	int order;
	public Num(int num, int order) {
		super();
		this.num = num;
		this.order = order;
	}
	@Override
	public int compareTo(Num o) {		
		return this.num - o.num;
	}	
}
