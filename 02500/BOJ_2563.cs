using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Linq;

namespace Prac {
    class Program {
        private static StreamReader sr = new StreamReader(Console.OpenStandardInput());
        private static StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

        static void Main(String[] args) {
        	int n = int.Parse(sr.ReadLine());
        	int ans = 0;
        	int[] arr = Enumerable.Repeat<int>(0, 10000).ToArray<int>();
        	while (n-->0) {
        		string[] inp = sr.ReadLine().Split(" ");
        		int r = int.Parse(inp[0]);
        		int c = int.Parse(inp[1]);
        		
        		for (int i = r; i < r+10; i++) {
        			for (int j = c; j < c+10; j++) {
        				if (++arr[i*100+j] == 1) {
        					ans++;
        				}
        			}
        		}
        	}
        	sw.Write(""+ans);
        	sw.Flush();
        }
    }
}
