package guillermo.lagos.composables.shared.views

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import guillermo.lagos.composables.shared.GlColors

@Composable
fun GlSwitch(
    color: Color = GlColors.General,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Switch(
        checked = isChecked,
        onCheckedChange = onCheckedChange,
        colors = SwitchDefaults.colors(
            checkedThumbColor = color,
            checkedTrackColor = color,
            uncheckedThumbColor = GlColors.General,
            uncheckedTrackColor = GlColors.General
        )
    )
}