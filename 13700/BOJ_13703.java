import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		if (K==0) {	//exception
			bw.write("0\n");
			bw.flush();
			return;
		}
		int L = 2*N+1;	// ex: N이 2일 경우 -2 -1 0 1 2 와 같이 5칸이 필요함
		long[][] arr = new long[L][2];	// [N][K]에 대해 K가 0이면 살아있는 경우에서 온 것, 1이면 죽은 경우에서 온 것.
		arr[N][0] = 1;
		for (int i = 0; i < N; i++) {
			long[][] tmp = new long[L][2];
			for (int k = 0; k < L; k++) {
				for (int z = 0; z < 2; z++) {	// 살아있는 물벼룩에서 진행된것, 죽은 물벼룩에서 진행된것을 따로 봐야함.
					if (arr[k][z]!=0) {
						tmp[k+1][z] += arr[k][z];					
						tmp[k-1][z] += arr[k][z];	
					}
				}
			}
			tmp[N+K][1] += tmp[N+K][0];	// 수면에 도달한건 죽은경우로 체크
			tmp[N+K][0] = 0;			
			arr = tmp;
		}		
		long sum = Long.parseLong(new BigInteger("2").pow(N).subtract(new BigInteger("1")).toString());	
		//전체 경우의 수. Math.pow는 double형이라 못믿겠음.
		//N이 63일 경우 Long형의 범위 +1의 값이 되므로 1을 빼서 parse하고 출력할 때 다시 1을 더해줬음.
		for (int i = 0; i < L; i++)
				sum -= arr[i][1];	// 죽은 물벼룩에서 진행된 경우를 빼줌.
		bw.write(sum + 1 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}	
}
