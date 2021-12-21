package guillermo.lagos.composables.shared.screen

import guillermo.lagos.composables.shared.layout.GlRow
import guillermo.lagos.composables.shared.views.GlButtonIcon
import android.graphics.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import guillermo.lagos.composables.shared.*
import guillermo.lagos.composables.shared.layout.GlColumn
import guillermo.lagos.composables.shared.screen.signature.SignatureView
import guillermo.lagos.composables.shared.views.GlButton

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun GlSignature(
    modifier: Modifier = Modifier,
    label: String,
    onClear: () -> Unit,
    onSave: (Bitmap) -> Unit
) {

    val signatureView = glSignatureView()

    GlColumn(
        modifier = modifier.padding(16.dp)
    ) {
        GlRow {

            Text(
                modifier = Modifier.weight(1f),
                text = label,
                style = GlTextStyle.itemTitle
            )

            GlButtonIcon(
                icon = R.drawable.ic_remove,
                onClick = {
                    signatureView.clearSignature()
                    onClear()
                }
            )

            GlButton(
                text = "GUARDAR",
                onClick = {
                    onSave(signatureView.signature)
                }
            )

        }

        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(GlProperties.shape)
                .border(3.dp, GlColors.General, GlProperties.shape)
                .background(color = GlColors.Principal),
            factory = {
                signatureView
            }
        )
    }
}

@Composable
private fun glSignatureView(): SignatureView {

    val context = LocalContext.current

    return remember{
        SignatureView(context = context)
    }
}
