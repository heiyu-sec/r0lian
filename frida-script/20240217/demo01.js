function main(){
    Java.perform(function(){
       
        var TestThreadClass = Java.use("com.dta.demo13.TestThread")
        TestThreadClass.add.overload('int','int').implementation = function(arg1,arg2){
            printStack()
            arg1=2;
            arg2=5;
            console.log("the first arg is ==>"+arg1)
            console.log("the second arg is ==>"+arg2)
            var result = this.add(arg1,arg2)
            console.log("the result is ==>"+result)
            return result;
        }

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