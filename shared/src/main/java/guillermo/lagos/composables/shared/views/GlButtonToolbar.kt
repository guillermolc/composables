package guillermo.lagos.composables.shared.views

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.noRippleClickable

@ExperimentalComposeUiApi
@Composable
fun GlButtonToolbar(
    modifier: Modifier = Modifier,
    icon: Int,
    iconColor: Color = GlColors.Principal,
    onClick: () -> Unit
) {
    Icon(
        modifier = modifier.noRippleClickable(onClick = onClick)
            .size(20.dp),
        painter = painterResource(id = icon),
        contentDescription = null,
        tint = iconColor
    )
}