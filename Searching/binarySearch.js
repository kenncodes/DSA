const { getSystemErrorMap } = require("util");

let arr = [1,2,3,4,5,6,7,8];
let start = 0;
let end = arr.length - 1;
let target = 9;

function binarySearch(arr, start, end, target){
    //base case
    if(start > end) return false;

    //find the midpoint
    let mid = Math.floor((start+end)/2)

    if(arr[mid] === target){
        console.log("index: " ,mid);
        return true;
    }
    if(arr[mid] > target){
        //target is on the right side
       // console.log(arr[mid],arr[end]);
        return binarySearch(arr, start, mid -1, target);
    }else{
        return binarySearch(arr, mid+1, end, target);
    }


}

console.log(binarySearch(arr, start,end, target));