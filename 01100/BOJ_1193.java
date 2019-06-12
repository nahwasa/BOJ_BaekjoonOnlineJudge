import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0, sum = 0; sum <= 10000000; i++) {
			sum += i;			
			if (sum < N && N <= sum + (i+1)) {
				int tmp = N - sum;
				i++;	// 계산하기 편하게. 어차피 break할꺼라 막써도됨.
				bw.write((i%2==0?tmp:i-tmp+1) + "/" + (i%2!=0?tmp:i-tmp+1) + "\n");
				break;
			}
		}	
		bw.flush();
		br.close();
		bw.close();		
	}
}
