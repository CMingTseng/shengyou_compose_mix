package io.kraftsman.compose.services

class LotteryService {
    fun generate(amount: Int = 49, take: Int = 6): List<Int> =
        (1..amount).shuffled().take(take)
}
