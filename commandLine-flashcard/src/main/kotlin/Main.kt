import Game

fun main(args: Array<String>) {
    // Initialize a game class
    // The type of g should never change from type Game.
    // But the game instance itself is mutable.
    val g = Game()

    // All we need to do is call the game run function.
    g.run()
}