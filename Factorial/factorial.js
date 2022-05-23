function f(n) {
    if(n === 0){
        console.log("********")
        return
    }
    for(let i=0; i< n; i++){
        f(n-1);
    }
}

f(2);