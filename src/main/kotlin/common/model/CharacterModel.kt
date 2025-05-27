package common.model

data class CharacterModel(
    val ownerUsername: String,
    val characterName: String,
    val classType: ClassType,
    val characterLevel: Int
)

enum class Role {
    TANK,
    DPS,
    SUPPORT,
    HEAL;

    fun classes(): List<ClassType> = ClassType.getClasses(this)
}

enum class ClassType(val displayName: String, val primaryRole: Role, val secondaryRole: Role, val abilityList: List<String>) {

    ALCHEMIST("Alchemist", Role.HEAL, Role.SUPPORT, alchemistList),
    ANIMAL_TAMER("Animal Tamer",Role.DPS,Role.SUPPORT, animalTamerList),
    ARTIFICER("Artificer", Role.SUPPORT,Role.DPS, artificerList),
    ASTROLOGER("Astrologer", Role.HEAL,Role.SUPPORT, astrologerList),
    ASTROLOGERTWO("Rename", Role.SUPPORT,Role.HEAL, astrologerTwoList),
    BALANCE_MAGE("Balance Mage", Role.DPS,Role.SUPPORT, balanceMageList),
    BARBARIAN("Barbarian", Role.TANK,Role.SUPPORT, barbarianList),
    BARD("Bard", Role.SUPPORT,Role.DPS, bardList),
    BLACK_MAGE("Black Mage", Role.DPS,Role.DPS, blackMageList),
    BLOOD_GUARD("Blood Guard", Role.DPS,Role.HEAL, bloodGuardList),
    BLUE_MAGE("Blue Mage", Role.DPS, Role.TANK, blueMageList),
    COLOSSUS("Colossus", Role.TANK, Role.TANK, colossusList),
    CHRONOMANCER("Chronomancer", Role.SUPPORT, Role.HEAL, chronomancerList),
    CLERIC("Cleric", Role.TANK, Role.HEAL, clericList),
    CLERICTWO("Rename", Role.HEAL, Role.TANK, clericTwoList),
    CRUSADER("Crusader", Role.DPS, Role.TANK, crusaderList),


    MACHINIST("Machinist",Role.DPS,Role.SUPPORT, machinistList),
    MAD_SCIENTIST("Mad Scientist", Role.SUPPORT, Role.HEAL, madScientistList);

    companion object {

        fun getClasses(primaryRole: Role? = null, secondaryRole: Role? = null): List<ClassType> =
            ClassType.entries.filter { primaryRole == null || primaryRole == it.primaryRole }
                .filter { secondaryRole == null || secondaryRole == it.secondaryRole }
    }

}

val colossusList = listOf(
    "Heroic Leap: Using your action you gather your strength and leap up to a number of feet equal to your movement speed. Upon landing all enemies within 5 feet of you must make a saving throw or be knocked prone.",
    "Ready or not: Your presence on the battlefield demands your enemies attention, you make yourself the center of your enemies attention, all enemies within 5 feet of you must make a save or be provoked in attacking you. ",
    "Suffering: 100% of the damage you take is stored for later use. \n" +
            "\n" +
            " \n" +
            "\n" +
    "Growth: You can consume the suffering to increase your max health by the amount of suffering consumed ,your current health increases proportionally with the max health increase. You can use this twice per combat, three times at level 6, four at 10, 5 at 15, and 6 at 20 ",
    ""


)
val alchemistList = listOf("")
val animalTamerList = listOf("")
val artificerList = listOf("")
val astrologerList = listOf("")
val astrologerTwoList = listOf("")
val balanceMageList = listOf("")
val barbarianList = listOf("")
val bardList = listOf("")
val blackMageList = listOf("")
val bloodGuardList = listOf("")
val blueMageList = listOf("")
val chronomancerList = listOf("")
val clericList = listOf("")
val clericTwoList = listOf("")
val crusaderList = listOf("")
val machinistList = listOf("")
val madScientistList = listOf("")