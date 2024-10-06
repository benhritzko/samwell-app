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

enum class ClassType(val displayName: String, val primaryRole: Role, val secondaryRole: Role) {

    ALCHEMIST("Alchemist", Role.HEAL, Role.SUPPORT),
    ANIMAL_TAMER("Animal Tamer",Role.DPS,Role.SUPPORT),
    ARTIFICER("Artificer", Role.SUPPORT,Role.DPS),
    ASTROLOGER("Astrologer", Role.HEAL,Role.SUPPORT),
    ASTROLOGERTWO("Rename", Role.SUPPORT,Role.HEAL),
    BALANCE_MAGE("Balance Mage", Role.DPS,Role.SUPPORT),
    BARBARIAN("Barbarian", Role.TANK,Role.SUPPORT),
    BARD("Bard", Role.SUPPORT,Role.DPS),
    BLACK_MAGE("Black Mage", Role.DPS,Role.DPS),
    BLOOD_GUARD("Blood Guard", Role.DPS,Role.HEAL),
    BLUE_MAGE("Blue Mage", Role.DPS, Role.TANK),
    COLOSSUS("Colossus", Role.TANK, Role.TANK),
    CHRONOMANCER("Chronomancer", Role.SUPPORT, Role.HEAL),
    CLERIC("Cleric", Role.TANK, Role.HEAL),
    CLERICTWO("Rename", Role.HEAL, Role.TANK),
    CRUSADER("Crusader", Role.DPS, Role.TANK),










    MACHINIST("Machinist",Role.DPS,Role.SUPPORT),
    MAD_SCIENTIST("Mad Scientist", Role.SUPPORT, Role.HEAL);

    companion object {

        fun getClasses(primaryRole: Role? = null, secondaryRole: Role? = null): List<ClassType> =
            ClassType.entries.filter { primaryRole == null || primaryRole == it.primaryRole }
                .filter { secondaryRole == null || secondaryRole == it.secondaryRole }
    }

}

