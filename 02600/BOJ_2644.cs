using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Prac {
    class Program {
        static bool isEnd = false;
        static StreamReader sr = new StreamReader(Console.OpenStandardInput());
        static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

        static void Main(string[] args) {
            // init
            int n = nextInt();
            int[] target = nextInts();
            int m = nextInt();
            bool[][] e = new bool[n+1][];
            for (int i = 0; i < e.Length; i++)
                e[i] = Enumerable.Repeat(false, n+1).ToArray();
            bool[] v = Enumerable.Repeat(false, n+1).ToArray();

            // input
            while (m-->0) {
                int[] t = nextInts();
                e[t[0]][t[1]] = e[t[1]][t[0]] = true;
            }
            

            // dfs
            dfs(e,v,target[0],target[1],0);
            if (!isEnd)
                sw.WriteLine("-1");
            sw.Flush();
            sw.Close();
            sr.Close();

        }

        private static void dfs(bool[][] e, bool[] v, int idx, int condition, int cnt) {
            if (isEnd)  return;
            if (v[idx]) return;
            if (idx == condition) {
                sw.WriteLine(cnt);
                isEnd = true;
                return;
            }
            v[idx] = true;
            for (int i = 1; i < e[idx].Length; i++) {
                if (e[idx][i])
                    dfs(e, v, i, condition, cnt+1);
            }
        }

        private static int nextInt() {
            return int.Parse(sr.ReadLine());
        }
        
        private static int[] nextInts() {
            String[] tmp = sr.ReadLine().Split();
            int[] res = new int[tmp.Length];
            for (int i = 0; i < res.Length; i++) {
                res[i] = int.Parse(tmp[i]);
            }
            return res;
        }
    }
}
