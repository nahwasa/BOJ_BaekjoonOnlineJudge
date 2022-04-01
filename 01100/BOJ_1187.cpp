#include <iostream>
#include <deque>

using namespace std;

class Num {
public:
    Num() {

    }

    int num;
    int ingredients[64] = {0, };

    Num(int num, int idx) {
        this->num = num;
        this->ingredients[idx/32] = 1<<idx%32;
    }
    Num(Num a, Num b) {
        this->num = a.num + b.num;
        for (int i = 0; i < 64; i++) {
            this->ingredients[i] = a.ingredients[i] | b.ingredients[i];
        }
    }
};

int main()
{
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    int arr[2048] = {0, };
    deque<Num> dq;

    int n, cur;
    cin >> n;
    for (int i = 0; i < 2*n-1; i++) {
        cin >> cur;
        arr[i] = cur;
        dq.push_back(Num(cur, i));
    }

    int k = 1;
    int tmp = n;
    while ((tmp>>=1) != 1) {
        k++;
    }
    for (int i = 1; i <= k; i++) {
        int limit = dq.size() / 2;
        for (int j = 0; j < limit; j++) {
            Num sel[3];
            sel[0] = dq.front();
            dq.pop_front();
            sel[1] = dq.front();
            dq.pop_front();
            sel[2] = dq.front();
            dq.pop_front();
            
            bool chk = false;
            for (int y = 0; y < 2 && !chk; y++) {
                for (int z = y+1; z < 3; z++) {
                    if ((sel[y].num + sel[z].num) % (1<<i) == 0) {
                        dq.push_back(Num(sel[y], sel[z]));
                        if (j != limit-1) dq.push_front(sel[3-y-z]);
                        chk = true;
                        break;
                    }
                }
            }

        }
    }

    Num ans = dq.front();

    for (int i = 0; i < 64; i++) {
        int idx = i*32;
        for (int j = 0; j < 32; j++) {
            if ((ans.ingredients[i] & 1<<j) != 0) {
                cout << arr[idx + j] << ' ';
            }
        }
    }
}
