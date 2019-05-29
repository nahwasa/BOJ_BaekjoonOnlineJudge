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
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		long maxCompareNum = (long)Math.sqrt(max);
		
		boolean[] arr = new boolean[(int) (max-min+1)];	// max와 min의 차이가 최대 100만이므로 int로 해도 됨
		
		for (long i = 2; i <= maxCompareNum; i++) {			
			long pow = i * i;
			long t = (min / pow);
			
			while (true) {				
				if (pow * t > max)
					break;
				
				if (pow * t >= min) {
					arr[(int) (pow * t - min)] = true;
				}
				t++;
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i])
				cnt++;
		}
		bw.write(cnt + "\n");
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
