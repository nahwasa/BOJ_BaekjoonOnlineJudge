import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        TrieRoot trie = setupTrie();
        StringBuilder answer = new StringBuilder();

        int b = Integer.parseInt(br.readLine());
        while (b-->0) {
            char[][] boggle = new char[4][4];
            for (int i = 0; i < 4; i++) {
                String row = br.readLine();
                for (int j = 0; j < 4; j++) {
                    boggle[i][j] = row.charAt(j);
                }
            }

            if (b!=0) br.readLine();    // drop blank line

            FindBoggleResult findBoggleResult = new FindBoggleResult(trie, boggle, answer);
            findBoggleResult.findAndPrintAnswer();
        }

        System.out.print(answer);
    }

    private TrieRoot setupTrie() throws Exception {
        TrieRoot trie = new TrieRoot();

        int w = Integer.parseInt(br.readLine());
        while (w-->0) {
            trie.add(br.readLine());
        }
        br.readLine();  // drop blank line

        return trie;
    }
}

class FindBoggleResult {
    TrieRoot trie;
    char[][] boggle;
    int scoreSum;
    String maxLenWord;
    int cnt;
    StringBuilder answer;
    boolean[][] v;
    Set<String> alreadyFound;

    public FindBoggleResult(TrieRoot trie, char[][] boggle, StringBuilder answer) {
        this.trie = trie;
        this.boggle = boggle;
        this.answer = answer;
        scoreSum = 0;
        maxLenWord = null;
        cnt = 0;
        v = new boolean[4][4];
        alreadyFound = new HashSet<>();
    }

    public void findAndPrintAnswer() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                v[i][j] = true;
                find(1, i, j, trie.root.peek(boggle[i][j]));
                v[i][j] = false;
            }
        }

        answer.append(scoreSum).append(' ')
                .append(maxLenWord).append(' ')
                .append(cnt).append('\n');
    }

    private void register(String word) {
        if (alreadyFound.contains(word)) return;
        alreadyFound.add(word);
        cnt++;

        int score = getScore(word);
        scoreSum += score;

        if (maxLenWord == null) {
            maxLenWord = word;
            return;
        }

        if (maxLenWord.length() < word.length() || (word.length() == maxLenWord.length() && word.compareTo(maxLenWord) < 0)) {
            maxLenWord = word;
        }
    }

    private int getScore(String word) {
        int len = word.length();
        if (len <= 2) return 0;
        if (len <= 4) return 1;
        if (len == 5) return 2;
        if (len == 6) return 3;
        if (len == 7) return 5;
        if (len == 8) return 11;
        return 0;
    }

    private void find(int cnt, int r, int c, Node node) {
        if (node == null || cnt == 9) return;
        if (node.isWordExist()) register(node.getWord());

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nr = r+i;
                int nc = c+j;

                if (nr<0 || nr>=4 || nc<0 || nc>=4 || v[nr][nc]) continue;
                v[nr][nc] = true;
                find(cnt+1, nr, nc, node.peek(boggle[nr][nc]));
                v[nr][nc] = false;
            }
        }
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

        iter.endOfWord(s);
    }
}

class Node {
    private String word;
    private Node[] child;

    private Node() {
        word = null;
        child = new Node['Z'-'A'+1];
    }

    public static Node root() {
        return new Node();
    }

    public void endOfWord(String s) {
        word = s;
    }

    public Node retrieveChild(char c) {
        int idx = c - 'A';

        if (child[idx] == null) {
            child[idx] = new Node();
        }

        return peek(c);
    }

    public Node peek(char c) {
        int idx = c - 'A';

        return child[idx];
    }

    public boolean isWordExist() {
        return word != null;
    }

    public String getWord() {
        return word;
    }
}
