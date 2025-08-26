
let userLogin=true;

let userLogin1={
    name:'Chetan',
    status:true
};
let UserLogout=false;




function checkUserLoginStatus( callback, errorCallback)
{

    if(userLogin==true && UserLogout==false)
    {
        callback("User is Login");
    }
    else
    {
        errorCallback({
            name:'chetan',
            message:' name user is not login'
        })
    }

}

checkUserLoginStatus((message)=>{
    console.log(message);
},(error)=>{
    console.log(error.name+" "+error.message);
});




//here i have to used promise for this same code 


function checkUserLoginStatusPromise()
{
    return new Promise((resolve,reject)=>{

        if(userLogin==true)
        {
            resolve("User is Logined");
        }
        else
        {
            reject({
                 name:'chetan',
                message:' name user is not login'
            });
        }

    })
}

let promise1=checkUserLoginStatusPromise();

promise1.then((message)=>{
    console.log(message);
}).catch((error)=>{
    console.log(error.name+" "+error.message);
})


// run all promise at once via .all method


const promise_1 = new Promise((resolve, reject) => {

    reject('Promise 1 is resolve ');
});
const promise_2 = new Promise((resolve, reject) => { 

    resolve('Promise 2 is resolve ');
});

const  promise_3 = new Promise((resolve, reject) => {

    resolve('Promise 3 is resolve ');
})

Promise.all([promise_1,promise_2,promise_3])
.then((message)=>{                      //if all promise are resolve then and then this block is run// if one of reject then catch block is executated

    console.log(message);
}
).catch((error)=>{

    console.log(error);
});


//race

Promise.race([promise_1,promise_2,promise_3]) //it return single message insted of all when all are resolve //return first
.then((message)=>{                      

    console.log(message);
}
).catch((error)=>{

    console.log(error);
});