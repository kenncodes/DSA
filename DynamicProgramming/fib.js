const fib = (n, memo = {}) => {
    if(n in memo) return memo[n]; //check if value in memo using key - no need to recalculate
    if (n <= 2) return 1; //base case
    memo[n] = fib(n - 1, memo) + fib(n - 2, memo); //add it to memo
    return memo[n]; //return the  function
}



const dpFib = (n, args = {}) => {
    //recursion and reuse

    if (n in args) { return args[n];}
    if (n <= 2) { return 1; } 
    args[n] = dpFib(n-1, args) + dpFib(n - 2,args);
    console.log(args)
    return args[n];
}

console.log(fib(5));
console.log(dpFib(5));



