object Solution {
    def numberOfStableArrays(zero: Int, one: Int, limit: Int): Int = {
        val MOD = 1000000007L
        val dp = Array.ofDim[Long](zero + 1, one + 1, 2)

        for (i <- 1 to math.min(zero, limit)) {
            dp(i)(0)(0) = 1L
        }
        for (j <- 1 to math.min(one, limit)) {
            dp(0)(j)(1) = 1L
        }

        for (i <- 1 to zero; j <- 1 to one) {
            // Ending in 0
            dp(i)(j)(0) = (dp(i - 1)(j)(0) + dp(i - 1)(j)(1)) % MOD
            if (i > limit) {
                dp(i)(j)(0) = (dp(i)(j)(0) - dp(i - limit - 1)(j)(1) + MOD) % MOD
            }

            // Ending in 1
            dp(i)(j)(1) = (dp(i)(j - 1)(0) + dp(i)(j - 1)(1)) % MOD
            if (j > limit) {
                dp(i)(j)(1) = (dp(i)(j)(1) - dp(i)(j - limit - 1)(0) + MOD) % MOD
            }
        }

        ((dp(zero)(one)(0) + dp(zero)(one)(1)) % MOD).toInt
    }
}