package com.example.pokemontest

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sign

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Algoritmos {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun sortList() {
        val string = "username=Rafael, age=14, sport=box, job=programer;" +
                " username=Brenda, age=12, sport=futbol, job=home;" +
                " username=Rafael, age=12, sport=futbol, job=seller;" +
                " username=Rafael, age=12, sport=futbol, job=seller;" +
                " username=betukis, age=22, sport=tenis, job=gym"

        val listSplit: List<String> = string.split(";")
        val listItem: MutableList<String> = mutableListOf()

        listSplit.map {
            it.split(",").forEach { item ->
                listItem.add(item.trim())
            }
        }

        val sortedList: MutableList<String> = mutableListOf()
        listItem.forEach { item ->
            if (item.contains("username")) {

            } else {
                sortedList.add(item)
            }
        }

    }

    @Test
    fun flatmapMap() {
        val order = Order(
            listOf(OrderLine("Tomato", 2), OrderLine("Garlic", 3), OrderLine("Chives", 2))
        )

        val names: List<String> = order.lines.map { it.name }
        val a = names[0]
        val orders = listOf(
            Order(listOf(OrderLine("Garlic", 1), OrderLine("Chives", 2))),
            Order(listOf(OrderLine("Tomato", 3), OrderLine("Garlic", 4))),
            Order(listOf(OrderLine("Potato", 5), OrderLine("Chives", 6))),
        )
        val lines: List<OrderLine> = orders.flatMap { it.lines }
        val namesLines = lines.map { it.name }.distinct()
        val b = names[0]
    }

    data class Order(val lines: List<OrderLine>)
    data class OrderLine(val name: String, val price: Int)


    @Test
    fun groupExamples() {
        val words = listOf(
            "bezkoder",
            "zkoder",
            "kotlin",
            "programmingz",
            "bezcoder",
            "professional",
            "zcoder"
        )
        val byLength = words.groupBy { it.length }
        val list = byLength.values.flatten()
        val a = 1
    }


    suspend fun fetchData(): String {
        //delay(1000L)
        return "Hello world"
    }

    /*
    @Test
    fun dataShouldBeHelloWorld() = runTest {
        val data = fetchData()
        assertEquals("Hello world", data)
    }*/


    @Test
    fun anagramAlgorithm() {
        val list = listOf("cat", "tac", "act", "good", "godo", "doog", "yo", "oy", "abc", "acb")
        val listGroup = list.groupBy { it.toList().sorted() }
        val a = 0
    }

    @Test
    fun waterAlgorithm() {
        val listHeights2 = listOf(2, 4, 6, 7, 1, 7, 4)
        val listHeights = listOf(1, 8, 6, 2, 5, 7)

        val maxArea = getMaxArea(listHeights)
    }

    private fun getMaxArea(list: List<Int>): Int {
        var maxArea = 0
        var i = 0
        var j = list.size - 1
        while (i < j) {
            val minHeight = min(list[i], list[j])
            val distance = j - i
            val area = minHeight * distance
            maxArea = max(maxArea, area)
            if (list[i] < list[j]) {
                i++
            } else {
                j--
            }
        }
        return maxArea
    }


    private fun isListAscending(listAscending: List<Int>): Boolean {
        var current = 0
        listAscending.forEach { i ->
            if (current < i) {
                current = i
            } else {
                return false
            }
        }
        return true
    }

    private fun isListDescending(listAscending: List<Int>, maxValue: Int): Boolean {
        var current = maxValue
        listAscending.forEach { i ->
            if (current > i) {
                current = i
            } else {
                return false
            }
        }
        return true
    }

    @Test
    fun mountainAlgorithm() {
        val list = listOf(1, 8, 6, 2, 5, 7)
        val list2 = listOf(1, 8, 6)
        val list3 = listOf(1, 1, 6)
        val isMountain = isMountainList(list)
        val isMountain2 = isMountainList(list2)
        val isMountain3 = isMountainList(list3)
        val a = 1
    }

    private fun isMountainList(list: List<Int>): Boolean {
        if (list.size < 3) return false
        val maxValue = list.max()
        val indexMax = list.indexOf(maxValue)
        val subListAscending = list.subList(0, indexMax)
        val subListDescending = list.subList(indexMax + 1, list.size)
        val isListAscending: Boolean = isListAscending(subListAscending)
        val isListDescending: Boolean = isListDescending(subListDescending, maxValue)
        return isListAscending && isListDescending
    }

    /**
     * se tiene un array de enteros que representa el peso de cada persona, y se tiene
     * un limite, que representa el mayor preso posible por cada bote
     * Siendo como condicion que un bote puede transportar maximo 2 personas, encuentre el
     * numero minimo de botes para transportar a las personas
     */
    @Test
    fun boatsAlgorithm() {
        val listWeights = listOf(3, 2, 2, 1, 3)
        val limitWeight = 4
        getMinBoats(listWeights, limitWeight) { maxLimit ->
        }

    }

    private fun getMinBoats(
        listWeights: List<Int>,
        maxWeight: Int,
        minBoatsNumber: (min: Int) -> Unit
    ) {
        var minBoats = 0
        var i = 0
        var j = listWeights.size - 1
        listWeights.sorted()
        while (j >= i) {
            if (listWeights[i] + listWeights[j] <= maxWeight) {
                i++
                j--
            } else {
                j--
            }
            minBoats++
        }
        minBoatsNumber(minBoats)
    }

    @Test
    fun moveZerosToEnd() {
        val list = listOf(3, 0, 2, 2, 0, 1, 0, 3)
        if (list.contains(0)) {
            val listGroup = list.groupBy { it == 0 }
            val listSortedZeros: MutableList<Int> = mutableListOf()
            val listSortedZeros2: MutableList<Int> = mutableListOf()
            listSortedZeros.addAll(listGroup.values.flatten())

            listSortedZeros2.addAll(listGroup.filterKeys { !it }.values.flatten())
            listSortedZeros2.addAll(listGroup.filterKeys { it }.values.flatten())

            val a = 0
        }
    }

    /**
     * Algoritmo para encontrar el substring mas largo posible sin caracteres repetidos
     * abcbda -> cbda
     * abcabcbd  -> abc
     */

    @Test
    fun substringAlgorithm() {
        val input = "abcabcb"
        val input2 = "pewfpjko"
        val input3 = "pwwkew"

        val inputArray: List<Char> = input.toList()
        var maxLength = 0
        val map = HashMap<Char, Int>()
        var left = 0
        var right = 0
        var ans = 0
        for (i in inputArray.indices) {
            if (map.containsKey(inputArray[i])) {
                left = max(map[inputArray[i]]?.plus(1) ?: 0, left)
            }
            right += 1
            map[inputArray[i]] = i
            ans = max(right - left, ans)
        }
    }

    @Test
    fun findFirstAndLast() {
        val list = listOf(3, 0, 2, 2, 0, 1, 0, 3)
        val target = 2
        val firstOccurence = list.indexOfFirst { it == target }
        val endOccurence = list.indexOfLast { it == target }
    }

    /**
     * Dada una lista de integers, encuentra la version fallida, esto suponiendo que se tiene una
     * funcion que retorna true/false dado un input; No se sabe cual es la version (numero) que esta fallido
     * Con la funcion debe uno encontrar dicho numero (version)
     */
    @Test
    fun findWrongVersion() {
        var isWrongVersion = isWrongVersion(3)
        val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        var i = 0
        var j = list.size
        while (i < j) {
            var midIndex: Int = (j + i) / 2
            if (isWrongVersion(list[midIndex])) {
                j = midIndex
            } else {
                i = midIndex + 1
            }
        }
        val answer = i
    }

    private fun isWrongVersion(i: Int): Boolean = i >= 3

    /**
     * find the missing number un the list
     */

    @Test
    fun missingNumber() {
        //val list = listOf(0, 1, 2, 4, 5, 6, 7, 8, 9)
        var list = listOf(1, 0, 2, 3)
        var missing = 0
        list = list.sorted()
        list.forEachIndexed { index, i ->
            if (index + 1 < list.size) {
                if (i + 1 != list[index + 1]) {
                    missing = i + 1
                    return@forEachIndexed
                }
            } else if (missing == 0) {
                missing = list.size
            }
        }
        val ans = missing

        //Solucion optimal
        val currentSum = list.sum()
        val n = list.size
        val expectedSum = (n * (n+1))/2
        val respuesta = (expectedSum - currentSum).toInt()
    }


    @Test
    fun quantityPrimes() {
        val number = 10

        val quantity: Int = getCountPrimes(number)
        val a = 3

    }

    private fun getCountPrimes(number: Int): Int {
        var count = 0
        var isPrime: Boolean = false

        for (num in 2 until number) {
            isPrime = true
            for (j in 2 until num) {
                if (num%j == 0) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) count++
        }
        return count
    }

    @Test
    fun findSingle() {
        val list = listOf(7, 1, 2, 1, 5, 2, 3, 5, 3)
        val mapGroupByMates = list.groupBy { it }
        val single = mapGroupByMates.values.find { it.size == 1 }
        val a = 2
    }


    @Test
    fun robotPosition() {
        val direcction = "udlrruu"
        var y = 0
        var x = 0
        direcction.toList().map { char ->
            when (char) {
                'u' -> {
                    y++
                }
                'd' -> {
                    y--
                }
                'r' -> {
                    x++
                }
                'l' -> {
                    x--
                }
                else -> {
                }
            }
        }
    }

    @Test
    fun sumBinary() {
        val numberBinaryOne = "11101"
        val numberBinaryTwo = "10101"
        val listOne = numberBinaryOne.toList()
        val listTwo = numberBinaryTwo.toList()


        val isBinaryOne = getIsBinary(listOne)
        val isBinaryTwo = getIsBinary(listTwo)

        if (isBinaryOne && isBinaryTwo) {
            val getDecimal = getDecimalNumber(listOne)
        }

    }

    private fun getDecimalNumber(list: List<Char>): Int {
        val n = list.size
        val listIncremental = mutableListOf<Long>()
        for(i in 0 .. n) {
            listIncremental.add(2.0.pow(i).toLong())
        }
        val listSum = mutableListOf<Long>()
        list.forEachIndexed { index, char ->
            listSum.add(listIncremental[index]*(char.toString().toInt()))
        }

        return 0
    }

    private fun getIsBinary(listOne: List<Char>) =
        listOne.find { it != '0' && it != '1' } == null


}