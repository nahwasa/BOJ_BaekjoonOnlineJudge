import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int A_TO_Z = 'z'-'a'+1;
    private static final int WORD_LIMIT = 200000;

    private boolean isValid(byte[] word, byte[] board) {
        for (int i = 0; i < A_TO_Z; i++) {
            if (board[i] < word[i]) return false;
        }
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[][] wordsCnt = new byte[WORD_LIMIT][A_TO_Z];
        int n = 0;

        // get words until "-"
        while (true) {
            String word = br.readLine();
            if (word.equals("-")) break;
            // counting number of appearances of each alphabet
            for (int i = 0; i < word.length(); i++)
                wordsCnt[n][word.charAt(i)-'A']++;
            n++;
        }

        StringBuilder answer = new StringBuilder();
        // get puzzle board until "#"
        while (true) {
            String board = br.readLine();
            if (board.equals("#")) break;
            byte[] boardCnt = new byte[A_TO_Z];
            // counting number of each alphabet
            for (int i = 0; i < board.length(); i++)
                boardCnt[board.charAt(i)-'A']++;

            int[] result = new int[A_TO_Z];
            int min = WORD_LIMIT+1;
            int max = 0;
            for (int i = 0; i < n; i++) {
                // ignore impossible(invalid) words
                if (!isValid(wordsCnt[i], boardCnt)) continue;

                // counting valid word's number of each alphabet
                for (int j = 0; j < A_TO_Z; j++) {
                    if (wordsCnt[i][j] != 0)
                        result[j]++;
                }
            }

            // check min & max count
            for (int j = 0; j < A_TO_Z; j++) {
                if (boardCnt[j] == 0) continue;
                if (min > result[j]) min = result[j];
                if (max < result[j]) max = result[j];
            }
            
            // print min alphabet
            for (int j = 0; j < A_TO_Z; j++) {
                if (boardCnt[j] != 0 && result[j] == min)
                    answer.append((char)('A'+j));
            }
            answer.append(' ').append(min).append(' ');
            
            // print max alphabet
            for (int j = 0; j < A_TO_Z; j++) {
                if (boardCnt[j] != 0 && result[j] == max)
                    answer.append((char)('A'+j));
            }
            answer.append(' ').append(max).append('\n');
        }
        System.out.print(answer);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
