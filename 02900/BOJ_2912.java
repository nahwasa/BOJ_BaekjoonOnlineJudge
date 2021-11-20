import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class Picture implements Comparable<Picture> {
    int a, b, order;
    static int sqrtN;
    public Picture(int a, int b, int order) {
        this.a = a;
        this.b = b;
        this.order = order;
    }

    @Override
    public int compareTo(Picture o) {
        int a1 = this.a / sqrtN;
        int a2 = o.a / sqrtN;
        if (a1 == a2) return this.b - o.b;
        return a1-a2;
    }
}

public class Main extends FastInput {
    private int getHatNum(int[] cnt, Picture cur) {
        int target = (cur.b-cur.a+1)/2;
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] > target) return i;
        }
        return -1;
    }

    private void solution() throws Exception {
        int n = nextInt();
        Picture.sqrtN = (int) Math.sqrt(n);
        int c = nextInt();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = nextInt();

        int m = nextInt();
        int[] answer = new int[m];
        ArrayList<Picture> pic = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            pic.add(new Picture(nextInt(), nextInt(), i));
        }

        Collections.sort(pic);
        int[] cnt = new int[c+1];
        for (int i = pic.get(0).a; i <= pic.get(0).b; i++) {
            ++cnt[arr[i]];
        }
        answer[pic.get(0).order] = getHatNum(cnt, pic.get(0));

        for (int idx = 1; idx < pic.size(); idx++) {
            int curA = pic.get(idx).a;
            int curB = pic.get(idx).b;
            int befA = pic.get(idx-1).a;
            int befB = pic.get(idx-1).b;

            for (int i = befA; i < curA; i++) cnt[arr[i]]--;
            for (int i = curA; i < befA; i++) cnt[arr[i]]++;
            for (int i = befB+1; i <= curB; i++) cnt[arr[i]]++;
            for (int i = curB+1; i <= befB; i++) cnt[arr[i]]--;

            answer[pic.get(idx).order] = getHatNum(cnt, pic.get(idx));
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (answer[i] == -1) output.append('n').append('o');
            else output.append('y').append('e').append('s').append(' ').append(answer[i]);
            output.append('\n');
        }
        System.out.print(output);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    protected static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    protected static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        return ret;
    }

    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
