package guillermo.lagos.composables.shared.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.*


@ExperimentalComposeUiApi
@Composable
fun GlButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = GlColors.Principal,
    icon: Int? = null,
    iconColor: Color = GlColors.Principal,
    borderColor: Color = GlColors.General,
    backgroundColor: Color = GlColors.General,
    enable: Boolean = true,
    onClick: () -> Unit
) {

    val emptyOnclick = {}

    val alpha = 0.5f

    Surface(
        modifier = modifier.noRippleClickable(onClick = if (enable) onClick else emptyOnclick),
        shape = GlProperties.shape,
        border = BorderStroke(
            width = 1.dp,
            color = if (enable) borderColor else borderColor.copy(alpha = alpha)
        ),
        color = if (enable) backgroundColor else backgroundColor.copy(alpha = alpha)
    ) {

        Row(
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            Text(
                modifier = if (icon != null) Modifier.weight(1f) else Modifier,
                text = text,
                style = GlTextStyle.button,
                color =  if (enable) textColor else textColor.copy(alpha = alpha)
            )

            if (icon != null){

                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = if (enable) iconColor else iconColor.copy(alpha = alpha)
                )

            }

        }
    }
}