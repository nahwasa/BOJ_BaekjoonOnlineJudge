import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Trie {
    boolean isWordEnd;
    Trie[] child;

    public Trie() {
        isWordEnd = false;
        child = new Trie[26];
    }

    public Trie addAndGetChild(char c) {
        if (child[c-'a'] == null)
            child[c-'a'] = new Trie();
        return child[c-'a'];
    }

    public Trie getChild(char c) {
        return child[c-'a'];
    }

    public void setWordEnd() {
        this.isWordEnd = true;
    }
}

public class Main {
    Trie cTrie = new Trie();    // 색상 트라이
    HashSet<String> nHs = new HashSet<>();
    int cMin, nMin, cMax, nMax;

    private boolean searchTeamName(String s) {
        int len = s.length();
        // 우선 팀명에 대해 앞 부분 부터 보면서 색상과 매칭되는걸 colorMatched에 기록
        Trie iter = cTrie;
        for (int i = 0; i < len; i++) {
            if (len-i < nMin)
                break;
            iter = iter.getChild(s.charAt(i));
            if (iter == null) break;
            if (iter.isWordEnd) {
                if (nHs.contains(s.substring(i+1)))
                    return true;
            }
        }
        return false;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        cMin = nMin = 1001;
        cMax = nMax = 0;
        for (int i = 0; i < c; i++) {
            String cur = br.readLine();
            int len = cur.length();
            if (len < cMin) cMin = len;
            if (len > cMax) cMax = len;
            // 이하 색상 트라이 삽입
            Trie iter = cTrie;
            for (int j = 0; j < len; j++) {
                iter = iter.addAndGetChild(cur.charAt(j));
            }
            iter.setWordEnd();
        }
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            int len = cur.length();
            if (len < nMin) nMin = len;
            if (len > nMax) nMax = len;
            nHs.add(cur);
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            String cur = br.readLine();
            boolean chk = cur.length() > cMax + nMax ? false : searchTeamName(cur);
            if (chk) {
                sb.append('Y').append('e').append('s').append('\n');
            } else {
                sb.append('N').append('o').append('\n');
            }
        }
        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
