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
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[N][N];
		int[][][] calc = new int[N][N][2];	//~[0] : max, ~[1] : min
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = arr[i][j] = st.nextToken().charAt(0);
			}
		}
		calc[0][0][0] = calc[0][0][1] = arr[0][0] - '0';
		
		for (int i = 0; i < N; i++) {
			for (int j = i%2==0?0:1; j < N; j+=2) {
				if (i==0 && j==0) continue;
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;				
				if (i-2>=0) {
					int r1 = calc(calc[i-2][j][0], arr[i-1][j], arr[i][j]);
					int r2 = calc(calc[i-2][j][1], arr[i-1][j], arr[i][j]);
					max=r1>max?r1:max;
					min=r2<min?r2:min; }
				if (j-2>=0) {
					int r1 = calc(calc[i][j-2][0], arr[i][j-1], arr[i][j]);
					int r2 = calc(calc[i][j-2][1], arr[i][j-1], arr[i][j]);					
					max=r1>max?r1:max; 
					min=r2<min?r2:min; }
				if (i-1>=0&&j-1>=0) {
					int r11 = calc(calc[i-1][j-1][0], arr[i-1][j], arr[i][j]);
					int r21 = calc(calc[i-1][j-1][1], arr[i-1][j], arr[i][j]);
					int r12 = calc(calc[i-1][j-1][0], arr[i][j-1], arr[i][j]);
					int r22 = calc(calc[i-1][j-1][1], arr[i][j-1], arr[i][j]);
					max=r11>max?(r12>r11?r12:r11):(r12>max?r12:max); 
					min=r21<min?(r22<r21?r22:r21):(r22<min?r22:min); }
				calc[i][j][0] = max;
				calc[i][j][1] = min;
			}
		}	
		
		bw.write(String.format("%d %d\n", calc[N-1][N-1][0], calc[N-1][N-1][1]));
		
		bw.flush();		
		bw.close();
		br.close();
	}	
	
	private static int calc(int a, char op, char bC) {
		int b = bC - '0';
		switch (op) {
		case '+' : return a+b;
		case '-' : return a-b;
		default :  return a*b;
		}
	}
}
