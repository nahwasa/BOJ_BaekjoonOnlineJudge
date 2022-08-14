#include <iostream>
using namespace std;
#define ll long long

int n;
ll bit[100001] = {0,};

void update(int i, ll diff) {
    while (i <= n) {
        bit[i] += diff;
        i += i&-i;
    }
}

ll query(int i) {
    ll sum = 0;
    while (i > 0) {
        sum += bit[i];
        i -= i&-i;
    }
    return sum;
}

void rangeUpdate(int i, int j, ll diff) {
    update(i, diff);
    update(j+1, -diff);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int m;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        ll cur;
        cin >> cur;
        rangeUpdate(i, i, cur);
    }

    cin >> m;
    while (m--) {
        int op, a, b, c;
        cin >> op;
        switch (op) {
            case 1:
                cin >> a >> b >> c;
                rangeUpdate(a, b, c);
                break;
            case 2:
                cin >> a;
                cout << query(a) << '\n';
                break;
        }
    }
}
