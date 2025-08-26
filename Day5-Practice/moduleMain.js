import User,{ printGender as genderPrint , printName as namePrint} from './moduleUser.js'


const userDetail= new User('Chetan',22,'Male');



namePrint(userDetail);
console.log("users name is printed ");


genderPrint(userDetail);
console.log("users gender is printed ");



