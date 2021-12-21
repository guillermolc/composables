package guillermo.lagos.composables.shared.selector

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.*
import guillermo.lagos.composables.shared.R
import guillermo.lagos.composables.shared.views.GlButtonIcon

@ExperimentalComposeUiApi
@Composable
fun TimeSelector(
    modifier: Modifier = Modifier,
    label: String,
    onTimeSelect: (String?) -> Unit
) {

    val time = remember { mutableStateOf<String?>(null) }

    val timeDialog = TimePickerDialog(
        LocalContext.current,
        { _, hour: Int, minute: Int ->
            val newHour = if (hour < 10) "0$hour" else hour
            val newMinute = if (minute < 10) "0$minute" else minute
            time.value = "$newHour:$newMinute"
            onTimeSelect(time.value)
        }, 0, 0, false
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        Text(
            modifier = modifier.fillMaxWidth(),
            text = label,
            style = GlTextStyle.itemTitle
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                style = GlTextStyle.itemTitle,
                textAlign = TextAlign.Center,
                text = time.value ?: "",
                modifier = Modifier
                    .weight(1f)
                    .clip(GlProperties.shape)
                    .border(1.dp, GlColors.General, GlProperties.shape)
                    .background(color = GlColors.Secondary)
                    .padding(
                        horizontal = 8.dp,
                        vertical = 10.dp
                    )
            )


            GlButtonIcon(
                icon = R.drawable.ic_clock,
                onClick = {
                    timeDialog.show()
                }
            )

        }

    }
}