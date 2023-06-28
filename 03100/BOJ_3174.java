import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int MOD = 1337377;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        String str = br.readLine();
        TrieRoot trie = setupTrie();
        int len = str.length();

        int[] dp = new int[len+1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {

            int base = dp[i-1];
            if (base == 0) continue;

            Node iter = trie.root.peek(str.charAt(i-1));
            int pt = i;

            while (true) {
                if (iter == null) break;
                if (iter.isWordExist()) {
                    dp[pt] += base;
                    dp[pt] %= MOD;
                }

                if (pt == len) break;
                iter = iter.peek(str.charAt(pt++));
            }
        }

        System.out.println(dp[len]);
    }

    private TrieRoot setupTrie() throws Exception {
        TrieRoot trie = new TrieRoot();

        int n = Integer.parseInt(br.readLine());
        while (n-->0) {
            trie.add(br.readLine());
        }

        return trie;
    }
}

class TrieRoot {

    Node root;

    public TrieRoot() {
        root = Node.root();
    }

    public void add(String s) {
        Node iter = root;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            iter = iter.retrieveChild(c);
        }

        iter.endOfWord();
    }
}

class Node {
    private boolean isWordExist;
    private Node[] child;

    private Node() {
        isWordExist = false;
        child = new Node['z'-'a'+1];
    }

    public static Node root() {
        return new Node();
    }

    public void endOfWord() {
        isWordExist = true;
    }

    public Node retrieveChild(char c) {
        int idx = c - 'a';

        if (child[idx] == null) {
            child[idx] = new Node();
        }

        return peek(c);
    }

    public Node peek(char c) {
        int idx = c - 'a';

        return child[idx];
    }

    public boolean isWordExist() {
        return isWordExist;
    }
}
