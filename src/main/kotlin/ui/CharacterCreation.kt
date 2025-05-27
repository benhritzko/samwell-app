package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import common.model.CharacterModel
import common.model.ClassType
import viewmodel.CharacterCreationViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun characterCreationPage(vm: CharacterCreationViewModel){

    val character by vm.character.collectAsState()

    Column (modifier = Modifier.background(Color.LightGray).padding(15.dp).padding()) {
        Text("Name")
        TextField(character.characterName, onValueChange = { newValue: String -> vm.updateName(newValue) }, modifier = Modifier.background(Color.White).padding((2.dp)))

        Spacer(modifier = Modifier.height(50.dp))

        var levelToggle by remember { mutableStateOf(false) }
        Text(" Character Level ", modifier = Modifier.onClick(onClick = { levelToggle = !levelToggle }).background(Color.Gray).border(width = 3.dp, color = Color.DarkGray, shape = androidx.compose.ui.graphics.RectangleShape).padding(3.dp))
        Text(character.characterLevel.toString())
        Box {
            DropdownMenu(levelToggle, { levelToggle = !levelToggle }) {
                (1..25).forEach { characterLevel ->
                    DropdownMenuItem(onClick = {
                        levelToggle = false
                        vm.updateSelectedLevel(characterLevel)
                    }) {
                        Text(characterLevel.toString())
                    }
                }
            }
        }


        Spacer(modifier = Modifier.height(50.dp))

        var classToggle by remember { mutableStateOf(false) }
        Text(" Class ", modifier = Modifier.onClick(onClick = { classToggle = !classToggle }).background(Color.Gray).border(width = 3.dp, color = Color.DarkGray, shape = androidx.compose.ui.graphics.RectangleShape).padding(3.dp))
        Text(character.classType.displayName)
        Box {
            DropdownMenu(classToggle, { classToggle = !classToggle }) {
                ClassType.entries.forEach { classType ->
                    DropdownMenuItem(onClick = {
                        classToggle = false
                        vm.updateSelectedClass(classType)

                    }) {
                        Text(classType.displayName)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        var classDetails by remember { mutableStateOf(false) }
        Text(" Class Abilities ", modifier = Modifier.onClick(onClick = { classDetails = !classDetails }).background(Color.Gray).border(width = 3.dp, color = Color.DarkGray, shape = androidx.compose.ui.graphics.RectangleShape).padding(3.dp))
        Text("Abilities")
        Box {
            DropdownMenu(classDetails, { classDetails = !classDetails }) {
                character.classType.abilityList.take(character.characterLevel)
                    .mapIndexed { index, ability -> "Level:" + (index + 1) + " " + ability }
                    //.filter { ability -> ability.contains("Chungus")}
                    .forEach { ability ->
                        DropdownMenuItem(onClick = { }, Modifier.padding(5.dp).background(Color.LightGray)) {
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