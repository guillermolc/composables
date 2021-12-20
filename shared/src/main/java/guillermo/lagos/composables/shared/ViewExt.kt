package guillermo.lagos.composables.shared

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import guillermo.lagos.composables.shared.GlColors

@ExperimentalComposeUiApi
@SuppressLint("UnnecessaryComposedModifier")
inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed {

    val keyController = LocalSoftwareKeyboardController.current

    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        keyController?.hide()
        onClick()
    }
}

fun Modifier.gradientBackground(
    colors: List<Color> = GlColors.GradientColors
) = this.background(
    brush = Brush.Companion.linearGradient(colors)
)