
const fs=require('fs');


const requestHandler=(req,res)=>{

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

}

module.exports = requestHandler;






