# JavaCommandLineCheckers
This is a game of checkers, written in pure java for playing in the command terminal. 
This was written for my final project in Beginner Java. 

The board is marked with numbers on the side and top.

To make a standard move, first type you pieces coordinates separate those by a space, and then type your destination
coordinates.
Example input: 

  0 1 2 3 4 5 6 7 
0 x   x   x   x   
1   x   x   x   x 
2 x   x   x   x   
3                 
4                 
5   o   o   o   o 
6 o   o   o   o   
7   o   o   o   o 

"51 42"

Result:

  0 1 2 3 4 5 6 7 
0 x   x   x   x   
1   x   x   x   x 
2 x   x   x   x   
3                 
4     o           
5       o   o   o 
6 o   o   o   o   
7   o   o   o   o 

To make a jump move, the principle is the same. Type your pieces coordinates, then your destination coordinates.

Example input:

  0 1 2 3 4 5 6 7 
0 x   x   x   x   
1   x   x   x     
2 x   x   x   x   
3                 
4     o   o   x   
5   o   o       o 
6     o   o   o   
7   o   o   o   o 

"57 35"

Result:

  0 1 2 3 4 5 6 7 
0 x   x   x   x   
1   x   x   x     
2 x   x   x   x   
3           o     
4     o   o       
5   o   o         
6     o   o   o   
7   o   o   o   o 


## Enjoy!
