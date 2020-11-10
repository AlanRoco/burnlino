alias sources [] { pwd | path dirname | each { = `.:{{$it}}/cobolin/burnlino.jar` } }
alias try [arg1, arg2, arg3] { java -cp $(sources) "com.andrab.flares.cobolino.Main" $arg1 $arg2 $arg3 }

try echoValue '500'
try getTaxRateForState FL
try calculatePriceWithTaxRate '50' FL
