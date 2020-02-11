#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_set>
#include <iterator>

using namespace std;
int main() {
	int n = 0;
	int t = 0;
	cin >> n >> t;
	int key = 0; bool YorN = false; int BSindex = 0; int count = 0;
	vector<int> arr;
	arr.resize(n);
	vector<int> tmparr;
	tmparr.resize(n);
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr.begin(), arr.end());
	//--------------------------------------
	// test 1
	if (t == 1) {
		for (int i = 0; i < n; i++) {
			key = 7777 - arr[i];
			BSindex = binary_search(arr.begin(), arr.end(), key);
			if (BSindex > 0) {
				YorN = true;
			}
		}
		if (YorN == true) {
			cout << "Yes";
		}
		else {
			cout << "No";
		}
	}
	//---------------------------------------
	// test 2
	if (t == 2) {
		unordered_set<int> set;
		copy(arr.begin(), arr.end(), inserter(set, set.end()));
		if (n == set.size()) {
			cout << "Unique";
		}
		else {
			cout << "Contains duplicate";
		}
	}
	//---------------------------------------
	// test 3
	if (t == 3) {
		for (int i = 0; i < n; i++) {
			int value = arr[i];
			tmparr[value]++;
		}
		int maxIndex = 0;
		for (int i = 1; i < n; i++) {
			if (tmparr[i] > tmparr[maxIndex]) {
				maxIndex = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == maxIndex) {
				count++;
			}
		}
		if (count > (n / 2)) {
			cout << maxIndex;
		}
		else {
			cout << "-1";
		}
	}
	//---------------------------------------
	// test 4
	if (t == 4) {
		if (n % 2 == 0) {
			cout << arr[(n / 2) - 1] << " " << arr[n / 2];
		}
		else {
			cout << arr[n / 2];
		}
	}
	//---------------------------------------
	// test 5
	if (t == 5) {
		for (int i = 0; i < n; i++) {
			if ((arr[i] >= 100) && (arr[i] < 1000)) {
				tmparr[i] = arr[i];
			}
		}
		sort(tmparr.begin(), tmparr.end());
		for (int i = 0; i < n; i++) {
			if (tmparr[i] != 0) {
				cout << tmparr[i] << " ";
			}
		}
	}
}