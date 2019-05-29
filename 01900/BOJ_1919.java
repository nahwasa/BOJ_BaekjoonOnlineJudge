import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           
      String s1 = br.readLine();
      String s2 = br.readLine();
      
      int[] cntS1 = new int['z'-'a'+1];
      int[] cntS2 = new int['z'-'a'+1];
      
      for (int i = 0; i < s1.length(); i++) {
    	  cntS1[s1.charAt(i) - 'a']++;
      }
      
      for (int i = 0; i < s2.length(); i++) {
    	  cntS2[s2.charAt(i) - 'a']++;
      }
      
      int cnt = 0;
      for (int i = 0; i < cntS1.length; i++) {
    	  cnt += ( cntS1[i]>=cntS2[i] ? cntS1[i]-cntS2[i] : cntS2[i]-cntS1[i] );
      }
      
      bw.write(cnt + "\n");
      bw.flush();
      br.close();
      bw.close();      
   }
}
