package guillermo.lagos.composables.shared.item

import guillermo.lagos.composables.shared.layout.GlRow
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.GlTextStyle

@Composable
fun GlItem(
    modifier: Modifier = Modifier,
    isVertical: Boolean = false,
    title: String,
    description: String,
    descriptionColor: Color = GlColors.Black
) = if (isVertical) Column(
    modifier = modifier,
    horizontalAlignment = Alignment.Start,
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {

    Text(
        text = title,
        style = GlTextStyle.itemTitle,
        textAlign = TextAlign.Start
    )

    Text(
        text = description,
        style = GlTextStyle.itemDescription,
        color = descriptionColor,
        textAlign = TextAlign.Start
    )

}else GlRow(
    modifier = modifier
) {

    Text(
        modifier = Modifier.weight(1f),
        text = title,
        style = GlTextStyle.itemTitle
    )

    Text(
        text = description,
        style = GlTextStyle.itemDescription,
        color = descriptionColor
    )

}