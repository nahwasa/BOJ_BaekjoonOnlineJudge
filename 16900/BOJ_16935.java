import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    int[][] arr;
    int op;

    public void solution() throws Exception {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (op-->0) {
            Operation op = null;
            switch (Integer.parseInt(st.nextToken())) {
                case 1: op = new Op1(); break;
                case 2: op = new Op2(); break;
                case 3: op = new Op3(); break;
                case 4: op = new Op4(); break;
                case 5: op = new Op5(); break;
                case 6: op = new Op6(); break;
            }

            arr = op.proc(arr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        op = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

abstract class Operation {
    int[][] base;
    int r, c;

    protected void commit(int[][] arr) {
        this.base = arr;
    }

    public int[][] proc(int[][] arr) {
        this.base = arr;
        this.r = arr.length;
        this.c = arr[0].length;

        procEachOp();

        return this.base;
    }

    abstract protected void procEachOp();
}

class Op1 extends Operation {
    @Override
    protected void procEachOp() {
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[r-1-i][j] = base[i][j];
            }
        }
        commit(arr);
    }
}

class Op2 extends Operation {
    @Override
    protected void procEachOp() {
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][c-1-j] = base[i][j];
            }
        }
        commit(arr);
    }
}

class Op3 extends Operation {
    @Override
    protected void procEachOp() {
        int[][] arr = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[j][r-1-i] = base[i][j];
            }
        }
        commit(arr);
    }
}

class Op4 extends Operation {
    @Override
    protected void procEachOp() {
        int[][] arr = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[c-1-j][i] = base[i][j];
            }
        }
        commit(arr);
    }
}

class Op5 extends Operation {
    @Override
    protected void procEachOp() {
        int[][] arr = new int[r][c];
        for (int i = 0; i < r/2; i++) for (int j = 0; j < c/2; j++) arr[i][c/2+j] = base[i][j];
        for (int i = 0; i < r/2; i++) for (int j = c/2; j < c; j++) arr[r/2+i][j] = base[i][j];
        for (int i = r/2; i < r; i++) for (int j = c/2; j < c; j++) arr[i][j-c/2] = base[i][j];
        for (int i = r/2; i < r; i++) for (int j = 0; j < c/2; j++) arr[i-r/2][j] = base[i][j];

        commit(arr);
    }
}

class Op6 extends Operation {
    @Override
    protected void procEachOp() {
        int[][] arr = new int[r][c];
        for (int i = 0; i < r/2; i++) for (int j = 0; j < c/2; j++) arr[r/2+i][j] = base[i][j];
        for (int i = 0; i < r/2; i++) for (int j = c/2; j < c; j++) arr[i][j-c/2] = base[i][j];
        for (int i = r/2; i < r; i++) for (int j = c/2; j < c; j++) arr[i-r/2][j] = base[i][j];
        for (int i = r/2; i < r; i++) for (int j = 0; j < c/2; j++) arr[i][j+c/2] = base[i][j];

        commit(arr);
    }
}
