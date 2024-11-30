package khoshi.amin.sqlite.view.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import dagger.hilt.android.AndroidEntryPoint
import khoshi.amin.sqlite.R
import khoshi.amin.sqlite.view.component.AddBookScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalTextApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val purple80 = Color(0xFFD0BCFF)
        val purpleGrey80 = Color(0xFFCCC2DC)
        val pink80 = Color(0xFFEFB8C8)
        val purple40 = Color(0xFF6650a4)
        val purpleGrey40 = Color(0xFF625b71)
        val pink40 = Color(0xFF7D5260)

        val darkColorScheme = darkColorScheme(
            primary = purple80,
            secondary = purpleGrey80,
            tertiary = pink80
        )
        val lightColorScheme = lightColorScheme(
            primary = purple40,
            secondary = purpleGrey40,
            tertiary = pink40
        )

        val fontFamily = FontFamily(
            Font(
                R.font.sahel_v,
                weight = FontWeight.W100,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(100))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W200,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(200))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W300,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(300))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W400,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(400))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W500,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(500))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W600,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(600))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W700,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(700))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W800,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(800))
            ),
            Font(
                R.font.sahel_v,
                weight = FontWeight.W900,
                style = FontStyle.Normal,
                variationSettings = FontVariation.Settings(FontVariation.weight(900))
            )
        )

        val defaultTypography = Typography()
        val typography = Typography(
            displayLarge = defaultTypography.displayLarge.copy(
                fontFamily = fontFamily
            ),
            displayMedium = defaultTypography.displayMedium.copy(
                fontFamily = fontFamily
            ),
            displaySmall = defaultTypography.displaySmall.copy(
                fontFamily = fontFamily
            ),
            headlineLarge = defaultTypography.headlineLarge.copy(
                fontFamily = fontFamily
            ),
            headlineMedium = defaultTypography.headlineMedium.copy(
                fontFamily = fontFamily
            ),
            headlineSmall = defaultTypography.headlineSmall.copy(
                fontFamily = fontFamily
            ),
            titleLarge = defaultTypography.titleLarge.copy(
                fontFamily = fontFamily
            ),
            titleMedium = defaultTypography.titleMedium.copy(
                fontFamily = fontFamily
            ),
            titleSmall = defaultTypography.titleSmall.copy(
                fontFamily = fontFamily
            ),
            bodyLarge = defaultTypography.bodyLarge.copy(
                fontFamily = fontFamily
            ),
            bodyMedium = defaultTypography.bodyMedium.copy(
                fontFamily = fontFamily
            ),
            bodySmall = defaultTypography.bodySmall.copy(
                fontFamily = fontFamily
            ),
            labelLarge = defaultTypography.labelLarge.copy(
                fontFamily = fontFamily
            ),
            labelMedium = defaultTypography.labelMedium.copy(
                fontFamily = fontFamily
            ),
            labelSmall = defaultTypography.labelSmall.copy(
                fontFamily = fontFamily
            )
        )

        val context = this.applicationContext
        val darkTheme = false
        val dynamicColor = false

        setContent {
            MaterialTheme(
                typography = typography,
                colorScheme = when {
                    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S ->
                        if (isSystemInDarkTheme() || darkTheme)
                            dynamicDarkColorScheme(context)
                        else
                            dynamicLightColorScheme(context)

                    darkTheme -> darkColorScheme

                    else -> lightColorScheme
                }
            ) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    graph = navController.createGraph(
                        startDestination = "profile"
                    ) {
                        composable(
                            route = "profile",
                        ) {
                            AddBookScreen(navController)
                        }
                    }
                )
            }
        }
    }
}