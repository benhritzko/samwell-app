import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.ChararacterCreationPage
import viewmodel.CharacterCreationViewModel

fun main() {
    //bootstrapping logic goes here
    val characterCreationViewModel = CharacterCreationViewModel()

    application {
        Window(onCloseRequest = ::exitApplication) {
            MaterialTheme() {
                ChararacterCreationPage(characterCreationViewModel)
            }
        }
    }
}
