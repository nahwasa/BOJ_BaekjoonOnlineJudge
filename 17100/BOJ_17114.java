import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main extends FastInput {
    private void solution() throws Exception {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();
        int e = nextInt();
        int f = nextInt();
        int g = nextInt();
        int h = nextInt();
        int i = nextInt();
        int j = nextInt();
        int k = nextInt();
        int[][][][][][][][][][][] arr = new int[a][b][c][d][e][f][g][h][i][j][k];
        boolean[][][][][][][][][][][] v = new boolean[a][b][c][d][e][f][g][h][i][j][k];
        Queue<int[]> q = new ArrayDeque<>();
        int remain = 0;
        for (int kt = 0; kt < k; kt++) {
            for (int jt = 0; jt < j; jt++) {
                for (int it = 0; it < i; it++) {
                    for (int ht = 0; ht < h; ht++) {
                        for (int gt = 0; gt < g; gt++) {
                            for (int ft = 0; ft < f; ft++) {
                                for (int et = 0; et < e; et++) {
                                    for (int dt = 0; dt < d; dt++) {
                                        for (int ct = 0; ct < c; ct++) {
                                            for (int bt = 0; bt < b; bt++) {
                                                for (int at = 0; at < a; at++) {
                                                    int cur = nextInt();
                                                    if (cur == 1) {
                                                        q.add(new int[]{0, at, bt, ct, dt, et, ft, gt, ht, it, jt, kt});
                                                        v[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt] = true;
                                                    } else if (cur == 0) {
                                                        remain++;
                                                    }
                                                    arr[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt] = cur;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (remain == 0) {
            System.out.println(0);
            return;
        }

        int ans = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dist = cur[0];
            int at = cur[1];
            int bt = cur[2];
            int ct = cur[3];
            int dt = cur[4];
            int et = cur[5];
            int ft = cur[6];
            int gt = cur[7];
            int ht = cur[8];
            int it = cur[9];
            int jt = cur[10];
            int kt = cur[11];

            if (at-1>=0 && !v[at-1][bt][ct][dt][et][ft][gt][ht][it][jt][kt] && arr[at-1][bt][ct][dt][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at-1][bt][ct][dt][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at-1,bt,ct,dt,et,ft,gt,ht,it,jt,kt});
            }
            if (at+1<a && !v[at+1][bt][ct][dt][et][ft][gt][ht][it][jt][kt] && arr[at+1][bt][ct][dt][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at+1][bt][ct][dt][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at+1,bt,ct,dt,et,ft,gt,ht,it,jt,kt});
            }

            if (bt-1>=0 && !v[at][bt-1][ct][dt][et][ft][gt][ht][it][jt][kt] && arr[at][bt-1][ct][dt][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt-1][ct][dt][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt-1,ct,dt,et,ft,gt,ht,it,jt,kt});
            }
            if (bt+1<b && !v[at][bt+1][ct][dt][et][ft][gt][ht][it][jt][kt] && arr[at][bt+1][ct][dt][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt+1][ct][dt][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt+1,ct,dt,et,ft,gt,ht,it,jt,kt});
            }

            if (ct-1>=0 && !v[at][bt][ct-1][dt][et][ft][gt][ht][it][jt][kt] && arr[at][bt][ct-1][dt][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct-1][dt][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct-1,dt,et,ft,gt,ht,it,jt,kt});
            }
            if (ct+1<c && !v[at][bt][ct+1][dt][et][ft][gt][ht][it][jt][kt] && arr[at][bt][ct+1][dt][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct+1][dt][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct+1,dt,et,ft,gt,ht,it,jt,kt});
            }

            if (dt-1>=0 && !v[at][bt][ct][dt-1][et][ft][gt][ht][it][jt][kt] && arr[at][bt][ct][dt-1][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt-1][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt-1,et,ft,gt,ht,it,jt,kt});
            }
            if (dt+1<d && !v[at][bt][ct][dt+1][et][ft][gt][ht][it][jt][kt] && arr[at][bt][ct][dt+1][et][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt+1][et][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt+1,et,ft,gt,ht,it,jt,kt});
            }

            if (et-1>=0 && !v[at][bt][ct][dt][et-1][ft][gt][ht][it][jt][kt] && arr[at][bt][ct][dt][et-1][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et-1][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et-1,ft,gt,ht,it,jt,kt});
            }
            if (et+1<e && !v[at][bt][ct][dt][et+1][ft][gt][ht][it][jt][kt] && arr[at][bt][ct][dt][et+1][ft][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et+1][ft][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et+1,ft,gt,ht,it,jt,kt});
            }

            if (ft-1>=0 && !v[at][bt][ct][dt][et][ft-1][gt][ht][it][jt][kt] && arr[at][bt][ct][dt][et][ft-1][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft-1][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft-1,gt,ht,it,jt,kt});
            }
            if (ft+1<f && !v[at][bt][ct][dt][et][ft+1][gt][ht][it][jt][kt] && arr[at][bt][ct][dt][et][ft+1][gt][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft+1][gt][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft+1,gt,ht,it,jt,kt});
            }

            if (gt-1>=0 && !v[at][bt][ct][dt][et][ft][gt-1][ht][it][jt][kt] && arr[at][bt][ct][dt][et][ft][gt-1][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt-1][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt-1,ht,it,jt,kt});
            }
            if (gt+1<g && !v[at][bt][ct][dt][et][ft][gt+1][ht][it][jt][kt] && arr[at][bt][ct][dt][et][ft][gt+1][ht][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt+1][ht][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt+1,ht,it,jt,kt});
            }

            if (ht-1>=0 && !v[at][bt][ct][dt][et][ft][gt][ht-1][it][jt][kt] && arr[at][bt][ct][dt][et][ft][gt][ht-1][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht-1][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht-1,it,jt,kt});
            }
            if (ht+1<h && !v[at][bt][ct][dt][et][ft][gt][ht+1][it][jt][kt] && arr[at][bt][ct][dt][et][ft][gt][ht+1][it][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht+1][it][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht+1,it,jt,kt});
            }

            if (it-1>=0 && !v[at][bt][ct][dt][et][ft][gt][ht][it-1][jt][kt] && arr[at][bt][ct][dt][et][ft][gt][ht][it-1][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht][it-1][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht,it-1,jt,kt});
            }
            if (it+1<i && !v[at][bt][ct][dt][et][ft][gt][ht][it+1][jt][kt] && arr[at][bt][ct][dt][et][ft][gt][ht][it+1][jt][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht][it+1][jt][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht,it+1,jt,kt});
            }

            if (jt-1>=0 && !v[at][bt][ct][dt][et][ft][gt][ht][it][jt-1][kt] && arr[at][bt][ct][dt][et][ft][gt][ht][it][jt-1][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht][it][jt-1][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht,it,jt-1,kt});
            }
            if (jt+1<j && !v[at][bt][ct][dt][et][ft][gt][ht][it][jt+1][kt] && arr[at][bt][ct][dt][et][ft][gt][ht][it][jt+1][kt] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht][it][jt+1][kt] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht,it,jt+1,kt});
            }

            if (kt-1>=0 && !v[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt-1] && arr[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt-1] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt-1] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht,it,jt,kt-1});
            }
            if (kt+1<k && !v[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt+1] && arr[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt+1] == 0) {
                if (--remain == 0) {ans = dist; break;}
                v[at][bt][ct][dt][et][ft][gt][ht][it][jt][kt+1] = true;
                q.add(new int[]{dist+1,at,bt,ct,dt,et,ft,gt,ht,it,jt,kt+1});
            }
        }
        System.out.println(ans!=-1?ans+1:ans);
    }

    public static void main(String[] args) throws Exception {
        initFI();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1 << 17;
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
