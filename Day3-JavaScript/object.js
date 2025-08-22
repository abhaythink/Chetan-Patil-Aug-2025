
let person=
{
    firstName:'chetan',
    lastName:'patil',
    mobNo:'9764463690',

    fullName: function()
                {
                    return this.firstName+this.lastName
                },
    greet: function () {
        console.log('Hello, World!');
    } 
};

console.log(person);

//-------------------------------------------

//literal
let person1={
    firstName:'chetan',
    lastName:'Patil',
}

//Constructor
function Person2(first, last) {
  this.first = first;
  this.last = last;
}
let person2=new Person2('Sanjay','Patil');
console.log(person2);

//acess and modify 

console.log(person1.firstName);     // dot
console.log(person1['firstName']);   // bracket (dynamic key)

const key = 'firstName';

console.log(person1[key]);           // dynamic access

person1.firstName='Chetanp';
console.log(person1.firstName);      // modify

person1.mobNo='9764463690';         // add
console.log(person1.mobNo);

delete person1.mobNo;             //delete


//Nested objects

const company = 
{ 
    name: 'X', 
    ceo: { 
            name: 'Z'
         } 
};
console.log(company.ceo.name); 


