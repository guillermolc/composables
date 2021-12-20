package guillermo.lagos.composables.shared.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.*
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.GlTextStyle
import guillermo.lagos.composables.shared.GlTheme
import guillermo.lagos.composables.shared.R

@ExperimentalComposeUiApi
@Composable
fun GlTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: String,
    singleLine: Boolean = true,
    isPasswordField: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {

    var isPassVisible by remember {
        mutableStateOf(true)
    }

    val passwordTrailingIcon = if (isPassVisible) R.drawable.ic_visible
    else R.drawable.ic_invisible

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

            BasicTextField(
                textStyle = TextStyle(
                    fontSize = GlFontSize.Normal,
                    color = GlColors.Black
                ),
                value = text,
                onValueChange = { onValueChange(it) },
                modifier = Modifier
                    .weight(1f)
                    .clip(GlTheme.shape)
                    .border(1.dp, GlColors.General, GlTheme.shape)
                    .background(color = GlColors.Principal)
                    .padding(
                        horizontal = 8.dp,
                        vertical = 10.dp
                    ),
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                visualTransformation = if (isPassVisible && isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
                singleLine = singleLine
            )


            if(isPasswordField) GlButtonIcon(
                icon = passwordTrailingIcon,
                onClick = {
                    isPassVisible = !isPassVisible
                }
            )
        }
    }
}