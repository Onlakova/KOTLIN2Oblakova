fun main() {
    print("Введите количество секунд: ")
    val sec = readln().toInt()
    println(agoToText(sec))
}

fun agoToText(sec: Int): String = when {
    sec <= 60 -> "был(а) только что"
    sec <= 60 * 60 -> "был(а) в сети ${minToText(sec / 60)} назад"
    sec <= 24 * 60 * 60 -> "был(а) в сети ${hoursToText(sec / 60 / 60)} назад"
    sec <= 2 * 24 * 60 * 60 -> "был(а) вчера"
    sec <= 3 * 24 * 60 * 60 -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun minToText(min: Int): String {
    val lastTwo = min % 100
    val last = min % 10
    val w = when {
        lastTwo in 11..14 -> "минут"
        last == 1 -> "минуту"
        last in 2..4 -> "минуты"
        else -> "минут"
    }
    return "$min $w"
}

fun hoursToText(hours: Int): String {
    val lastTwo = hours % 100
    val last = hours % 10
    val w = when {
        lastTwo in 11..14 -> "часов"
        last == 1 -> "час"
        last in 2..4 -> "часа"
        else -> "часов"
    }
    return "$hours $w"
}