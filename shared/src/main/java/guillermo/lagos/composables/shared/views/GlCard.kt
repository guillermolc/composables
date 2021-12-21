package guillermo.lagos.composables.shared.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.GlProperties
import guillermo.lagos.composables.shared.GlShapes
import guillermo.lagos.composables.shared.noRippleClickable

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun GlCard(
    modifier: Modifier = Modifier,
    background: Color = GlColors.Principal,
    shape: Shape = GlProperties.shape,
    borderColor: Color = GlColors.Principal,
    columnAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    onClick: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .noRippleClickable(onClick = onClick),
        backgroundColor = background,
        border = BorderStroke(2.dp, borderColor),
        shape = shape
    ) {
        Column(
            Modifier.padding(16.dp),
            horizontalAlignment = columnAlignment,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            content()
        }
    }
}