package common.model

data class CharacterModel(val ownerUsername: String, val characterName: String, val classType: ClassType)

enum class ClassType {
    FIGHTER,
    ROGUE,
    PALADIN,
    WIZARD
}