import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int a, b, c;
        public Node(int a, int b, int c) { this.a = a; this.b = b; this.c = c; }
    }

    private static StringTokenizer st;

    private static int nextInt() {
        if (!st.hasMoreTokens())    while(true) {}
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Node[] arr = new Node[n];
  
        while (n-- > 0) {
            String tmp = br.readLine();
            if (tmp == null) break;
            st = new StringTokenizer(tmp);
            arr[n] = new Node(nextInt(), nextInt(), nextInt());
        }
        

        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.a != n2.a)   return n1.a - n2.a;
                if (n1.b != n2.b)   return n1.b - n2.b;
                return n1.c - n2.c;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Node node : arr)   sb.append(node.a).append(' ').append(node.b).append(' ').append(node.c).append(' ').append('\n');
        System.out.println(sb);
    }
}
