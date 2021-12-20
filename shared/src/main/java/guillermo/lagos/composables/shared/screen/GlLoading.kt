package guillermo.lagos.composables.shared.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.GlTextStyle
import guillermo.lagos.composables.shared.gradientBackground

@ExperimentalMaterialApi
@Composable
fun GlLoading(
    isLoading: Boolean = false,
    message: String,
    animation: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .gradientBackground(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val composition by rememberLottieComposition(
                LottieCompositionSpec.RawRes(animation)
            )

            val progress by animateLottieCompositionAsState(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                isPlaying = isLoading,
                speed = 1.5f,
                restartOnPlay = false
            )

            Text(
                text = message,
                style = GlTextStyle.titleLight,
                color = GlColors.Principal
            )

            LottieAnimation(
                composition,
                progress,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}