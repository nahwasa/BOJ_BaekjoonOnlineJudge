import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      List<Integer> l = new LinkedList<Integer>();
      
      for (int i = 1; i <= n; i++) {
    	  l.add(i);
      }
      
      bw.write("<");
      int cnt = 0, i = 0;
      while (!l.isEmpty()) {
    	  cnt++;
    	  if (cnt % k == 0) {
    		  bw.write(l.remove(i--) + "");
    		  cnt = 0;
    		  
    		  if (!l.isEmpty())
    			  bw.write(", ");
    	  }

    	  i++;
    	  if (i == l.size())
    		  i = 0;
      }
      bw.write(">");
      
      bw.flush();
      br.close();
      bw.close();      
   }
}
