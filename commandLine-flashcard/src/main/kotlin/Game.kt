/**********************************************************
 * GAME
 * A class to practice flash cards
 *********************************************************/
class Game {

    // Initialize Member Variables
    private var practiceNum = 0
    private var operand = ""
    private var generatedNum = 0
    private var answer = 0
    private var numsAlreadyUsed = mutableSetOf<Int>(0)
//    private var currentProblem = arrayOf<String>("", "", "")

    /**********************************************************
     * A function to run the flash card game
     *********************************************************/
    fun run() {
        // First step is to welcome the player
        displayWelcome()

        var done = false
        while (!done) {
            // Start a new game
            newGame()

            while (numsAlreadyUsed.size < 13) {
                // Play one problem
                playOneProblem()
                generateProblem()
            }

            // Play again?
            println("Type 'quit' to exit the game. Press enter to play again.")
            var a = readln()
            if (a.lowercase() == "quit") {
                done = true
                println("Goodbye! Thanks for playing")
            }
        }

    }

    /**********************************************************
     * NEW GAME
     * A function to start a new game
     *********************************************************/
    private fun newGame()
    {
        // Make sure nums already used is clear
        numsAlreadyUsed.clear()

        // Next get and set the practice number
        var num = getPracticeNum()
        setPracticeNum(num)

        // Next get and set the operand
        var mathType = getOperand()
        setOperand(mathType)

        // Now we generate a new problem
        generateProblem()
    }

    /**********************************************************
     * PLAY ONE PROBLEM
     * A function to play one flash card problem
     *********************************************************/
    private fun playOneProblem() {
        // Display the problem
        println(getCurrentProblem())

        // Accept input
        var a = getUserAnswer()

        // If not correct
        while (!isCorrect(a))
        {
            // Display wrong message
            println("Wrong")

            // Display the problem again
            println(getCurrentProblem())

            // Accept input again
            a = getUserAnswer()
        }

        // Once correct display correct message
        println("Well done")
    }

    /**********************************************************
     * DISPLAY WELCOME
     * A function to display the welcome message
     *********************************************************/
    private fun displayWelcome() {
        // Welcome message
        println("Welcome to the flash card app!")
    }

    /**********************************************************
     * SET OPERAND
     * A function to set the operand type.
     *********************************************************/
    private fun setOperand(o : String) {
        operand = when (o) {
            "x"  -> "x"
            "/"  -> "/"
            "+"  -> "+"
            "-"  -> "-"
            else -> "x"
        }
        println("Operand set to: $operand")
    }

    /**********************************************************
     * GET OPERAND
     * A function to get the operand type.
     *********************************************************/
    private fun getOperand(): String {
        println("What operand (x, /, +, -) would you like to practice? ")
        return readln()
    }

    /**********************************************************
     * SET PRACTICE NUMBER
     * A function to set the practice number. Number must be
     * greater than 0 and less than 12
     *********************************************************/
    private fun setPracticeNum(num : Int) {

        if (num in 1..12) {
            practiceNum = num
            println("Practice number set to: $practiceNum")
        }
    }

    /**********************************************************
     * GET PRACTICE NUMBER
     * A function to get the practice number.
     *********************************************************/
    private fun getPracticeNum(): Int {
        println("What number would you like to practice? ")
        var practiceNum = readln()
        return practiceNum.toInt()
    }

    /**********************************************************
     * GENERATE PROBLEM
     * A function to generate a new problem
     *********************************************************/
    private fun generateProblem() {
        while (generatedNum in numsAlreadyUsed) {
            generatedNum = (1..12).random()
        }
        when (operand) {
            "x" -> answer = practiceNum * generatedNum
            "/" -> answer = practiceNum / generatedNum
            "+" -> answer = practiceNum + generatedNum
            "-" -> answer = practiceNum - generatedNum
        }
        numsAlreadyUsed.add(generatedNum)
//        currentProblem[0] = practiceNum.toString()
//        currentProblem[1] = operand
//        currentProblem[2] = generatedNum.toString()
    }

    /**********************************************************
     * GET CURRENT PROBLEM
     * A function to get the current problem.
     *********************************************************/
    private fun getCurrentProblem() : String {
        return "${practiceNum} ${operand} ${generatedNum} = "
    }

    /**********************************************************
     * GET NEW PROBLEM
     * A function to return a new problem
     *********************************************************/
    private fun getNewProblem() : String {
        generateProblem()
        return getCurrentProblem()
    }

    /**********************************************************
     * GET USER ANSWER
     * A function to return accept a users answer
     *********************************************************/
    private fun getUserAnswer() : Int {
        println("Answer: ")
        return readln().toInt()
    }

    /**********************************************************
     * IS CORRECT
     * A function to check if an user answer is correct
     *********************************************************/
    private fun isCorrect(uAnswer : Int) : Boolean {
        return uAnswer == answer
    }

    /**********************************************************
     * GET ANSWER
     * A function to return the correct answer
     *********************************************************/
    fun getAnswer() : String {
        return answer.toString()
    }


}



