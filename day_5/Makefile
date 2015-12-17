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

bin: driver driver2

driver.o: driver.cc
	$(CC) $(CCFLAGS) -c driver.cc

driver2.o: driver2.cc
	$(CC) $(CCFLAGS) -c driver2.cc

driver: driver.o
	$(CC) $(CCFLAGS) -o driver driver.o

driver2: driver2.o
	$(CC) $(CCFLAGS) -o driver2 driver2.o

clean: 
	rm -f *.o driver driver2 *# *~ *.exe
