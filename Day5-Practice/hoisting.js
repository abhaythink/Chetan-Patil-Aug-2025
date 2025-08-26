


//here we can call normal function before we define it.// because hole function is hoisted
sayHelloToUser();

function sayHelloToUser()
{
    return "Hello, User ";
}


//here we can't call this method before they defined// variable is hoisted but in TDZ but not hole function
//sayHelloToUser1();

let sayHelloToUser1= ()=>{

    return "Hello User from Arrow";
}

//console.log(sayHelloToUser);
console.log(sayHelloToUser1());

//



//
sayHelloToUser2();  // TypeError: sayHello is not a function  // sayHelloToUser2 variable is hoisted but assign undefined value 

var sayHelloToUser2 = function() {
  console.log("Hello from var expression");
};

sayHelloToUser3(); // ReferenceError //ReferenceError: Cannot access 'sayHelloToUser3' before initialization

const sayHelloToUser3 = () => {
    console.log("Hello User from ");
}







