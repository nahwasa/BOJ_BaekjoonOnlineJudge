using System;

namespace Prac {
    class Program {
        private static int nextInt() {
            return int.Parse(Console.ReadLine());
        }

        static void Main(string[] args) {
            int tc = int.Parse(Console.ReadLine());
            while (tc-- > 0) {
                int[] n = new int[3];
                WordStorage[] arr = new WordStorage[3];
                arr[0] = new WordStorage(nextInt());
                arr[1] = new WordStorage(nextInt());
                arr[2] = new WordStorage(nextInt());
                for (int i = 0; i < n.Length; i++) {
                    arr[i].readWordsFromConsoleInput();
                }
                ExhaustiveSearchWordStorage(arr, 0, 0, 0, 0);
                Console.WriteLine();
            }
            
        }

        private static void ExhaustiveSearchWordStorage(WordStorage[] arr, int process, int w1, int w2, int w3) {
            // break condition
            if (process == 3) {
                Console.WriteLine(string.Format("{0} {1} {2}.", arr[0].getWord(w1), arr[1].getWord(w2), arr[2].getWord(w3)));
                return;
            }

            for (int i = 0; i < arr[process].getLength(); i++) {
                switch (process) {
                    case 0:
                        ExhaustiveSearchWordStorage(arr, process + 1, i, w2, w3);
                        break;
                    case 1:
                        ExhaustiveSearchWordStorage(arr, process + 1, w1, i, w3);
                        break;
                    case 2:
                        ExhaustiveSearchWordStorage(arr, process + 1, w1, w2, i);
                        break;
                }
            }
        }
    }

    class WordStorage {
        private string[] storage;

        public WordStorage(int n) {
            this.storage = new string[n];
        }

        public void readWordsFromConsoleInput() {
            for (int i = 0; i < storage.Length; i++) {
                this.storage[i] = Console.ReadLine();
            }
        }

        public int getLength() {
            return storage.Length;
        }

        public string getWord(int idx) {
            return storage[idx];
        }
    }
}
