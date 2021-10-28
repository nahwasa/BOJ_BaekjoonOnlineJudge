import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    class Variable {
        boolean isRoot;
        String word, var1, var2;
        public Variable(String a) {
            isRoot = true;
            word = a;
        }
        public Variable(String a, String b) {
            isRoot = false;
            var1 = a;
            var2 = b;
        }
    }

    HashMap<String, Variable> hm;
    HashSet<String> hs;
    String p;
    int pIdx;

    private void search(String cur) {
        if (hs.contains(cur)) return;
        hs.add(cur);

        Variable tmp = hm.get(cur);
        if (tmp.isRoot) {
            String s = tmp.word;
            for (int i = 0; i < s.length() && pIdx < p.length(); i++) {
                if (p.charAt(pIdx) == s.charAt(i)) {
                    pIdx++;
                    hs.clear();
                }
            }
            return;
        }

        search(tmp.var1);
        search(tmp.var2);
    }

    private void solution() throws Exception {
        int tc = nextInt();
        while (tc-->0) {
            hm = new HashMap<>();
            hs = new HashSet<>();
            int k = nextInt();
            while (k-->0) {
                StringTokenizer st = new StringTokenizer(nextLine(), " =+");
                String key = st.nextToken();
                String a = st.nextToken();
                if (st.hasMoreTokens()) hm.put(key, new Variable(a, st.nextToken()));
                else hm.put(key, new Variable(a));
            }
            String t = nextLine();
            p = nextLine();
            pIdx = 0;
            search(t);
            print(pIdx == p.length());
        }
        flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringBuilder answer = new StringBuilder();

    private int nextInt() throws Exception {return Integer.parseInt(nextLine());}
    private String nextLine() throws Exception {return br.readLine();}
    private void print(boolean isOk) {
        if(isOk) answer.append('Y').append('E').append('S').append('\n');
        else answer.append('N').append('O').append('\n');
    }
    private void flush() {System.out.print(answer);}

}
