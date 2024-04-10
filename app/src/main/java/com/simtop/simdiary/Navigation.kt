package com.simtop.simdiary

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    startDestination: String,
    navController: NavHostController
) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        homeRoute(
            navigateToDetailWithArgs = {
                navController.navigate(Screen.Detail.passDiaryId(diaryId = it))
            }
        )
        detailRoute(
            navigateBack = {
                navController.popBackStack()
            }
        )
    }
}

fun NavGraphBuilder.homeRoute(
    navigateToDetailWithArgs: (String) -> Unit
) {
    composable(route = Screen.Home.route) {
        HomeList("home", navigateToDetailWithArgs)
    }
}

fun NavGraphBuilder.detailRoute(
    navigateBack: () -> Unit
) {
    composable(route = Screen.Detail.route,
        arguments = listOf(navArgument(name = Constants.DETAIL_SCREEN_ARGUMENT_KEY) {
            type = NavType.StringType
        })) { backStackEntry->
        backStackEntry.arguments?.getString(Constants.DETAIL_SCREEN_ARGUMENT_KEY)
            ?.let { Detail(it, navigateBack) } ?: run { navigateBack.invoke() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeList(text: String, action: (String) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val lazyListState = rememberLazyListState()
    val numbers = remember {
        List(size = 70) { it }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("My App")
                },
                scrollBehavior = scrollBehavior
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { contentPadding ->
        LazyColumn(modifier = Modifier.padding(top = contentPadding.calculateTopPadding()), state = lazyListState) {
            items(items = numbers, key = { it }) {
                NumberHolder(it, action)
            }
        }

    }
}

@Composable
fun NumberHolder(number: Int, action: (String) -> Unit) {
    val context = LocalContext.current
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { action.invoke(number.toString())
                    Toast.makeText(context, "clicked", Toast.LENGTH_LONG).show()
                   }, verticalAlignment = Alignment.CenterVertically) {
        Text(text = number.toString(), style = TextStyle(fontSize = MaterialTheme.typography.titleLarge.fontSize, fontWeight = FontWeight.Bold))
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
fun Detail(text: String = "Hola", action: () -> Unit = {}) {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Detail Screen") }, navigationIcon = { Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "top app bar",
            modifier = Modifier.clickable { action.invoke() }
        )})
    }, modifier = Modifier.fillMaxSize()) { contentPadding->
        Surface(modifier = Modifier.background(color = Color.Red).fillMaxSize().padding(contentPadding)) {
            Column(
                modifier = Modifier.fillMaxSize().background(color = Color.Yellow),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = text, Modifier.clickable { action.invoke() }, color = Color.Blue)
            }
        }
    }
}