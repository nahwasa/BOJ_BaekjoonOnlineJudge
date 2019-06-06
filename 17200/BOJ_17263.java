import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			int tmp = sc.nextInt();
			if (tmp > max)
				max = tmp;
		}
		
//		for(int i = 0; i < N; i++) {
//			int tmp = Integer.parseInt(st.nextToken());
//			if (tmp > max)
//				max = tmp;
//		}

		bw.write(max + "\n");
		
		bw.flush();		
		bw.close();
		br.close();
	}
}
