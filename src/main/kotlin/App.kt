/*
Generate a random 4-digit number. The number must not contain repeating digits.
Ask the user to guess the 4-digit number. The output should be in the format "n:m",
where "n" is the number of digits guessed correctly regardless of their position,
and "m" is the number of digits guessed correctly at their correct position.
Here are some examples:

Generated number: 8576
User input: 1234, Output: 0:0
User input: 5678, Output: 4:1
User input: 5555, Output: 1:1
User input: 3586, Output: 3:2

Once the user guesses the correct number, the game is over.

 */


fun main() {
    val randomNum = (0..9).shuffled().take(4).joinToString("")
    println("A random 4-digit number has been generated. Can you guess it?")

    var solved = false
    while (!solved) {
        print("Your guess: ")
        val input = readln()
        var n = 0
        var m = 0
        for ((index, value) in randomNum.withIndex()) {
            if (input[index] == value) {
                ++m
            }
            if (input.contains(value)) {
                ++n
            }
        }
        println("$n:$m")

        if (input == randomNum) {
            println("Solved!")
            solved = true
        }
    }
}
