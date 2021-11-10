import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    class Candidate implements Comparable<Candidate> {
        int team, solve;
        public Candidate(int team, int solve) {
            this.team = team;
            this.solve = solve;
        }
        @Override
        public int compareTo(Candidate o) {
            return o.solve - this.solve;
        }
    }

    private static final String[] TEAM_NAME = {"PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY"};

    private void solution() throws Exception {
        int n = nextInt();
        ArrayList<Candidate> list = new ArrayList<>();
        for (int team = 0; team < 9; team++) {
            for (int i = 0; i < n; i++)
                list.add(new Candidate(team, nextInt()));
        }
        Collections.sort(list);
        System.out.println(TEAM_NAME[list.get(0).team]);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    private static void initFI() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
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
