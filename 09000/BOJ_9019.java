import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int proc(int from, int type) {
        int tmp = 0;
        switch (type) {
            case 0 :    return (from*2) % 10000;
            case 1 :    return from==0?9999:from-1;
            case 2 :    return (from % 1000) * 10 + (from / 1000);
            case 3 :    return (from / 10) + (from % 10) * 1000;
        }
        return -1;
    }

    private static String traceBack(int[] v, int num) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(num);
        while (v[num] != -1) {
            num = v[num];
            ll.addFirst(num);
        }
        int before = ll.pollFirst();
        StringBuilder sb = new StringBuilder();
        for (Integer tmp : ll) {
            int i = 0;
            for (; i < 4; i++) if (proc(before, i) == tmp) break;
            switch (i) {
                case 0 : sb.append('D'); break;
                case 1 : sb.append('S'); break;
                case 2 : sb.append('L'); break;
                case 3 : sb.append('R'); break;
            }
            before = tmp;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            LinkedList<Integer> ll = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int[] v = new int[10000];
            Arrays.fill(v, 10000);
            Queue<Integer> q = new LinkedList<>();
            q.add(from);
            v[from] = -1;
            while (!q.isEmpty()) {
                int tmp = q.poll();
                if (tmp == to) {
                    bw.write(traceBack(v, tmp));
                    bw.newLine();
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nextNum = proc(tmp, i);
                    if (v[nextNum] != 10000) continue;
                    v[nextNum] = tmp;
                    q.add(nextNum);
                }
            }
        }
        bw.flush();
    }
}
