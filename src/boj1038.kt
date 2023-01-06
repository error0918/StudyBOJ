/*data class Result(
    val count: Int, // 남은 count
    val digit: Int, // 자리수
    val big: Int // 자리수에 있는 수
)

fun main() {
    //val index = readln().toInt() + 1
for (index in 1..100) {
    println()
    println()
    var result = ""

    var lastResult = Result(
        count = index,
        digit = -1,
        big = 0
    )

    loop@ while (true) {
        val thisResult = getDcDgNb(lastResult.count, lastResult.digit - 1)

        println("$lastResult  $thisResult")
        if (lastResult.digit > thisResult.digit + 1 && thisResult.digit == 1) println("fuck");

        result += thisResult.big

        if (thisResult.digit == 1 || thisResult.count <= 0) break@loop

        lastResult = thisResult
    }

    println("${index-1} $result")
}
}

// 감소하는 수의 N 자리에 있을 숫자 찾기
fun getDcDgNb(count: Int, beforeDigit: Int = 0): Result { // 숫자 to 남은 카운트
    var calcCount = 0

    var lastDigit = 0
    var lastBig = 0

    digitLoop@ for (digit in 1..10) {
        for (big in 0..9) {
            calcCount += getDcNbNumber(digit, big)
            if (calcCount >= count) {
                lastDigit = digit
                lastBig = big
                break@digitLoop
            }
        }
    }

    val lastCount = calcCount - getDcNbNumber(lastDigit, lastBig)

    if (count == 0) { // 입력값이 0인 경우
        return Result(
            count = 0,
            digit = beforeDigit - 1,
            big = 0
        )
    } else if (lastDigit == 0 && lastDigit == 0) { // 한계값을 넘은 경우
        return Result(
            count = 0,
            digit = 1,
            big = -1
        )
    } else if (calcCount == count) { // 정확한 부분에서 끝난 경우 (ex: 19)
        return Result(
            count = count - lastCount,
            digit =lastDigit,
            big = lastBig
        )
    } else { // 정확한 부분을 넘어서 끝난 경우
        return Result(
            count = count - lastCount,
            digit = lastDigit,
            big = lastBig
        )
    }
}


// 감소하는 수의 개수 찾기
// 즉 a1부터 a(가장큰수 - 자리수 + 2)까지의 합은 (자리수 - 2) * (가장큰수 - 자리수 + 2) * (가장큰수 - 자리수 + 2 + 1) / 2 + (가장큰수 - 자리수 + 2) * (- 자리수 + 3)
// an = 1 + (n - 1) * (자리수 - 2) = (자리수 - 2) * n - 자리수 + 3
// 시작이 1이고, 공차가 (자리수 - 2)인 공차수열의 1부터 (가장큰수 - 자리수 + 2)까지의 합
fun getDcNbNumber(digit: Int, big: Int) =
    if (big < digit - 2 || digit == 0 ) 0
    else if (digit == 1) 1
    else (digit - 2) * (big - digit + 2) * (big - digit + 3) / 2 + (big - digit + 2) * (-digit + 3)

*/