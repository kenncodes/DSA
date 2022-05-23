function mergeSort(arr){
    if(arr.length < 2) {
        return arr; //already sorted O(1) checking
    }

    const middleIndex = Math.floor(arr.length / 2);
    const leftArr = arr.slice(0, middleIndex);    //split in half = O(log(n))
    const rightArr = arr.slice(middleIndex,arr.length);

    return merge(mergeSort(leftArr), mergeSort(rightArr)); //while loop = O(n)

}

function merge(leftArr, rightArr) {
    //already sorted arrays of length 1
    let resultArr = [];
    let leftIndex = 0; //array 1 pointer
    let rightIndex = 0; //array 2 pointer

    while(leftIndex < leftArr.length && rightIndex < rightArr.length){
        if(leftArr[leftIndex] < rightArr[rightIndex]){
            resultArr.push(leftArr[leftIndex]);
            leftIndex+=1;
        }else{
            resultArr.push(rightArr[rightIndex]);
            rightIndex+=1;
        }
    }
    return resultArr.concat(leftArr.slice(leftIndex)).concat(rightArr.slice(rightIndex));

}

let arr = [12, 3, 16, 6, 5, 1];

console.log(mergeSort(arr));