

function helloFun(name) 
{
  return "Hello " + name;
}

//arrow function

let helloFunArrow=(name)=>
{
    console.log("this is an arrow function");

}


//single parameter function ...so they dont required parenthesis

let  helloFunArrow2=mes=> {
    console.log(mes)
}

let returnValue=(a,b)=> a+b    // single line function and return implicitly

const getUser = () => ({ name: "Chetan", age: 22 });  // return object with parenthesis

console.log(getUser());

//---------------

const numArr=[3,4,5,6,7,8];

const doubleNumArr=numArr.map(item=>item+item);  //double the value of array
console.log(doubleNumArr);



// this behave with normal function and arrow function

let user={
    name:"chetan",
    normFun: function(){         // this function execute because this refferece to the current object
         console.log('this is users Name : ',this.name);
    },
    arrowFun:()=>{
        console.log('this is users Name : ',this.name);     //function throw undefined error because they they "this" from the outside
    }
}

user.normFun();
user.arrowFun();// undefined 


// arrow function and argument 

function normFun(a,b)
{
    console.log(arguments);
}

normFun(12,42);

let arrowFun = (a,b) => {   
    console.log(arguments)  // arrow function does not have argument object
}
arrowFun();






