import kotlin.random.Random

fun main() {
    ReproductorMidi("pugnodollari.mid")
    println("cargando juego...")

    val random = Random
    val animales = arrayOf("perro","gato","girafa","ballena","avestruz","coballa","ardilla","raton")
    val num = random.nextInt(animales.size)
    val palabra = animales[num]
    var i = 0
    val recon = CharArray(20)

    //Cifrado de la palabra a '*'
    for(a in palabra.indices){
        recon[a]= '*'
    }
    Thread.sleep(20000)

    //Bucle en el que se inserta la letra y se busca en la palabra
    do{
        println("Inserte la letra:")
        val letra = readln()
        var v = 0

        //Buscador de la letra
        for (a in palabra.indices) {
            if (letra[0] == palabra[a]) {
                recon[a] = letra[0]
            }else{
                v += 1
            }
        }

        //Comprobador de si coincidia alguna letra y imprimir el resultado
        if (v == palabra.length) {
            println("Character incorrecto")
            i += 1
        } else {
            println("Character correcto")
        }

        DibujoAhorcado.dibujar(i)

        //Impresion de la palabra con los caracteres que emos descubierto
        for (a in palabra.indices) {
            print(recon[a])
        }
        println()

        var recuento = 0
        for (a in palabra.indices){
            if (recon[a] == palabra[a]){
                recuento++
            }
        }
        if (recuento == palabra.length){
            println("FELICIDADES")
            break
        }else if (i > 6 && recuento < palabra.length){
            println("PERDISTE")
            break
        }

    }while (true)
}