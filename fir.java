#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int t;
    cin >> t;
    
    while (t--) {
        long long n, m;
        cin >> n >> m;
        
        vector<long long> petals(n);
        for (long long i = 0; i < n; ++i) {
            cin >> petals[i];
        }
        
        sort(petals.begin(), petals.end());
        
        long long max_petals = 0, current_petals = 0, current_cost = 0;
        int start = 0;
        
        for (int end = 0; end < n; ++end) {
            current_petals += petals[end];
            current_cost += petals[end];
            
            while (start <= end && (current_cost > m || (petals[end] - petals[start] > 1))) {
                current_petals -= petals[start];
                current_cost -= petals[start];
                ++start;
            }
            
            if (current_cost <= m) {
                max_petals = max(max_petals, current_petals);
            }
        }
        
        cout << max_petals << endl;
    }
    
    return 0;
}