import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static void nst() throws Exception { st = new StringTokenizer(br.readLine()); }
    static int ni() { return Integer.parseInt(st.nextToken()); }
    public static void main(String[] args) throws Exception {
        nst();
        int n=ni(), l=ni(), h=ni();
        int[] arr = new int[n];
        nst();
        while (n-->0) arr[n] = ni();
        Arrays.sort(arr); n++;
        for (int i = l; i < arr.length-h; i++) n+=arr[i];
        System.out.println(String.format("%.10f", 1d*n/(arr.length-l-h)));
    }
}
