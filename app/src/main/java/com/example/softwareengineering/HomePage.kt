package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun HomePage(
    questViewModel: QuestViewModel = viewModel()
) {
    val uiState by questViewModel.uiState.collectAsState()
    // Background
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_page),
            contentDescription = "background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
    }

    Column(
        modifier = Modifier
            .padding(18.dp)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 32.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 56.dp))

        ProfileIcon(uiState.coins)

        Spacer(modifier = Modifier.padding(top = 35.dp))

        Greeting()
        CoinCard()

        Spacer(modifier = Modifier.padding(top = 35.dp))

        EventGreeting()
        Spacer(modifier = Modifier.padding(bottom = 10.dp))
        EventCard()

        Spacer(modifier = Modifier.padding(top = 35.dp))

        TipsGreeting()
        Spacer(modifier = Modifier.padding(top = 10.dp))
        TipsOne()
        Spacer(modifier = Modifier.padding(top = 10.dp))
        TipsTwo()
        Spacer(modifier = Modifier.padding(top = 10.dp))
        TipsThree()

        Spacer(modifier = Modifier.padding(top = 35.dp))

        QuestGreeting()
        Spacer(modifier = Modifier.padding(top = 10.dp))
        QuestCard()

        Spacer(modifier = Modifier.padding(top = 100.dp))
    }
}