/*
Input a number n, count how many one it has in its binary form.

Solution 1: shift right n, and do 'and op' with 1. Problem: if n is negative it will cause endless loop.
Solution 2: shift left 1, and do 'and op' with n. Solve endless loop. Problem: loop 32 times.
Solution 3: n = (n-1)&n. Loop times equals with the ones in n. No problems.
*/
