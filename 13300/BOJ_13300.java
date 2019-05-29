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
      
      int[][] stdCnt = new int[2][6];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int maxNum = Integer.parseInt(st.nextToken());
      
      for (int i = 0; i < n; i++) {
    	  st = new StringTokenizer(br.readLine());
    	  stdCnt[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken()) - 1]++;    	  
      }
      
      int roomCnt = 0;
      for (int i = 0; i < 2; i++) {
    	  for (int j = 0; j < 6; j++) {
    		  
    		  if (stdCnt[i][j] != 0) {
    			  roomCnt += (stdCnt[i][j] / maxNum);
    			  if (stdCnt[i][j] % maxNum != 0)
    				  roomCnt++;
    		  }
    		  
    	  }
      }
      
      bw.write(roomCnt + "\n");
      
      bw.flush();
      br.close();
      bw.close();      
   }
}
