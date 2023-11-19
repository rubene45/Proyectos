package com.example.pruebakotlin

fun main() {
    var lenguaje:String = "Kotlin"
    obtenerLenguaje(lenguaje)
    recorrerArray()

    var lista = listOf<String>("Uno", "Dos", "Tres", "Cuatro")
    println("Hola mundo ...")
    println(lista.filter {it->it.length>3})
}

fun calcularEstudios(edad:Int) {
    when (edad) {
        in 1 .. 12 -> {
            println("Educacion primaria")
        }
        in 13 .. 16 -> {
            println("Educacion secundaria")
        }
        in 17 .. 18 -> {
            println("Bachillerato")
        }
        else -> {
            println("Universitaria")
        }
    }
}

fun recorrerArray() {
    var listaNumero = listOf<Int>(2,3,8,10,-5,7)
    for (numero:Int in listaNumero) {
        println(numero)
    }
}

fun sumar10primerosNumeros() {
    var sum=0
    for (numero in 1 .. 10) {
        sum+=numero
    }
    println(sum)
}

fun sumar10primerosPares() {
    var sum=0
    for (numero in 2 .. 20 step 2) {
        sum+=numero
    }
    println(sum)
}

fun obtenerLenguaje(lenguaje:String) {
    when(lenguaje) {
        "Kotlin" -> {
            println("Es kotlin")
        }
        "Java" -> println("Es java")
        "PHP" -> println("Es PHP")
        "Python" -> println("Es python")
        else -> println("Lenguaje no encontrado")
    }
}

fun filter(lista: List<String>):List<String> {
    var listaFiltrada= (arrayListOf <String>())
    for (s in lista) {
        if (s.length<3) {
            listaFiltrada.add(s)
        }
    }
    return listaFiltrada
}