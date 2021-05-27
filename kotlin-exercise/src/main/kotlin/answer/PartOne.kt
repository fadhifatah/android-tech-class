package answer

import exercise.part_one.*
import kotlin.math.sqrt

val tripleQuotedString = """
    #"$hello"
    
    #Perkenalkan, saya $name.
    #Umur $age tahun asal $city """.replaceIndentByMargin(">", "#")

val result: Int = x + y.toInt()

fun isPalindrome(text: String): Boolean {
    return text == text.reversed()
}

var resultWithWording =
    "Hasil dari x + y adalah ${exercise.part_one.result}, yang merupakan bilangan ${
        if (result % 2 == 0) "genap" else "ganjil"
    }"

fun primeFactor(n: Int): Map<Int, Int> {
    var number = n
    val mapPrimeFactor = HashMap<Int, Int>()

    while (number % 2 == 0) {
        mapPrimeFactor[2] = (mapPrimeFactor[2] ?: 0) + 1 // Memasukkan counter dari bilangan prima tersebut
        number /= 2 // Update number
    }

    for (i in 3..sqrt(n.toDouble()).toInt()) {
        // Dimulai dari angka 3
        while (number % i == 0) {
            mapPrimeFactor[i] = (mapPrimeFactor[i] ?: 0) + 1
            number /= i // Update number
        }
    }

    // Ini adalah sisa dari faktorisasi terakhir, kalau masih ada bilangan prima yang habis membagi $number
    if (number > 2) mapPrimeFactor[number] = (mapPrimeFactor[number] ?: 0) + 1

    return mapPrimeFactor
}

fun containsOdd(collection: Collection<Int>): Boolean =
    collection.any { it % 2 == 1 }

fun fizzBuzzList(length: Int): List<String> =
    (1..length).map { fizzBuzz(it, 3, 5) }

fun convertToFizzBuzz(collection: List<Int>): List<String> =
    collection.map { fizzBuzz(it, 3, 5) }

fun Shop.getCustomersSortedByOrders(): List<Customer> =
    customers.sortedByDescending { it.orders.size }

fun Shop.getCustomerCities(): Set<City> =
    customers.map { it.city }.toSet()

fun Shop.getCustomersFrom(city: City): List<Customer> =
    customers.filter { it.city == city }

// Cek apakah setiap customer pada Shop berasal dari city yang sama
fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
    customers.all { it.city == city }

fun Shop.hasCustomerFrom(city: City): Boolean =
    customers.any { it.city == city}

// Me-return sebuah jumlah dari banyaknya customer yang berasal dari city yang diberikan
fun Shop.countCustomersFrom(city: City): Int =
    getCustomersFrom(city).size

// Me-return sebuah customer yang berasal dari city yang diberikan, atau null jika tidak ada
fun Shop.findCustomersFrom(city: City): Customer? =
    customers.find { it.city == city }

// Me-return sebuah customer yang memiliki order terbanyak pada suatu Shop
fun Shop.getCustomerWithMaxOrders(): Customer? =
    customers.maxByOrNull { it.orders.size }

// Me-return product termahal yang dimiliki oleh seorang customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.flatMap { it.products }.maxByOrNull { it.price }

// Me-return total nominal yang dikeluarkan oleh customer dari product yang di-order
fun moneySpentBy(customer: Customer): Double =
    customer.orders.flatMap { it.products }.sumByDouble { it.price }

// Return sebuah pemetaan (mapping) nama customer dan objek customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
    customers.associateBy { it.name }

// Return sebuah pemetaan (mapping) customer dan city-nya
fun Shop.customerToCityMap(): Map<Customer, City> =
    customers.associateWith { it.city }

// Return sebuah pemetaan (mapping) nama customer dan city-nya
fun Shop.customerNameToCityMap(): Map<String, City> =
    customers.associate { it.name to it.city }

// Return sebuah pemetaan (mapping) dari pengelompokan sebuah city dan list customer pada city tersebut
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
    customers.groupBy { it.city }

// Return customer mana saja yang memiliki order tidak terkirim lebih banyak dari order terkirim.
// Order dengan isDelivered = false lebih banyak dari isDelivered = true
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    customers.filter {
        val (delivered, undelivered) = it.orders.partition(Order::isDelivered)
        undelivered.size > delivered.size
    }.toSet()

// Me-return list product yang dipesan oleh customer. Return semua product, dapat berulang
fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }

// Me-return set product yang dipesan oleh semua customer (setidaknya satu customer).
// Return semua product yang dipesan di shop tersebut, tidak berulang
fun Shop.getOrderedProducts(): Set<Product> =
    customers.flatMap { it.getOrderedProducts() }.toSet()

// Return berapa kali sebuah product dipesan di shop tersebut. Catatan: product serupa dapat dipesan berkali-kali oleh
// customer yang sama
fun Shop.countProductWasOrdered(product: Product): Int =
    customers.flatMap { it.getOrderedProducts() }.count { it == product }

fun doSomething(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { it.length }
    val maximumSizeOfGroup = groupsByLength.values.map { it.size }.maxOrNull() // Ini akan mencari max dari list ini
    return groupsByLength.values.firstOrNull { it.size == maximumSizeOfGroup }
}

fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number
}

public inline fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(first: C, second: C, predicate: (T) -> Boolean): Pair<C, C> {
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}

// Pastikan tidak ada error di sini
fun main(args: Array<String>) {
    // These codes must compiled
    foo(name = "Budi", toUpperCase = true)
    foo("Budi")
    foo("Budi", 23)

    // These codes must compiled
    val (words, lines) = listOf("a", "a b c", "b", "c", "d e", "f g", "d")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    print(words == listOf("a", "b", "c", "d")) // true
    print(lines == listOf("a b c", "d e", "f g")) // true

    // These codes must compiled
    val (letters, symbols) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    print(letters == setOf('a', 'r')) // true
    print(symbols == setOf('%', '}')) // true
}