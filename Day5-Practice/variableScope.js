
if(true)
{
    var myName="Chetan Patil";
}

//var myName="chetan"; // this allow in case of var redeclaration allow


console.log("My Name :-  "+myName);


if(true)
{
    let myName1='Chetan Patil';
}

//let myName1='chetan';// here not allowed// let not allowed to redeclare 

console.log('pring my name via let keyword '+myName); //unrefference error // let has block scope


console.log(age); // undefined is printed 
var age=22;



//console.log(age1); // unferrence error is occur // 
//let age1=22;

const age2=22;
age2=23;            //TypeError
console.log(age2);



