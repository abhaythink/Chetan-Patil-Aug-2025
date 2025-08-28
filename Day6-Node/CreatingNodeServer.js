

const http= require('http');  //here we are importing the module for the http //...............................................

const server= http.createServer((req,res)=>{        //http://localhost:3000 this function is execute 

    console.log("here http server is running")
    console.log("Printing the Request object which came from the browers ", );
    console.log("It run every time can http request is hit")
    console.log("-----------------------")
})

server.listen(3000,()=>{
    console.log("Server is running on port 3000")
    console.log("this run every time when server is run")
    console.log("-----------------------")
});   // actively running and listening brower request// after hitting 





// understand the requist  //requist//..............................................................................

const server1= http.createServer((req,res)=>{  
    
    console.log("running this from another server")
    console.log(req.method,req.url, ) 
    console.log("-----------------------")
    
})
server1.listen(3001,()=>{
    console.log("This is another server 2");
    console.log("-----------------------")
})





//sending the response //............................................................................................

const server3= http.createServer((req,res)=>{  
    
    console.log("running this from another server 3")
    //console.log(req.method,req.url, ) 
    res.setHeader('Content-Type','text/html');

    res.write('<html>');
    res.write('<head><title>html contain return on the page</title></head>');
    res.write('<body><h1>This is html content via response object </h1></body>');
    res.write('</html>');
    res.end();
    console.log("-----------------------")

})

server3.listen(3002,()=>{
    console.log("This is another server 3 is Running on the port 3002");
    console.log("it is for returning response via html")
    console.log("-----------------------")
})



// getting and returning the data via different urls


const fs=require('fs');

const server4= http.createServer((req,res)=>{  

    console.log("running this from another server 4")
    const url=req.url;
    const method=req.method;
    if(url==='/')
    {
         res.write('<html>');
        res.write('<head><title>Form displays via default </title></head>');
        res.write('<body><h1>fill the form </h1>');
        res.write('<form action="/mes" method="POST" ><input type="text" name="mes"><button type="submit">Submit</button>');
        res.write('</body>');
        res.write('</html>');
        return res.end();
    }

    if(url==='/mes' && method==='POST')
    {
        fs.writeFileSync('mes.txt',"in this file contain tempary data which is for pratices");
        res.statusCode=302;
        res.setHeader('Location','/')
        return res.end();
    }
    
    //console.log(req.method,req.url, ) 
    res.setHeader('Content-Type','text/html');

    res.write('<html>');
    res.write('<head><title> html contain return on the page</title></head>');
    res.write('<body><h1>This is html content via response object </h1></body>');
    res.write('</html>');
    res.end();
    console.log("-----------------------")

})



server4.listen(3003,()=>{
    console.log("This is another server 4 is Running on the port 3002");
    console.log("get requist via url and return form")
    console.log("-----------------------")
})










const server5= http.createServer((req,res)=>{  

    console.log("running this from another server 5")
    const url=req.url;
    const method=req.method;
    if(url==='/')
    {
         res.write('<html>');
        res.write('<head><title>Form displays via default </title></head>');
        res.write('<body><h1>fill the form </h1>');
        res.write('<form action="/mes" method="POST" ><input type="text" name="mes"><button type="submit">Submit</button>');
        res.write('</body>');
        res.write('</html>');
        return res.end();
    }

     if(url==='/mes' && method==='POST')
    {
        const body1=[];
        req.on("data", (chunk)=>{
            console.log(chunk);
            body1.push(chunk);
        });
        req.on("end",()=>{
            const parsedBody=Buffer.concat(body1).toString();
            const mes=parsedBody.split("=")[1];
            fs.writeFileSync('mes.txt',mes);
        })

        res.statusCode=302;
        res.setHeader('Location','/')
        return res.end();
    }

    
    //console.log(req.method,req.url, ) 
    res.setHeader('Content-Type','text/html');

    res.write('<html>');
    res.write('<head><title> html contain return on the page</title></head>');
    res.write('<body><h1>This is html content via response object </h1></body>');
    res.write('</html>');
    res.end();
    console.log("-----------------------")

})



server5.listen(3004,()=>{
    console.log("This is another server 5 is Running on the port 3002");
    console.log("get requist via url and return form")
    console.log("-----------------------")
})

