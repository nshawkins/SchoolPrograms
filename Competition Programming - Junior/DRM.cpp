#include <iostream>

using namespace std;
int main(){
	string str1, str2, str3, string2, string3, string4;
	int len, half, tmp1, tmp2;
	int count1 = 0; int count2 = 0; int temp = 0; int temp2 = 0;
	cin >> str1;
	len = str1.length();
	//divide
	half = len / 2;
	str2 = str1.substr(0, half);
	str3 = str1.substr(half, str1.length());
	string2 = str2;
	string3 = str3;
	string4 = str2;
	//rotate number
	for (int i = 0; i < str2.length(); i++) {
		count1 += str2[i];
		count1 -= 65;
	}
	for (int i = 0; i < str3.length(); i++) {
		count2 += str3[i];
		count2 -= 65;
	}
	//rotation
	for (int i = 0; i < str2.length(); i++) {
		tmp1 = str2[i];
		tmp1 += count1;
		for (int j = tmp1 - count1, k = tmp1 - count1; j <= tmp1; j++, k++) {
			if (k > 90) {
				k = 65;
			}
			temp = k;
		}
		tmp1 = temp;
		string2[i] = tmp1;
	}
	for (int i = 0; i < str3.length(); i++) {
		tmp2 = str3[i];
		tmp2 += count2;
		for (int j = tmp2 - count2, k = tmp2 - count2; j <= tmp2; j++, k++) {
			if (k > 90) {
				k = 65;
			}
			temp = k;
		}
		tmp2 = temp;
		string3[i] = tmp2;
	}
	//merge
	for (int i = 0; i < str2.length(); i++) {
		tmp1 = string2[i];
		tmp2 = string3[i];
		temp = tmp1 + (tmp2 - 65);
		for (int j = tmp1, k = tmp1; j <= temp; j++, k++) {
			if (k > 90) {
				k = 65;
			}
			temp2 = k;
		}
		string4[i] = temp2;
	}
	cout << string4;
}