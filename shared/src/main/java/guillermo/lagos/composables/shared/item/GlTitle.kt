package guillermo.lagos.composables.shared.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.GlTextStyle

@Composable
fun GlTitle(
    modifier: Modifier = Modifier,
    style: TextStyle = GlTextStyle.titleDark,
    title: String,
    subTitle: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = style
        )

        Text(
            text = subTitle,
            style = style,
            fontWeight = FontWeight.Normal
        )
    }
}