package basicQuestion

fun main() {
    print("Enter the number of terms: ")
    val n = readLine()?.toIntOrNull() ?: return

    var a = 0
    var b = 1
    print("Fibonacci Series: $a, $b")
    for (i in 3.. n){
        var  sum  = a+b
        print(", $sum")
    a=b
    b=sum
    }




}