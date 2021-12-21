package guillermo.lagos.composables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import guillermo.lagos.composables.shared.GlColors
import guillermo.lagos.composables.shared.layout.GlColumn
import guillermo.lagos.composables.shared.layout.GlScroll
import guillermo.lagos.composables.shared.layout.GlToolbar
import guillermo.lagos.composables.shared.screen.GlError
import guillermo.lagos.composables.shared.screen.GlLoading
import guillermo.lagos.composables.shared.screen.GlSignature
import guillermo.lagos.composables.shared.views.*

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlColors.General = Color.Blue

            GlColors.GradientColors = listOf(
                Color.Red,
                Color.Black
            )

            Surface(color = GlColors.Secondary) {
                Screen()
                /*ScreenError()*/
                /*ScreenLoading()*/
                /*ScreenSignature()*/
                /*ScreenWithToolbar()*/
            }
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun Screen() {
    GlScroll(
        modifier = Modifier
            .background(GlColors.Secondary)
    ){
        item {
            GlCard(onClick = {}) {

                Text(text = "Hola")

                GlButton(text = "Hola") {

                }

                GlButtonIcon(icon = R.drawable.ic_back) {

                }

                GlButtonToolbar(icon = R.drawable.ic_back) {

                }

                val isChecked = remember{
                    mutableStateOf(false)
                }

                GlSwitch(
                    isChecked = isChecked.value,
                    onCheckedChange = {
                        isChecked.value = it
                    }
                )

                val textField = remember{
                    mutableStateOf("")
                }

                GlTextField(
                    label = "Hola",
                    text = textField.value,
                    onValueChange = {
                        textField.value = it
                    }
                )

                GlTextField(
                    isPasswordField = true,
                    label = "Hola",
                    text = textField.value,
                    onValueChange = {
                        textField.value = it
                    }
                )

            }
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun ScreenError() {
    GlError(
        message = "Hola",
        speech = {},
        onClose = {

        }
    )
}

@ExperimentalMaterialApi
@Composable
fun ScreenLoading() {
    GlLoading(
        message = "Hola",
        animation = R.raw.anim_loading,
        isLoading = true
    )
}

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Preview
@Composable
fun ScreenSignature() {
    GlColumn {
        GlSignature(
            label = "Hola",
            onClear = {

            },
            onSave = {

            }
        )
    }
}


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Preview
@Composable
fun ScreenWithToolbar() {
    Scaffold(
        topBar = {
            GlToolbar(onBack = {}) {

            }
        }
    ) {
        ScreenSignature()
    }
}