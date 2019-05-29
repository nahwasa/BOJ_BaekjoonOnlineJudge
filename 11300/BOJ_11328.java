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
           
      int n = Integer.parseInt(br.readLine());
      
      for (int i = 0; i < n; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         StringBuffer firstStr = new StringBuffer(st.nextToken());
         StringBuffer secondStr = new StringBuffer(st.nextToken());

         if (firstStr.length() != secondStr.length()) {
            bw.write("Impossible\n");
            continue;
         }
         
         for (int j = 0; j < firstStr.length(); j++) {
            int idx = secondStr.indexOf( firstStr.charAt(j) + "" );
            if (idx == -1)   // not found
               break;
            
            secondStr.deleteCharAt(idx);
         }
         
         if (secondStr.length() != 0)
            bw.write("Impossible\n");
         else
            bw.write("Possible\n");
      }     
       
      bw.flush();
      br.close();
      bw.close();      
   }
}
