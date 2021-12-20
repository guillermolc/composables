package guillermo.lagos.composables.shared.layout

import guillermo.lagos.composables.shared.views.GlButtonToolbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.R

@ExperimentalComposeUiApi
@Composable
fun GlToolbar(
    background: Color = GlColors.General,
    onBack: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .background(background)
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        GlButtonToolbar(
            icon = R.drawable.ic_back,
            onClick = onBack
        )

        Spacer(modifier = Modifier.weight(1f))

        content()

    }
}