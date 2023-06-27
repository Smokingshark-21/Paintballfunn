// hier wird das eingabe menü definirt
fun menue(){
        println("Welcome at your paintball calculator\n")
    do{

        try {

            println("Select an option")
            println("[1]create weapon\n" +
                    "[2]Rounding requires calculation\n" +
                    "[3]Paintballs consumption per day\n" +
                    "[4]Close program")
            var input = readln().toInt()

            when(input){
                1 -> { createWeapon() }
                2 -> {roundingRequirescalculation()}
                3 -> {paintballsConsumptionperDay()}
                4 -> {
                    println("See you again ")
                    break
                }
            }
        }catch (e:Exception){
            e.message
            println("Try again\n")
            Thread.sleep(1000)
            continue
        }


    }while (true)
}

//fun gun anlegen lässt den user eine neue gun anlegen

fun createWeapon(){
    do {

        try {
            println("\nCreate Weapon\n")
            println("What kind of maker do you want to create?")
            var gun = readln()
            println("How many magazines do you have?")
            var magazin = readln().toInt()
            println("How many Paintballs fit in one magazine")
            var magazinSize = readln().toInt()

            var gunacc=GunClass(gun,magazin,magazinSize)

            gunlist.add(gunacc)

            println("Would you like to create another marker? [Yes/No]")
            var input = readln().lowercase()

            when(input){
                "yes" -> continue
                "no" -> menue()
            }
        }catch (e:Exception){
            println("Try again\n")
            continue
        }
    }while (true)
}

//was wird pro runde verbraucht

fun roundingRequirescalculation(){
   do {
    try {

        var number = 1
        for (i in gunlist) {
            println("[$number]Maker[${i.gun}]Magazine[${i.magazine}]Magazine size[${i.magazineSize}]")
            println()
            number++
        }

        println("which maker are we talking about?")
        val input = readln().toInt() - 1

        val gun = gunlist[input].gun
        val magazine = gunlist[input].magazine
        val magazineSize = gunlist[input].magazineSize

        println("How many rounds do you want to play?")
        val rounds = readln().toInt()

        val munProplay = magazine * magazineSize
        val playrounds = munProplay * rounds

        println(
            "for your $gun with [$magazine]magazines and a magazine size [$magazineSize] we come to a consumption per round of\n" +
                    "Paintballs[$munProplay] for $rounds rounds you need paintballs[$playrounds]\n"
        )

        println("Do you want to go back to the menu [Yes/No]")
        var input2 = readln().lowercase()

        when (input2) {
            "yes" -> menue()
            "no" -> continue
        }
    }catch (e:Exception){
        println("Try again\n")
        continue
    }
   }while (true)
}

//verbrauch pro tag

fun paintballsConsumptionperDay(){
    do {
        try {

            println("How many rounds do you play on average per game day?\n")
            val rounds = readln().toInt()

            println("Which Maker do you take with you\n")

            var number = 1
            for (i in gunlist) {
                println("[$number]Maker[${i.gun}]Magazine[${i.magazine}]Magazine size[${i.magazineSize}]")
                println()
                number++
            }
            val gunInput = readln().toInt()-1


            val gun = gunlist[gunInput].gun
            val magazine = gunlist[gunInput].magazine
            val magazineSize = gunlist[gunInput].magazineSize

            val munProplay = magazine * magazineSize
            val playrounds = munProplay * rounds

            println("for your $gun with [$magazine]magazines and a magazine size [$magazineSize] you consume on a game day Paintballs[$playrounds]\n")


            println("Do you want to go back to the menu [Yes/No]")
            var input2 = readln().lowercase()

            when (input2) {
                "yes" -> menue()
                "no" -> continue
            }
        }catch (e:Exception) {
            println("Try again\n")
            continue
        }
    }while (true)
}