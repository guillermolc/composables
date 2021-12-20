package guillermo.lagos.composables.shared.screen

import guillermo.lagos.composables.shared.views.GlButton
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.GlTextStyle
import guillermo.lagos.composables.shared.R
import guillermo.lagos.composables.shared.gradientBackground
import guillermo.lagos.composables.shared.views.GlCard

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun GlError(
    message: String,
    speech: () -> Unit,
    onClose: () -> Unit
) {

    LaunchedEffect(Unit){
        speech()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .gradientBackground(),
        contentAlignment = Alignment.Center
    ) {


        GlCard(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            onClick = {}
        ) {

            Icon(
                modifier = Modifier
                    .size(50.dp),
                painter = painterResource(id = R.drawable.ic_warning),
                contentDescription = null,
                tint = GlColors.Red
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "¡INFORMACIÓN!",
                color = GlColors.Red,
                style = GlTextStyle.titleDark,
                textAlign = TextAlign.Center
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                color = GlColors.General
            )

            Text(
                text = message,
                style = GlTextStyle.titleDark,
                textAlign = TextAlign.Center
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                color = GlColors.General
            )

            GlButton(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "CERRAR",
                onClick = onClose
            )
        }
    }
}