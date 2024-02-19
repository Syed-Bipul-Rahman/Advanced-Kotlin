fun main() {
    val greeting=Greeting()
}

class Greeting {
    companion object {
        init {
            print("Hello, Kotlin!")
        }
    }
}