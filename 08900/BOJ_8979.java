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

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Nation[] arr = new Nation[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Nation(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())
					);
		}
			
		Arrays.sort(arr);

		int tmp = 1;
		Nation nTmp = new Nation(arr[0].me1, arr[0].me2, arr[0].me3);
		for(int i = 1; i <= n; i++) {
			if (arr[i-1].compareTo(nTmp) != 0)
				tmp = i;
						
			if (arr[i-1].num == k) {
				bw.write(tmp + "\n");
				break;
			}
			
			nTmp = new Nation(arr[i-1].me1, arr[i-1].me2, arr[i-1].me3);
		}
		
		bw.flush();		
		bw.close();
		br.close();
	}
}

class Nation implements Comparable<Nation>{
	int num;
	int me1;
	int me2;
	int me3;
	
	public Nation(int num, int me1, int me2, int me3) {
		this.num = num;
		this.me1 = me1;
		this.me2 = me2;
		this.me3 = me3;
	}
	
	public Nation(int me1, int me2, int me3) {
		num = -1;
		this.me1 = me1;
		this.me2 = me2;
		this.me3 = me3;
	}

	@Override
	public int compareTo(Nation o) {
		if (this.me1 != o.me1)
			return -(this.me1-o.me1);
		if (this.me2 != o.me2)
			return -(this.me2-o.me2);
		if (this.me3 != o.me3)
			return -(this.me3-o.me3);		
		return 0;
	}
	
	
}
