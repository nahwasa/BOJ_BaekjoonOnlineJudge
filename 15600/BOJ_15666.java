import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // input buffer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> ts = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        while (n-->0)   ts.add(Integer.parseInt(st.nextToken()));
        arr = new int[ts.size()];
        for (int i = 0; i < arr.length; i++)    arr[i] = ts.pollFirst();
        solve(new LinkedList<Integer>() {
            @Override
            public String toString() {
                Iterator<Integer> it = this.iterator();
                StringBuilder sb = new StringBuilder();
                while (it.hasNext())
                    sb.append(it.next()).append(' ');
                return sb.toString();
            }
        });
    }

    private static void solve(LinkedList<Integer> res) {
        if (res.size() == m) {
            System.out.println(res);
            return;
        }
        int last = res.isEmpty() ? 0 : res.peekLast();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < last)  continue;
            res.add(arr[i]);
            solve(res);
            res.pollLast();
        }
    }
}
