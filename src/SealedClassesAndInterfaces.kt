/*

@author: Syed Bipul Rahman
 */

fun main() {

    val toad = Amp(lifeSpan = 11.5)
    val trout = Vertebrate.Fish(lifeSpan = 5.5, freshwater = true)


    val cow = Vertebrate.Mamal(false, 15.0)
    val eagle = Vertebrate.Bird(30.0)

    //cross two animal🙈
//    println(toad cross trout)

    // println(cow cross eagle)

    //println(eagle cross trout)

    val crosed = eagle cross cow

    when (crosed) {
        is Vertebrate.Fish -> println()
        is Amp -> TODO()
        is Vertebrate.Bird -> TODO()
        is Vertebrate.Mamal -> TODO()
        is Vertebrate.Reptile -> TODO()
        is CustomVertebrate-> TODO()
        else -> println()
    }



simulation(fun (p1:Int,p2)=p1+p2)



}

// a sealed class is a special type of class that represents a restricted hierarchy in which each subclass must be declared within the same file where the sealed class is declared.

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
            name = "Generic ${this.javaClass.name}/${vertebrate.javaClass.name}".replace("Vertebrate$", ""),
            isCoolBlooded = !(!this.isCoolBlooded && !vertebrate.isCoolBlooded),
            lifeSpan = this.lifeSpan + vertebrate.lifeSpan
        )
    }


}

//sealed interface
sealed interface Plant {
    val name: String
    val height: Double

    interface Gymno : Plant {
        infix fun cross(plant: Plant): Plant

    }

    interface Angio : Plant {
        infix fun bread(plant: Plant): Plant

    }

}

//sealed class is very similar to enum classes
class Mango : Plant.Angio {
    override fun bread(plant: Plant): Plant {
        TODO("Not yet implemented")
    }

    override val name: String
        get() = TODO("Not yet implemented")
    override val height: Double
        get() = TODO("Not yet implemented")

}

fun simulation(op:NumaricOparation){
    println(op(10,20))
}

//typealias is use to introduce class in short word or character sequences.
//typealias
typealias Amp=Vertebrate.Amphibian

//for calculation
typealias NumaricOparation=(Int,Int)->Int