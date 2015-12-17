# USAGE:
#
# // to compile:
# make
# // remove compilation output files:
# make clean

# make variables let us avoid pasting these options in multiple places
CC = g++ 
CCFLAGS = -std=c++11 -Wall -Wextra -pedantic -O
#CCFLAGS = -std=c++11 -Wall -Wextra -pedantic -g -O

bin: driver

driver.o: driver.cc
	$(CC) $(CCFLAGS) -c driver.cc

driver: driver.o
	$(CC) $(CCFLAGS) -o driver driver.o

clean: 
	rm -f *.o driver *# *~ *.exe *.gcov *.gcda *.gcno tmp/*
