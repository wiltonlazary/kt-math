import java.math.*

fun main() {
    var x = BigInteger.valueOf(Long.MAX_VALUE)
    println(x)
    x = x.multiply(BigInteger.valueOf(Long.MAX_VALUE))
    println(x)
}