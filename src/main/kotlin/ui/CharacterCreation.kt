package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.onClick
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import common.model.ClassType
import viewmodel.CharacterCreationViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharacterCreationPage(vm: CharacterCreationViewModel) {

    val character by vm.character.collectAsState()

    Column {
        Text("Name")
        TextField(character.characterName, onValueChange = { newValue: String -> vm.updateName(newValue) })

        Spacer(modifier = Modifier.height(50.dp))

        var levelToggle by remember { mutableStateOf(false) }
        Text("Character Level", modifier = Modifier.onClick(onClick = { levelToggle = !levelToggle }))
        Text(character.characterLevel.toString())
        Box {
            DropdownMenu(levelToggle, { levelToggle = !levelToggle }) {
                (1..25).forEach { characterLevel ->
                    DropdownMenuItem(onClick = { vm.updateSelectedLevel(characterLevel) }) {
                        Text(characterLevel.toString())
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(50.dp))

        var classToggle by remember { mutableStateOf(false) }
        Text("Class", modifier = Modifier.onClick(onClick = { classToggle = !classToggle }))
        Text(character.classType.displayName)
        Box {
            DropdownMenu(classToggle, { classToggle = !classToggle }) {
                ClassType.entries.forEach { classType ->
                    DropdownMenuItem(onClick = { vm.updateSelectedClass(classType) }) {
                        Text(classType.displayName)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        var classDetails by remember { mutableStateOf(false) }
        Text("Class Abilities", modifier = Modifier.onClick(onClick = { classDetails = !classDetails }))
        Text("Abilities")
        Box {
            DropdownMenu(classDetails, { classDetails = !classDetails }) {
                character.classType.abilityList.forEach { ability ->
                    DropdownMenuItem(onClick = { }) {
                        Text(ability)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        TextButton(onClick = { vm.completeCreation() }) {
            Text("Finish!")
        }
    }
}