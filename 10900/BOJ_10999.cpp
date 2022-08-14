#include <iostream>
using namespace std;
#define ll long long

int n;
ll bit1[1000001] = {0,};
ll bit2[1000001] = {0,};

void update(int bitType, int idx, long diff) {
    ll* bit = bitType==1 ? bit1 : bit2;
    while (idx <= n) {
        bit[idx] += diff;
        idx += idx&-idx;
    }
}

void rangeUpdate(int a, int b, long diff) {
    update(1, a, diff);
    update(1, b+1, -diff);
    update(2, a, diff * (a-1));
    update(2, b+1, -diff * b);
}

ll getBitValue(int bitType, int idx) {
    ll* bit = bitType==1 ? bit1 : bit2;
    long answer = 0;
    while (idx > 0) {
        answer += bit[idx];
        idx -= idx&-idx;
    }
    return answer;
}

ll prefixSum(int idx) {
    return getBitValue(1, idx) * idx - getBitValue(2, idx);
}

ll query(int a, int b) {
    return prefixSum(b) - prefixSum(a-1);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int m, k;
    cin >> n >> m >> k;
    m += k;

    for (int i = 1; i <= n; i++) {
        ll cur;
        cin >> cur;
        rangeUpdate(i, i, cur);
    }

    while (m--) {
        int op, a, b;
        ll v;

        cin >> op;
        switch (op) {
            case 1:
                cin >> a >> b >> v;
                rangeUpdate(a, b, v);
                break;
            case 2:
                cin >> a >> b;
                cout << query(a, b) << '\n';
                break;
        }
    }
}
