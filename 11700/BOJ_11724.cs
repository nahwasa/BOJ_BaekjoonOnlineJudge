using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Prac {
    class Program {
        static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());
        static StreamReader sr = new StreamReader(Console.OpenStandardInput());

        static void Main(string[] args) {
            // init
            int[] t = nextInts();
            int n = t[0];
            int m = t[1];
            bool[][] e = new bool[n+1][];
            for (int i = 0; i < e.Length; i++)
                e[i] = Enumerable.Repeat(false, n+1).ToArray();
            bool[] v = Enumerable.Repeat(false, n+1).ToArray();

            // input
            while (m-->0) {
                t = nextInts();
                e[t[0]][t[1]] = e[t[1]][t[0]] = true;
            }
            sr.Close();

            // dfs
            int cnt = 0;
            for (int i = 1; i < v.Length; i++) {
                if (!v[i]) {
                    cnt++;
                    dfs(e,v,i);
                }
            }
            
            // print
            sw.WriteLine(cnt);
            
            sw.Flush();
            sw.Close();
        }

        private static void dfs(bool[][] e, bool[] v, int idx) {
            if (v[idx]) return;
            v[idx] = true;
            for (int i = 1; i < e[idx].Length; i++) {
                if (e[idx][i])
                    dfs(e, v, i);
            }
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
