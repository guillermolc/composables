package guillermo.lagos.composables.shared

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import guillermo.lagos.composables.GlFontSize

object GlTextStyle{

        val titleDark = TextStyle(
            fontSize = GlFontSize.Title,
            fontWeight = FontWeight.Bold,
            color = GlColors.Black
        )

        val titleLight = TextStyle(
            fontSize = GlFontSize.Title,
            fontWeight = FontWeight.Bold,
            color = GlColors.White
        )

        val itemTitle = TextStyle(
            fontSize = GlFontSize.Normal,
            fontWeight = FontWeight.Bold,
            color = GlColors.Black
        )

        val itemDescription = TextStyle(
            fontSize = GlFontSize.Normal,
            color = GlColors.Black
        )

        val button = TextStyle(
            fontSize = GlFontSize.Normal,
            fontWeight = FontWeight.Bold,
            color = GlColors.White
        )

    }