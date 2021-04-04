import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Grade[] arr = new Grade[21];
        for (int i = 0; i < 21; i++)    arr[i] = new Grade();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = br.readLine().length();
            arr[cnt].proc(i-k);
            res += arr[cnt].size();
            arr[cnt].add(i);
        }
        System.out.println(res);
    }
}
class Grade {
    LinkedList<Integer> arr;
    public Grade() { arr = new LinkedList<>(); }
    public void add(int n) { arr.addLast(n); }
    public void proc(int lim) { while (!arr.isEmpty() && arr.peekFirst() < lim) arr.removeFirst(); }
    public int size() { return arr.size(); }
}
