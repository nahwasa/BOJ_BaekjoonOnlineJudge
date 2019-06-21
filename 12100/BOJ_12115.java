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
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[][] arr = new int[N][M];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
         }
      }
      int Q = Integer.parseInt(br.readLine());
      while (Q-->0) {
         st = new StringTokenizer(br.readLine());
         int[] tmp = new int[M];         
         for (int i = 0; i < M; i++)
        	 tmp[i] = Integer.parseInt(st.nextToken());
         int cnt = 0;
         for (int[] row : arr)
        	 for (int i = 0; i < M; i++) {
        		 if (tmp[i]==-1?false:row[i]!=tmp[i]) break;
        		 if (i == M-1) cnt++;	//break되지 않고, M-1번까지 왔다면 전부 만족한것이므로 cnt증가
        	 }        	
         bw.write(String.valueOf(cnt));
         bw.newLine();
      }      
      bw.flush();
      br.close();
      bw.close();      
   }   
}
