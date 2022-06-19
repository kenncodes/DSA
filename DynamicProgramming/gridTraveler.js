const gridTraveler = (m,n, memo = {}) => {
    //using a string
    const key = m + "," + n;

    if(key in memo ) return memo[key]; //are the args in memo?
    if( m === 1 && n === 1) { return 1; } //base case
    if( m === 0 || n === 0){ return 0; } //base case

    memo[key] = gridTraveler(m-1,n, memo) + gridTraveler(m,n-1,memo); //recursion & pass by reference memo
    return memo[key];
}

console.log(gridTraveler(1,1));
console.log(gridTraveler(2,3));
console.log(gridTraveler(3,2));
console.log(gridTraveler(3,3));
console.log(gridTraveler(18,18));


//Memoization
/* 
1. Make it work
    - Visualize the problem as a tree
    - Implement the tree using recursion
    - Test it

2. Make it efficient
    - add a memo object
    - add a base case to return memo values
    - store reutrn values into the memo
    */