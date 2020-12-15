using System;
using System.Collections.Generic;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            int n = nextInt();
            int c = nextInt();
            
            // init
            bool[][] e = new bool[n+1][];
            for (int i = 1; i < e.Length; i++) {
                e[i] = new bool[n+1];
                for (int j = 0; j < e[i].Length; j++) {
                    e[i][j] = false;
                }
            }            
            bool[] v = new bool[n+1];
            for (int i = 1; i < v.Length; i++) {
                v[i] = false;
            }

            // get edge
            while (c-->0) {
                string[] tmp = Console.ReadLine().Split();
                int a = int.Parse(tmp[0]);
                int b = int.Parse(tmp[1]);
                e[a][b] = e[b][a] = true;
            }

            // dfs
            Stack<int> s = new Stack<int>();
            s.Push(1);
            while (s.Count != 0) {
                int idx = s.Pop();
                v[idx] = true;

                for (int i = 1; i < e[idx].Length; i++) {
                    if (!v[i] && e[idx][i])
                        s.Push(i);
                }
            }

            // print result
            int cnt = 0;
            for (int i = 2; i < v.Length; i++)
                cnt += v[i]?1:0;
            Console.WriteLine(cnt);
        }

        private static int nextInt() {
            return int.Parse(Console.ReadLine());
        }
    }
}
