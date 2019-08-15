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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[3];
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());
		if (arr[0]+arr[1]+arr[2] >= 100)
			bw.write("OK\n");
		else {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				if (arr[i]<min) {
					min=arr[i];
					idx=i;
				}
			}
			
			if(idx == 0) bw.write("Soongsil\n");
			else if(idx == 1) bw.write("Korea\n");
			else bw.write("Hanyang\n");
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}
