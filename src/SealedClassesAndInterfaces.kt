/*

@author: Syed Bipul Rahman
 */

fun main() {

    val toad = Vertebrate.Amphibian(lifeSpan = 11.5)
    val trout = Vertebrate.Fish(lifeSpan = 5.5, freshwater = true)


    val cow=Vertebrate.Mamal(false,15.0)
    val eagle=Vertebrate.Bird(30.0)

    //cross two animal🙈
//    println(toad cross trout)

   // println(cow cross eagle)

    println(eagle cross trout)

}

//Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
// All direct subclasses of a sealed class are known at compile time.
sealed class Vertebrate(
    private val isCoolBlooded: Boolean,
    private val lifeSpan: Double,
) {
    class Fish(freshwater: Boolean, lifeSpan: Double) : Vertebrate(isCoolBlooded = true, lifeSpan)
    class Amphibian(lifeSpan: Double) : Vertebrate(isCoolBlooded = true, lifeSpan)
    class Reptile(lifeSpan: Double) : Vertebrate(isCoolBlooded = true, lifeSpan)
    class Bird(lifeSpan: Double) : Vertebrate(isCoolBlooded = false, lifeSpan)
    class Mamal(isEggLaying: Boolean, lifeSpan: Double) : Vertebrate(isCoolBlooded = false, lifeSpan)

    private class GenericVertebrate(
        private val isCoolBlooded: Boolean,
        private val lifeSpan: Double,
        private val name: String
    ) : Vertebrate(isCoolBlooded, lifeSpan) {
        override fun toString(): String {
            return """
               Animal: $name,
               LifeSpan: $lifeSpan,
               Is Warm Blooded: ${if (isCoolBlooded) "No" else "Yes"}
               
            """.trimIndent()
        }
    }


    infix fun cross(vertebrate: Vertebrate): Vertebrate {
        return GenericVertebrate(
            name = "Generic ${this.javaClass.name}/${vertebrate.javaClass.name}".replace("Vertebrate$",""),
            isCoolBlooded = !(!this.isCoolBlooded && !vertebrate.isCoolBlooded),
            lifeSpan = this.lifeSpan + vertebrate.lifeSpan
        )
    }


}