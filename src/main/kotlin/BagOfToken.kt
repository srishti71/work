class BagOfToken {
}

fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    var l = 0
    var r = tokens.size - 1

    tokens.sort()
    var score = 0
    var currPower = power

    while (l <= r) {
        if (score == 0) {
            if (currPower < tokens[l]) return score
            currPower -= tokens[l]
            l++
            score++
            continue
        }
        if (currPower >= tokens[l]) {
            currPower -= tokens[l]
            l++
            score++
        } else {
            if(r > l) {
                currPower += tokens[r]
                r--
                score--
            } else {
                return score
            }
        }
    }
    return score

}

fun main() {
    bagOfTokensScore(intArrayOf(26), 51)
}