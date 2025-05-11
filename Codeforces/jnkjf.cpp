#include <bits/stdc++.h>
using namespace std;
const int MAX = 110000;
const int Q = 100000;
vector<int> primes;
vector<int> a(Q + 1);

void sieve(int limit) {
    vector<bool> prime(limit + 1, true);
    prime[0] = prime[1] = false;
    for (int i = 2; i * i <= limit; i++) {
        if (prime[i]) {
            for (int j = i * i; j <= limit; j += i) {
                prime[j] = false;
            }
        }
    }
    for (int i = 2; i <= limit; i++) {
        if (prime[i]) primes.push_back(i);
    }
}
void preprocess(int q) {
    int i = 0;
    for (int j = 1; j <= q; j++) {
        while (i < primes.size() && primes[i] < j) {
            i++;
        }
        a[j] = (i < primes.size()) ? primes[i] : -1;
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    sieve(MAX);
    preprocess(Q);

    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << a[n] << '\n';
    }

    return 0;
}
