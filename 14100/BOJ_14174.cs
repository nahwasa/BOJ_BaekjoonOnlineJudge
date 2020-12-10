using System;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            int n = nextInt();
            int[] res = new int[26];
            while (n-->0) {
                string[] words = Console.ReadLine().Split();
                int[,] cnt = new int[2,26];
                for (int i = 0; i < 2; i++) {
                    char[] tmp = words[i].ToCharArray();
                    for (int j = 0; j < tmp.Length; j++) {
                        cnt[i, tmp[j] - 'a']++;
                    }
                }
                
                for (int i = 0; i < res.Length; i++) {
                    res[i] += Math.Max(cnt[0, i], cnt[1, i]);
                }
            }

            foreach (int i in res) {
                Console.WriteLine(i);
            }
        }

        private static int nextInt() {
            return int.Parse(Console.ReadLine());
        }
    }
}
