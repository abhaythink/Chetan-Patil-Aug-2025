const users=[
    {
        id: 1,
        name:'Chetan',
        age:22
    },
    {
        id: 2,
        name:'Pallavi',
        age:22
    },
    {
        id: 3,
        name:'Shital',
        age:27
    }

];

//get array which having age less than 25

const youngUser = users.filter((items) => {
    
    return items.age <= 25;
});


console.log("New array is :- ",youngUser)

//get array of name from users;

const userName=users.map( (items)=>{
    return items.name;
});

console.log("Name in Users Array objects" ,userName)

// find the object which has name is chetan 

const chetanObj=users.find((items)=>{   //return first item which they found in array

    return items.name==='Chetan';
})

console.log("User which having name Chetan ",chetanObj);


//foreach

users.forEach((items)=>{    //for each does not return anything... it modify original value// or perform some operation of that item

    console.log(" Object :- ",items);

})


//some:- which result true or false value // if condiction (some ) is true 

const isUserIsGreaterThan25=users.some((items)=>{

    return items.age>=25;
})

console.log("is Having user is greater than 25 ",isUserIsGreaterThan25);

//every:- it check all meet the condition than it return true otherwise it return false

const isEveryUserHasAgeGreaterthan25=users.some((items)=>{

    return items.age>=25;
})

console.log("is every user has age is greater than 25 :- ",isEveryUserHasAgeGreaterthan25);



// we want to find the avarage age of users  //reduce

const ageTotal=users.reduce((currentSum,items)=>{

    currentSum=currentSum+items.age; // first find the total age of users
    return currentSum;
},0)

console.log(" the total age of the users  ",ageTotal);

const avarageAge=ageTotal/users.length;
console.log("Average Age of the users is :- ",avarageAge);



//include 
let arr2=[25,23,27];

const isIncludeInIt=arr2.includes(23);

console.log("is array contain the element 23 :- ",isIncludeInIt);