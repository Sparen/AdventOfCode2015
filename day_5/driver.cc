#include <iostream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <fstream>

using std::string;
using std::cout;
using std::endl;
using std::ifstream;

int main(int argc, char** argv) {
  int totalnice = 0;
  ifstream file;
  file.open(argv[1]);
  string input;
  while (getline(file, input)) {
    bool doubleletter = false;
    int numvowels = 0;
    char prev = ' '; //overwrite
    bool nice = true;
    for (int j = 0; j < input.length(); j++) { //go through all characters
      char curr = input.at(j);
      if (curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
	numvowels++;
      }

      if (prev != ' ') {
	if (prev == curr) {
	  doubleletter = true;
	}
	if ((prev == 'a' && curr == 'b') || (prev == 'c' && curr == 'd') || (prev == 'p' && curr == 'q') || (prev == 'x' && curr == 'y')) {
	  nice = false;
	} 
      }
      prev = curr;
    }
    if (numvowels < 3 || !doubleletter) {
      nice = false;
    }
    if (nice) {
      totalnice++;
    }
  }
  file.close();
  cout << "Total Nice: " << totalnice << endl;
  return totalnice;
}
