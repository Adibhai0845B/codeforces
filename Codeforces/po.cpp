#include <bits/stdc++.h>
using namespace std;
signed main() { 
    int t;
    cin >> t; // Number of test cases

    while (t--) {
        int n, k;
        cin >> n >> k; // Read n (number of elements) and k (number of operations)
        
        vector<int> b(n);
        map<int, int> mp;

        // Read the array and build a frequency map
        for (auto &it : b) {
            cin >> it;
            mp[it]++;
        }

        // Extract frequencies into a vector
        vector<int> s;
        for (auto it : mp) {
            s.push_back(it.second);
        }

        // Lambda function to calculate sum of first 'a' natural numbers
        auto sumupto = [&](int a) {
            return (a * (a + 1)) / 2;
        };

        // Sort frequencies in descending order
        sort(s.rbegin(), s.rend());

        int dec = 0; // Tracks the total decrement in the sum
        map<int, int> mpb; // Frequency count of the frequencies

        // Build frequency of frequencies
        for (auto it : s) {
            mpb[it]++;
        }

        // Min-heap (priority queue) to process frequencies in ascending order
        priority_queue<int, vector<int>, greater<int>> pq;
        for (auto it : mpb) {
            pq.push(it.first);
        }

        map<int, int> vis; // Visited tracker for priority queue

        // Process the frequencies using the available 'k' operations
        while (!pq.empty()) {
            int top = pq.top(); // Smallest frequency
            if (vis[top]) {
                pq.pop();
                continue;
            }

            if (k >= mpb[top]) {
                // If we can fully "use up" this frequency
                k -= mpb[top];
                mpb[top - 1] += mpb[top];
                mpb[top] = 0;
                pq.push(top - 1); // Push reduced frequency
                vis[top] = 1;
                pq.pop();
            } else {
                // If 'k' is not enough to fully use up this frequency
                mpb[top] -= k;
                k = 0;
                break;
            }
        }

        // Calculate the total decrement in the sum
        for (auto it : mpb) {
            dec += it.second * (sumupto(it.first - 1));
        }

        // Calculate the final answer
        int ans = sumupto(n - 1) - dec;
        cout << ans << endl;
    }   
    return 0;
}
