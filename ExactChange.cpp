#include <iostream>
#include <iomanip>
#include <algorithm>

using namespace std;
const int M = 999;
int memo[10000][100];
int coins[100];
int coinCount;
int num_coins(int ammount, int coin) {

	//base cases:
	if ((ammount > 0) && (memo[ammount][coin] != -1)) {
		return memo[ammount][coin];
	}
	if (ammount == 0) {
		return memo[ammount][coin] = 0;
	}
	if (ammount < 0) {
		return M;
	}
	if (coin == coinCount) {
		return memo[ammount][coin] = M;
	}
	//recursive case:
	return memo[ammount][coin] = min({
		num_coins(ammount, coin + 1), //dont take
		num_coins(ammount - coins[coin], coin + 1) + 1 //used
	});
}


int main() {
	int cases;
	cin >> cases;
	int target;
	for (int z = 0; z < cases; z++) {
		cin >> target;

		//set memo to -1
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 100; j++) {
				memo[i][j] = -1;
			}
		}

		//populate array with inputs
		cin >> coinCount;
		for (int i = 0; i < coinCount; i++) {
			int num;
			cin >> num;
			coins[i] = num;
		}

		//find answer
		int ans = num_coins(target, 0);

		//increment value
		while (ans == 999) {
			target++;
			ans = num_coins(target, 0);
		}
		cout << target << " " << ans << "\n";

		//print memo
		/*for (int i = 0; i < target; i++) {
			for (int j = 0; j < coinCount; j++) {
				cout << setw(3) << memo[i][j];
			}
			cout << "\n";
		}*/

	}
}

/* Notes:

answer must be minimum total and minmal number of coins
Brute force: binairy logic - try all possible combinations until it works

ammount
which coins

Data: coins
State (of search/exploration): ammount searched for and coin number
Choice:
Return value/type: number of coins

int num-coins(ammount, i (i = current coin to consider)){
//base case:
if ammount == 0{
	return 0;}
if i (num of coins) > max{
	return M; (M is what you dont want. its massive)}
if ammount < 0{
	return M;}

//recursive case:

return min({
	num_coins(ammount, i+1), //dont take
	num_coins(ammount - coins[i], i+1), //take the coin
	if (i < a.length() ? d[i+1][j] = M; (for edit dist) checks outside of memo
});

new notes:
min(
	nc[amt][i+1] //dont take
	nc[amt - coin[i]][i+1] + 1 //take coin


	subtract two zeroes off of the number to allow it to fit in the 100 size memo

}

TODO:
1) implement recursive solution
2) understand table
3) dynamic programming solution

*/