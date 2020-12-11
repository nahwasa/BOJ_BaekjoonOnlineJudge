using System;
using System.IO;

namespace Prac {
    class Program {
        static void Main(string[] args) {
            StreamReader sr = new StreamReader(Console.OpenStandardInput());
            StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());

            int n = int.Parse(sr.ReadLine());
            string[] arr = sr.ReadLine().Split();
            Boolean flag = true;
            for (int idx = 1; idx < arr.Length; idx++) {
                int ai = int.Parse(arr[idx - 1]);
                int aj = int.Parse(arr[idx]);
                if (aj - ai >= 0) continue;
                flag = false;
                break;
            }
            sw.WriteLine(flag ? "yes" : "no");

            sw.Flush();
            sw.Close();
            sr.Close();            
        }
    }
}
