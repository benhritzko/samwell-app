package viewmodel

import androidx.compose.runtime.Stable
import common.model.CharacterModel
import common.model.ClassType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import repository.CharacterRepository

@Stable
class CharacterCreationViewModel(val characterRepository: CharacterRepository = CharacterRepository.INSTANCE) {

    //This could possible leak, but meh deal with it later
    private val scope = CoroutineScope(Dispatchers.Default)

    private val _character: MutableStateFlow<CharacterModel> = MutableStateFlow(CharacterModel("menwell", "chungito", ClassType.FIGHTER, 1))
    val character: StateFlow<CharacterModel> = _character.asStateFlow()

    fun updateName(name: String) {
        _character.getAndUpdate {
            it.copy(characterName = name)
        }
    }

    fun updateSelectedClass(selectedClassType: ClassType) {
        _character.getAndUpdate {
            it.copy(classType = selectedClassType)
        }
    }

    fun updateSelectedLevel(selectedCharacterLevel: Int) {
        _character.getAndUpdate {
            it.copy(characterLevel = selectedCharacterLevel)
        }
    }

    fun completeCreation() {
        scope.launch {
            characterRepository.updateCharacter(character.value)
        }
    }

}