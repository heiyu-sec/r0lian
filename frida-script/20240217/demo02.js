function main(){
    Java.perform(function(){

       /* 
       //overload
        var TestThreadClass = Java.use("com.dta.demo13.TestThread")
        TestThreadClass.add.overload('java.lang.String', 'java.lang.String').implementation = function(arg1,arg2){
            printStack()
            console.log("the first arg is ==>"+arg1)
            console.log("the second arg is ==>"+arg2)
            var result = this.add(arg1,arg2)
            console.log("the result is ==>"+result)
            return result;
        }
        */
        

        /*
        //param edit
        Java.choose("com.dta.demo13.TestThread",{
            onMatch:function(instanse){
                // var result= instanse.add("10","11");
                var result= instanse.add(1,3);
                console.log("the result is ==>"+result)
            },
            onComplete:function(){

            }
        })
        */

        //static dynamic
        var result = Java.use("com.dta.demo13.TestThread").static_add("123","456")
        console.log("the result is ==>"+ result)

    })

    function printStack(){
        var ExceptionClass = Java.use("java.lang.Exception")
        var LogClass = Java.use("android.util.Log")
        console.log("----------------STACK--------------------")
        console.log(LogClass.getStackTraceString(ExceptionClass.$new()))
        console.log("----------------------------------------")
    }
}

setImmediate(main)