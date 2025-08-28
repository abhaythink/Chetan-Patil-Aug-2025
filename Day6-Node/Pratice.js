const { log } = require("console");


const array=["Hello",32,"Chetan",95,{name:'CHetan',age:23}];

for(let item of array)
{
    console.log(item);
}

//console.log(array['name']);

console.log(array[4].name);

let newArray= array.map((item)=>{
    return "Hello "+item;
})

//console.log(newArray);

console.log(array.push("last"));
console.log(array);

console.log(array.pop());

//spred and rest operator

//----------------------

const array_1=[array];

//spread operator//

console.log(array_1);   // this will create new array with 1 element as old array(nested array );
console.log(...array_1);  // destructaring the array from single to all element present in it       //spread operator

const array_2=[...array];
console.log(array_2);

//console.log("this is rest operator");

//rest operator:- it opposite of spread operator 


const returnArgumentInArray=(...restOpe)=>{
  // rest operator is used for combining the spreaded values
    return restOpe;
}

console.log(returnArgumentInArray(12,13,14));


//console,log("this is demonstraction of rest operator :- ",arrayRestOperator);



//normal flow
const user={
    name:'chetan',
    age:22,
    sayHello:function(){
        console.log("Hello "+this.name);
    }
}
let printName=(user)=>
{
    console.log("The name of the User is ",user.name);
}
//object Destructuring //object destructuring is anothing but unpacked the value from the array or object
printName(user);

let printName_De=({name})=>
{
    console.log("The name of the User is via Destructuring",name);
}
printName_De(user);

//
const {name,age}=user;    // they match the propertices name  

console.log(name+" "+age)

const array11=["Chetan1","Patil1"];

const [name1,sirname1]=array11;  // you can change name 

console.log(name1+" "+sirname1);


