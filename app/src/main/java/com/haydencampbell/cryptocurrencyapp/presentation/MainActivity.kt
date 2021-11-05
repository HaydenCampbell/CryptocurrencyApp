package com.haydencampbell.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haydencampbell.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import com.haydencampbell.cryptocurrencyapp.presentation.coin_list.CoinListScreen
import com.haydencampbell.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var canPop by remember { mutableStateOf(false) }
            val navController = rememberNavController()
            val baseTitle = "" // stringResource(id = R.string.app_name)
            val (title, setTitle) = remember { mutableStateOf(baseTitle) }

            navController.addOnDestinationChangedListener { controller, _, _ ->
                canPop = controller.previousBackStackEntry != null
            }

            val navigationIcon: (@Composable () -> Unit)? =
                if (canPop) {
                    {

                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    }
                } else {
                    null
                }

            CryptocurrencyAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = title) },
                            elevation = 8.dp,
                            navigationIcon = navigationIcon,

                            )
                    },
                    content = {
                        Surface(color = MaterialTheme.colors.background) {
                            NavHost(
                                navController = navController,
                                startDestination = Screen.CoinListScreen.route
                            ) {
                                composable(
                                    route = Screen.CoinListScreen.route
                                ) {
                                    CoinListScreen(navController, setTitle = setTitle)
                                }
                                composable(
                                    route = Screen.CoinDetailScreen.route + "/{coinId}" + "/{coinName}"
                                ) {
                                    CoinDetailScreen(setTitle = setTitle)
                                }
                            }
                        }
                    }
                )
            }
        }
    }


}