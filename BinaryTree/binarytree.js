class Node{
    constructor(val){
        this.val = val;
        this.left= null;
        this.right = null;
    }
}

const a = new Node('a');
const b = new Node('b');
const c = new Node('c');
const d = new Node('d');
const e = new Node('e');
const f = new Node('f');

a.left = b;
a.right = c;
b.left = d;
b.right = e;
c.right = f;

const depthFirstSearch = (root) => {
    if (root == null) return [];
    const result = [];
    const stack = [root]; // add root to stack
    while(stack.length > 0){   //check stack isnt empty
        const current = stack.pop();  //grab irst element off the stack
       // console.log(current.val);  //print it
        result.push(current.val);

        if(current.right) stack.push(current.right); //recursive, so check right side
        if(current.left) stack.push(current.left); //then check left side and add to the

    }
    return result;
}

//console.log(depthFirstSearch(null));

const depthRecursive = (root) => {
    if (root === null){
        return [];
    }
    const leftValues = depthRecursive(root.left);
    const rightValues = depthRecursive(root.right);

    return [ root.val, ...leftValues, ...rightValues];
}

const breadthFirstSearch = (root) => {
    if(root === null) return null;
    const queue = [root] ;
    while(queue.length > 0){
        const current = queue.pop();
        console.log(current.val);
        if(current.left) queue.unshift(current.left);
        if(current.right) queue.unshift(current.right);
    }
   
}

//breadthFirstSearch(a);

const treeIncludesRecursive = (root, target) =>{
    if( root === null) return false;
    if(root.val === target) { return true; }
    return treeIncludesRecursive(root.left, target) || treeIncludesRecursive(root.right, target);
}
//console.log(treeIncludesRecursive(a, 'g'));

const treeIncludesDepth = ( root, val) => {
    if(root ===  null) { return false; }
    const stack = [ root ];
    while(stack.length > 0){
        const current = stack.pop();

        if( current.val === val){ return true; }

        if(current.right) { stack.push(current.right); }
        if(current.left) { stack.push(current.left); }

    }

    return false;

}
//console.log(treeIncludesDepth(b, 'd'));

const treeIncludesBreadth = (root, target) => {
    if(root === null) { return null; }

    const queue = [ root ];
    while(queue.length > 0){
        const current = queue.shift();
        if(current.val === target){ return true; }
    
        if(current.left) { queue.push(current.left); }
        if(current.right) { queue.push(current.right); }

    }
    return false;
}

//console.log(treeIncludesRecursive(a, 'g'));



const one = new Node(3);
const two = new Node(11);
const three = new Node(4);
const four = new Node(4);
const five = new Node(-2);
const six = new Node(1);

one.left = two;
one.right = three;
two.left = four;
two.right = five;
three.right = six;


const treeSumRecursive = (root) =>  {
    if(root === null){ return 0; }
    const sum = root.val;

    return sum + treeSumRecursive(root.left) + treeSumRecursive(root.right);
}

//console.log(treeSumRecursive(one));

const treeSumIterative = (root) => {
    if(root === null) return 0;
    let sum = 0;
    const stack = [root];
    while(stack.length > 0){      
        const current = stack.pop();
        sum += current.val;

        if(current.right){ stack.push(current.right); }
        if(current.left) { stack.push(current.left); }

    }

    return sum;
}

//console.log(treeSumIterative(null));

const treeSumBreadth = (root) => {
    if(root === null) { return 0; }
    let sum = 0;
    const queue = [ root ];
    while(queue.length > 0){
        const current = queue.shift();
        sum += current.val;

        if(current.left) { queue.push(current.left); }
        if(current.right) { queue.push(current.right); }
    }

    return sum;

}

//console.log(treeSumBreadth(one));

const treeMinDepth = (root) => {
    let currentMin = Infinity;
    const stack = [ root ];
    while(stack.length > 0){
        
    }


}

