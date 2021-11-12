import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Word {
    int[] lowerCaseCnt, upperCaseCnt;
    int len;
    char st, ed;
    public Word(String s) {
        len = s.length();
        st = s.charAt(0);
        ed = s.charAt(s.length()-1);
        lowerCaseCnt = new int[26];
        upperCaseCnt = new int[26];
        for (int i = 1; i < s.length()-1; i++) {
            char c = s.charAt(i);
            if (c<'a') upperCaseCnt[c-'A']++;
            else lowerCaseCnt[c-'a']++;
        }
    }

    @Override
    public int hashCode() {
        int hash = (st+ed)*50000;
        for (int i = 0; i < 26; i++) {
            hash += (lowerCaseCnt[i]+1) * (i+1);
            hash += (lowerCaseCnt[i]+1) * (i+26);
        }
        return Math.abs(hash) % 1000000000;
    }

    @Override
    public boolean equals(Object obj) {
        Word ano = (Word)obj;
        if (this.len != ano.len || this.st != ano.st || this.ed != ano.ed)
            return false;

        for (int i = 0; i < 26; i++) {
            if (this.lowerCaseCnt[i] != ano.lowerCaseCnt[i]) return false;
            if (this.upperCaseCnt[i] != ano.upperCaseCnt[i]) return false;
        }
        return true;
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Word, Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-->0) {
            Word cur = new Word(br.readLine());
            int tmp = 0;
            if (hm.containsKey(cur)) tmp = hm.get(cur);
            hm.put(cur, tmp+1);
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 1;
            while (st.hasMoreTokens()) {
                Word cur = new Word(st.nextToken());
                cnt *= hm.getOrDefault(cur, 0);
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
