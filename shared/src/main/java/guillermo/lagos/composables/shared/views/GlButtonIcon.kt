package guillermo.lagos.composables.shared.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.GlProperties
import guillermo.lagos.composables.shared.GlShapes
import guillermo.lagos.composables.shared.noRippleClickable

@ExperimentalComposeUiApi
@Composable
fun GlButtonIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    iconColor: Color = GlColors.General,
    borderColor: Color = GlColors.General,
    backgroundColor: Color = GlColors.Principal,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.noRippleClickable(onClick = onClick),
        shape = GlProperties.shape,
        border = BorderStroke(
            width = 1.dp,
            color = borderColor
        ),
        color = backgroundColor
    ) {

        Column(
            modifier = Modifier
                .padding(9.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Icon(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = iconColor
            )
        }
    }
}