using System;
using System.Collections.Generic;

namespace Boj {
    class Ps {
        static void Main(string[] args) {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);
            HashSet<int> nSet = new HashSet<int>();
            HashSet<int> mSet = new HashSet<int>();
            for (int i = 0; i < n; i++) { 
                string tmp = Console.ReadLine();
                for (int j = 0; j < tmp.Length; j++) {
                    if (tmp[j] == 'X') {
                        mSet.Add(j);
                        nSet.Add(i);
                    }
                }
            }
            Console.WriteLine(Math.Max(n - nSet.Count, m - mSet.Count));
        }
    }
}
