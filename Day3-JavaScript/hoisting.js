

console.log(a); // undefined 
var a = 5;
console.log(a); // 5


try {             //let and const
  console.log(b);
} catch (e) {
  console.log('Error:', e.message); 
}
let b = 10;
console.log(b); // 10


sayHello(); 
function sayHello() {
  console.log('Hello!');
}



try {
    fn(); 
} 
catch(e) 
{
    console.log('Error:', e.message);
}
var fn = function() { console.log('Now fn works'); };
fn(); 






