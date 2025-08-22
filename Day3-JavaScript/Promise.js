// let p= new Promise((resolve,reject)=>{
//     let i=1;
//     let j=2;
//     let add=i+j;

//     if(add==4)
//     {
//         resolve("success")
//     }
//     else
//     {
//         reject("unsuccssful");
//     }

// })

// p.then((message)=>{
//     console.log("this is successful ");
// }).catch((message)=>{
//     console.log("this is unsucessful");
// })



// const A= new Promise((resolve, reject)=>
// {
//     setTimeout(()=> resolve('done'),1000)
// }
// )

// A.then(value => console.log(value));


const getPromise=()=>{
    return new Promise((resolve,reject)=>
    {
        console.log("i am promise");

        //resolve("success")
        reject('unsuccessful');
    });
};

// let promise=getPromise();

// promise.then(()=> {
//     console.log("promise is fulfilled");
// })

// promise.catch(()=>console.log("error"));

//--------------------/// fatching data parallel
function asyncFunc()
{
    return new Promise((resolve,reject)=>{

        setTimeout(()=>{
            console.log("data1");
            resolve("sucess")
        },5000);
    });
}

function asyncFunc1()
{
    return new Promise((resolve,reject)=>{

        setTimeout(()=>{
            console.log("data2");
            resolve("sucess1")
        },5000);
    });
}

// console.log("fetching data...");
// let p1=asyncFunc();
// p1.then((res)=> {
//     console.log(res); 
// })

// console.log("fetching data...");
// let p2=asyncFunc();
// p2.then((res)=> {
//     console.log(res);
// })

//----------------------------------------------

//fatching data one by one not parallel


// console.log("fetching data1...");
// let p1=asyncFunc();
// p1.then((res)=> {
//     console.log(res); 
//     console.log("fetching data...");
//     let p2=asyncFunc();
//     p2.then((res)=> {
//         console.log(res);
//     })
// })


//callback hell


function getData(dataId,getNextData)
{
    return new Promise((resolve,reject)=>{
       
        setTimeout(()=>
        {
            console.log("data ",dataId);
            resolve("success");
            if(getNextData)
            {
                getNextData();
            }
        },2000);
    });
}


getData(1, ()=>{
    console.log("getting data2 ... ");
    getData(2,()=> {
        console.log("getting data 3...")
        getData(3,()=>{
            console.log("getting data4...")
            getData(4);
        });
    });

});

//promise... code
getData(1)
    .then((res)=>
    {
        return getData(2);
    })
    .then((res)=>
    {
        return getData(3);
    }).then((res)=>{
        console.log(res);
    })

                             