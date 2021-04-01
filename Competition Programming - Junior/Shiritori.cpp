#include <iostream>
#include <set>
#include <iterator>

using namespace std;

int main() {
	int n = 0;
	cin >> n;

	set<string> game;
	string word;
	game.size() == 0;
	char lastLet = NULL;
	char firstLet;
	
	for (int i = 0; i < n; i++) {
		cin >> word;
		firstLet = word.at(0);
		if (game.find(word) != game.end()) {
			if (i % 2 == 0) {
				cout << "Player 1 lost";
			}
			else {
				cout << "Player 2 lost";
			}
			break;
		}
		game.insert(word);
		if ((lastLet != NULL) && (lastLet != firstLet)) {
			if (i % 2 == 0) {
				cout << "Player 1 lost";
			}
			else {
				cout << "Player 2 lost";
			}
			break;
		}
		lastLet = word.at(word.length() - 1);
		if (i == n - 1) {
			cout << "Fair game";
		}
	}
}