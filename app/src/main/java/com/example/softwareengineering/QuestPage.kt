package com.example.softwareengineering

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

@Composable
fun QuestPage() {
    PreviewQuestPage()
}

@Composable
private fun PreviewQuestPage(
    questViewModel: QuestViewModel = viewModel()
) {
    val uiState by questViewModel.uiState.collectAsState()
    // Background
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.quest_page_background),
            contentDescription = "background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .padding(18.dp)
                .verticalScroll(rememberScrollState())
                .padding(bottom = 125.dp)
        ) {
            Spacer(modifier = Modifier.padding(top = 56.dp))

            ProfileIcon(uiState.coins)

            Spacer(modifier = Modifier.padding(top = 32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chest),
                    contentDescription = "Chest",
                    modifier = Modifier.size(92.dp, 95.dp),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            QuestProgressBar(uiState.progress)

            Spacer(modifier = Modifier.padding(top = 32.dp))

            QuestPageDaily(
                onButtonClicked = {amount, coins ->
                    questViewModel.addProgress(amount, coins)
                }
            )

            Spacer(modifier = Modifier.padding(top = 43.dp))

            QuestPageWeekly(
                onButtonClicked = {amount, coins ->
                    questViewModel.addProgress(amount, coins)
                }
            )

            Spacer(modifier = Modifier.padding(top = 43.dp))

            QuestPageMonthly(
                onButtonClicked = {amount, coins ->
                    questViewModel.addProgress(amount, coins)
                }
            )
        }
    }
}