using System;
using System.IO;
using System.Text;

namespace Prac {
    class Program {
        private static readonly string EXIT_STR = "I quacked the code!";

        static void Main(string[] args) {
            StreamReader sr = new StreamReader(Console.OpenStandardInput());
            StreamWriter sw = new StreamWriter(Console.OpenStandardOutput());
            while (true) {
                string s = Console.ReadLine();
                if (s.Length == EXIT_STR.Length && s.Equals(EXIT_STR))
                    break;
                sw.WriteLine((s[^1] == '?' ? "Quack!" : "*Nod*"));
                sw.Flush();
            }
            sr.Close();
            sw.Close();
        }
    }
}
