package guillermo.lagos.composables.shared.selector

import guillermo.lagos.composables.shared.views.GlButtonIcon
import android.app.DatePickerDialog
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
import java.util.*

@ExperimentalComposeUiApi
@Composable
fun DateSelector(
    modifier: Modifier = Modifier,
    label: String,
    onDateSelect: (String?) -> Unit
) {

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf<String?>(null) }

    val dateDialog = DatePickerDialog(
        LocalContext.current,
        { _ , _, selectedMonth, selectedDay ->

            val newMonth = if ((selectedMonth + 1) < 10) "0${selectedMonth + 1}" else (selectedMonth + 1)
            val newDay = if (selectedDay < 10) "0$selectedDay" else selectedDay
            date.value = "$newDay-$newMonth-$year"
            onDateSelect(date.value)

        }, year, month, day
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
                text = date.value ?: "",
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
                icon = R.drawable.ic_calendar,
                onClick = {
                    dateDialog.show()
                }
            )

        }

    }
}