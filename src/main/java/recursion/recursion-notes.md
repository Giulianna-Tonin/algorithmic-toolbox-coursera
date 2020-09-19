1. Each recursive call should be on a smaller instance of
   the same problem, that is, a smaller subproblem.

2. The recursive calls must eventually
   reach a base case, which is solved without further recursion.

    private int recursive (n) {
        base case (1 ou mais)
        return recursive case (1 ou mais);
    };
    
 efficiency improves: memoization