#include <iostream>
#include <string>
#include <stdio.h>
#include <stdlib.h>
#include <fstream>
#include <vector>
#include <algorithm>

using std::string;
using std::cout;
using std::endl;
using std::ifstream;
using std::vector;
using std::find;

int main(int argc, char** argv) {
  int totalnice = 0;
  ifstream file;
  file.open(argv[1]);
  string input;
  while (getline(file, input)) {
    bool pairappearstwice = false;
    bool repeatwithbuffer = false;
    char prev = ' '; //overwrite
    char prev2 = ' ';
    bool nice = true;
    vector<string> pairs; //holds all pairs of letters
    int numsuccessfulpairs = 0;
    for (int j = 0; j < input.length(); j++) { //go through all characters
      char curr = input.at(j);
      string currpair = "";
      if (prev != ' ') {
	currpair += prev;
	currpair += curr;
	//Now check if the pair already exists
	if (find(pairs.begin(), pairs.end(), currpair) != pairs.end()) {
	  numsuccessfulpairs++;
	} else {
	  //Add pair into log
	  pairs.push_back(currpair);
	}
      }
      //Now check prev2 cases
      if (prev2 != ' ') {
	if (prev2 == curr) {
	  repeatwithbuffer = true;
	}
	if (prev2 == prev && prev == curr) { //three in a row
	  numsuccessfulpairs--; //was not successful
	}
      }
      //reassign
      prev2 = prev;
      prev = curr;
    }
    if (numsuccessfulpairs > 0) {
      pairappearstwice = true;
    }
    if ((!pairappearstwice || !repeatwithbuffer) && nice) {
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
