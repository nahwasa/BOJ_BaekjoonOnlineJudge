import java.io.BufferedReader;
import java.io.InputStreamReader;

class Trie {
    boolean isWordEnd;
    Trie[] child;
    int childCnt;

    public Trie() {
        isWordEnd = false;
        child = new Trie[26];
        childCnt = 0;
    }

    public Trie addAndGetChild(char c) {
        if (child[c-'a'] == null) {
            child[c - 'a'] = new Trie();
            childCnt++;
        }
        return child[c-'a'];
    }

    public void setWordEnd() {
        this.isWordEnd = true;
    }
}

public class Main {
    Trie trie;
    int cntSum;
    private void insert(String s) {
        Trie iter = trie;
        for (int i = 0; i < s.length(); i++) {
            iter = iter.addAndGetChild(s.charAt(i));
        }
        iter.setWordEnd();
    }

    private void proc(Trie iter, int cnt) {
        if (iter.isWordEnd) {
            cntSum += cnt;
        }
        for (int i = 0; i < 26; i++) {
            if (iter.child[i] == null) continue;
            proc(iter.child[i], iter.childCnt==1?(iter.isWordEnd?cnt+1:cnt):cnt+1);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            trie = new Trie();
            cntSum = 0;
            int n = Integer.parseInt(s);
            for (int i = 0; i < n; i++) {
                insert(br.readLine());
            }
            for (int i = 0; i < 26; i++) {
                if (trie.child[i] == null) continue;
                proc(trie.child[i], 1);
            }
            sb.append(String.format("%.2f\n", 1d*cntSum/n));
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
