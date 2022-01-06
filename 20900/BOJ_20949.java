import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Monitor implements Comparable<Monitor> {
    int idx, ppi;
    public Monitor(int idx, int w, int h) {
        this.idx = idx;
        ppi = w*w+h*h;
    }

    @Override
    public int compareTo(Monitor o) {
        if (this.ppi == o.ppi) return this.idx - o.idx;
        return o.ppi - this.ppi;
    }
}

public class Main {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Monitor[] arr = new Monitor[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Monitor(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(arr[i].idx).append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
