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
      
      Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int dst = Integer.parseInt(br.readLine());
      
      int cnt = 0;
      
      while(st.hasMoreTokens())
    	  if (Integer.parseInt(st.nextToken()) == dst)
    		  cnt++;
      
      bw.write(cnt + "\n");
      
      bw.flush();
      br.close();
      bw.close();      
   }
}
