import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        while (n-->0) {
            int[] arr = new int[26];
            String cur = br.readLine();
            for (int i = 0; i < cur.length(); i++)
                arr[cur.charAt(i)-'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]);
            hs.add(sb.toString());
        }
        System.out.println(hs.size());
    }
}
