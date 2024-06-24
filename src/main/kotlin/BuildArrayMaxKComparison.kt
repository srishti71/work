class BuildArrayMaxKComparison {
    fun numOfArrays(n: Int, m: Int, k: Int): Int {
        val dp = Array(n + 1) { Array(k + 1) { IntArray(m + 1) { -1 } } }

        for(i in 0 .. m) {
            dp[0][0][i] = 1
        }

        for(i in 1 .. k) {
            for(j in 0 .. m) {
                dp[0][i][j] = 0
            }
        }

        for(i in 1 .. n) {
            for(j in 0 .. k) {
                for(p in 0 .. m) {
                    var res = 0
                    res = (res + dp[i-1][j][p] * p)  % 1000000007
                    if(j > 0)
                        for(q in p+1 .. m) res = (res + dp[i-1][j-1][q]) % 1000000007
                    dp[i][j][p] = res
                }
            }
        }

        return dp[n][m][0]
    }
}

fun main() {
    val n = 2
    val m = 3
    val k = 1
    val buildArrayMaxKComparison = BuildArrayMaxKComparison()
    println("result: ${buildArrayMaxKComparison.numOfArrays(n, m, k)}")
}