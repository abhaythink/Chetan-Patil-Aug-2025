
export default class User{
    
    constructor(name,age,gender)
    {
        this.name=name;
        this.age=age;
        this.gender=gender;
    }

}

export function printName(user)
{
    console.log(`users Name is :- ${user.name}`);

}

export function printGender(user)
{
    console.log(`user gender is :- ${user.gender}`);
}