package io.kraftsman.compose.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.kraftsman.compose.ui.components.Ball
import io.kraftsman.compose.ui.components.LotteryBoard

@Preview(showBackground = true)
@Composable
fun BallPreview() {
    MaterialTheme {
        Ball(
            displayNumber = 1,
            lotteryNumbers = listOf(1, 2, 3, 4, 5, 6)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LotteryBoardPreview() {
    MaterialTheme {
        LotteryBoard()
    }
}