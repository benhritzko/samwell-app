package repository

import common.model.CharacterModel

class CharacterRepository {

    suspend fun getCharacters(username: String): List<CharacterModel> {
        //This will get characters from the database

        TODO()
    }

    suspend fun updateCharacter(characterModel: CharacterModel): Result<CharacterModel> {
        //This will update the database

        TODO()
    }

    companion object {
        val INSTANCE = CharacterRepository()
    }
}