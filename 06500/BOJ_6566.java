import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Word implements Comparable<Word> {
    private static final int LEN = 'z'-'a'+1;
    int[] cnt;
    ArrayList<InputString> list;
    int size = 0;
    String checker;

    public Word(InputString inputString) {
        String s = inputString.s;
        cnt = new int[LEN];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < LEN; i++) {
            tmp.append((char)(i+'a')).append(cnt[i]);
        }
        checker = tmp.toString();
    }

    public void add(InputString inputString) {
        this.size += inputString.cnt;
        this.list.add(inputString);
    }

    @Override
    public int hashCode() {
        return checker.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.checker.equals(((Word)obj).checker);
    }

    @Override
    public int compareTo(Word o) {
        if (this.size == o.size)
            return this.list.get(0).s.compareTo(o.list.get(0).s);
        return o.size - this.size;
    }
}

class InputString implements Comparable<InputString> {
    String s;
    int cnt;
    public InputString(String s) {
        this.s = s;
        this.cnt = 1;
    }

    @Override
    public int compareTo(InputString o) {
        return this.s.compareTo(o.s);
    }
}

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<InputString> input = new ArrayList<>();
        HashMap<String, InputString> dupChk = new HashMap<>();
        while (true) {
            String cur = br.readLine();
            if (cur == null || cur.isEmpty()) break;
            if (dupChk.containsKey(cur)) {
                dupChk.get(cur).cnt++;
                continue;
            }
            InputString tmp = new InputString(cur);
            dupChk.put(cur, tmp);
            input.add(tmp);
        }
        Collections.sort(input);

        HashMap<Word, Integer> hm = new HashMap<>();
        ArrayList<Word> list = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            Word word = new Word(input.get(i));

            if (!hm.containsKey(word)) {
                word.list = new ArrayList<>();
                word.add(input.get(i));
                hm.put(word, list.size());
                list.add(word);
            } else {
                Word rootWord = list.get(hm.get(word));
                rootWord.add(input.get(i));
            }
        }

        Collections.sort(list);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            Word cur = list.get(i);
            answer.append(String.format("Group of size %d: ", cur.size));
            for (InputString inputString : cur.list) {
                answer.append(inputString.s).append(' ');
            }
            answer.append('.').append('\n');
        }
        System.out.print(answer);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
