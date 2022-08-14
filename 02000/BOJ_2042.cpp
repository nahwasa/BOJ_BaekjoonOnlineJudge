#include <iostream>
using namespace std;
#define ll long long

int n;
ll arr[1000001] = {0,};
ll bit[1000001] = {0,};

ll getPrefixSum(int ith) {
    ll answer = 0l;
    while (ith > 0) {
        answer += bit[ith];
        ith -= ith&-ith;
    }
    return answer;
}

ll query(int b, int c) {
    return getPrefixSum(c) - getPrefixSum(b-1);
}

void update(int ith, long val) {
    ll diff = val - arr[ith];
    arr[ith] = val;

    while (ith <= n) {
        bit[ith] += diff;
        ith += ith&-ith;
    }
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
        update(i, cur);
    }
    while (m--) {
        int a, b, c;
        ll v;
        cin >> a;
        switch (a) {
            case 1:
                cin >> b >> v;
                update(b, v);
                break;
            case 2:
                cin >> b >> c;
                cout << query(b, c) << '\n';
                break;
        }
    }
}
