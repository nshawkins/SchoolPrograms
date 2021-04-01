#include <algorithm>
#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main() {
	int n;
	while (cin >> n && n) {
		int maximum = 0; int ans = 0;
		map<vector<int>, int> mymap;

		for (int i = 0; i < n; i++){
			vector<int> arr(5);

			for (int j = 0; j < 5; j++){
				cin >> arr[j];
			}
			sort(arr.begin(), arr.end());
			maximum = max(++mymap[arr], maximum); //compare max to new num
		}

		for (map<vector<int>, int>::iterator it = mymap.begin(); it != mymap.end(); ++it){
			if (it->second == maximum){ //second = value
				ans += maximum;
			}
		}
		cout << ans << endl;
	}
}