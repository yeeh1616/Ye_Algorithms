/*
Cut a rope into m pieces, of which the lenght is n. Find the best of cutting the rope, which can get the max product of the length of these pieces.

For example, length n=8, the opt solution is product 2*3*3 = 18.

Key point:
1. Using dynamic programming,
2. There must be a table for store states of subproblem (a state is the optimal solution of each subproblem)
3. The state table must has a couple of init values, and the other solutions are calculated based on these values.
*/

/* Pseudo code:
1. Create a state table: product[]. product[n] is the solution.
2. Init product[] with length: 0, 1, 2, 3. product[0] = 0, product[1] = 0, product[2] = 1, product[3] = 2.
3. Then to calculate solution for length from 4 to n. Each length i can get the opt product based on the product from 0 to i-1.
*/

// ... init code emitted

for(int i = 4; i <= n; i++){
  max = 0;
  for(int j = 1; j <= i/2; j++){
    int product = product[j] * product[i-j];
    if(max < ){
      max = product;
    }
  }
}

return product[n];
