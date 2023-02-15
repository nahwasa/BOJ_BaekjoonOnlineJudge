import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int[] hear;
    int sum = 0;

    public Node(int m, String str) {
        StringTokenizer st = new StringTokenizer(str);
        hear = new int[m];
        for (int i = 0; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());
            sum += cur;
            hear[i] = cur;
        }
    }

    @Override
    public int compareTo(Node o) {
        return o.sum - this.sum;
    }
}

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(m, br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int bf = arr[0].hear[i];
            for (int j = 1; j < n; j++) {
                if (bf == 0 && arr[j].hear[i] == 1) {
                    System.out.println("NO");
                    return;
                }
                bf = arr[j].hear[i];
            }
        }
        System.out.println("YES");
    }
}
