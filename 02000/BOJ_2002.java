import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
      int tc = Integer.parseInt(br.readLine());
      HashMap<String, Integer> hm = new HashMap<String, Integer>();
      
      for (int i = 0; i < tc; i++) {
         hm.put(br.readLine(), i);
      }

      boolean[] chk = new boolean[tc];
      int cnt = 0;
      int cntTc = tc;
      
      while(cntTc > 0) {
         // 나타나지 않은것중 가장 작은 차량번호를 가져옴
         int min = 0;
         for(int j = 0; j < tc; j++) {
            if (!chk[j]) {
               min = j;
               break;
            }
         }
         
         while (true) {
            int tmp = hm.get(br.readLine());            
            cntTc--;
            chk[tmp] = true;
            if (tmp == min)               
               break;
            else
               cnt++;
         }         
      }      
      bw.write(cnt + "\n");      
      bw.flush();      
      bw.close();
      br.close();
   }   
}   
