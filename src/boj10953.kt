fun main() {
    repeat(readln().toInt()) {
        println(readln().split(",").sumOf { it.toInt() })
    }
}