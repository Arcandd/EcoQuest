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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

//@Preview(showBackground = true)
@Composable
fun ProfilePage(
    viewModel: MainViewModel
) {
    // Background
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_page),
            contentDescription = "background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
    }

    // Back button
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 20.dp, top = 44.dp)
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.back),
//            contentDescription = "Back",
//            modifier = Modifier.size(29.dp, 24.dp),
//            contentScale = ContentScale.FillBounds
//        )
//    }

    // Content
    Column(
        modifier = Modifier
            .padding()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 72.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 85.dp))

        ProfilePageProfileInfo()

        Spacer(modifier = Modifier.padding(top = 28.dp))

        ProfilePageProfileSettings(viewModel = viewModel)
    }
}