package exercise.part_one

/*
 * Exercise 5: Lambda di Collection
 *
 * Cari tahu apakah sebuah list dari bilangan Integer mengandung bilangan ganjil.
 * Gunakan any untuk mencari jika terdapat bilangan ganjil dengan mengimplementasi
 * sebuah predikat!
 *
 * Contoh:
 * [1, 1, 2, 3, 4, 5, 6, 6] akan return true karena punya angka ganjil
 * [2, 2, 4] akan return false karena tidak punya angka ganjil di dalamnya
 */
fun containsOdd(collection: Collection<Int>): Boolean =
    collection.any { TODO("5.1 Validasi sebuah lambda untuk mencari tahu bilangan ganjil") }

// Mencari kalimat FizzBuzz dari suatu angka integer
fun fizzBuzz(index: Int, fizz: Int = 3, buzz: Int = 7): String {
    return when {
        index % fizz == 0 && index % buzz == 0 -> "FizzBuzz"
        index % fizz == 0 -> "Fizz"
        index % buzz == 0 -> "Buzz"
        else -> "$index"
    }
}

/*
 * Exercise 6.1: Simple List part 1
 *
 * Buat sebuah list dengan ukuran sebanyak length. Jika length adalah 5 maka akan membuat list dengan size = 5.
 * List tersebut merupaka list dari FizzBuzz, dimana untuk setiap item akan berupa Fizz, Buzz, atau FizzBuzz
 *
 * Contoh:
 * Misalkan menggunakan fizzBuzz() dengan default parameters: fizz = 3 dan buzz = 7
 * - length = 5, akan menghasilkan list = [1, 2, Fizz, 4, 5], size = 5
 * - length = 20, akan menghasilkan list = [1, 2, Fizz, 4, 5, Fizz, Buzz, 8, Fizz, 10, 11, Fizz, 13, Buzz, Fizz, 16, 17, Fizz, 19, 20], size = 20
 */
fun fizzBuzzList(length: Int): List<String> {
    TODO("6.1.1 Buat List dari himpunan FizzBuzz dengan menggunakan function fizzBuzz() di atas. Parameter fizz = 3 dan buzz = 5")
}

/*
 * Exercise 6.2: Simple List part 2
 *
 * Buat sebuah FizzBuzz list dari list lain. List tersebut berupa List of Integer, contoh: [1, 1, 3, 4, 2, 14, 9, 5, 15].
 * List berisi angka, random tidak berurut. Ubah list tersebut menjadi FizzBuzz list. Gunakan map() extension function
 * dari sebuah Collection. Gunakan pula fizzBuzz() di atas
 *
 * Contoh:
 * Misalkan menggunakan fizzBuzz() dengan default parameters: fizz = 3 dan buzz = 7
 * [1, 1, 3, 4, 2, 14, 9, 5, 15] menjadi [1, 1, Fizz, 4, 2, Buzz, Fizz, 5, Fizz]
 * [] menjadi []
 * [15] menjadi [Fizz]
 */
fun convertToFizzBuzz(collection: List<Int>): List<String> {
    TODO("6.2.1 Ubah List dari angka-angka ke dalam FizzBuzz list")
}

/*
 * Exercise 7: Collection complete
 *
 * Kerjakan beberapa function di bawah
 */
data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)

data class City(val name: String)

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double)

// Me-return sebuah list Customer, terurut secara descending (urutan bawah ke atas, atau sama dengan besar ke kecil)
// berdasarkan banyaknya orders yang dimiliki
fun Shop.getCustomersSortedByOrders(): List<Customer> =
    TODO("7.1 Suggestion: Gunakan sortedbyDescending()")

// Me-return sebuah set City. Cari semua City dari customers yang ada di dalam Shop. Set dari City harus unik semua,
// tidak ada yang berulang
fun Shop.getCustomerCities(): Set<City> =
    TODO("7.2 Suggestion: Gunakan map()")

// Me-return sebuah list Customer. Cari setiap customer yang berasal dari city yang diberikan
fun Shop.getCustomersFrom(city: City): List<Customer> =
    TODO("7.3 Suggestion: Gunakan filter()")

// Cek apakah setiap customer pada Shop berasal dari city yang sama
fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
    TODO("7.4 Suggestion: Gunakan all()")

// Cek apakah ada customer pada Shop berasal dari city yang diberikan
fun Shop.hasCustomerFrom(city: City): Boolean =
    TODO("7.5 Suggestion: Gunakan any()")

// Me-return sebuah jumlah dari banyaknya customer yang berasal dari city yang diberikan
fun Shop.countCustomersFrom(city: City): Int =
    TODO("7.6 Suggestion: Gunakan filter()")

// Me-return sebuah customer yang berasal dari city yang diberikan, atau null jika tidak ada
fun Shop.findCustomersFrom(city: City): Customer? =
    TODO("7.7 Suggestion: Gunakan find()")

// Me-return sebuah customer yang memiliki order terbanyak pada suatu Shop
fun Shop.getCustomerWithMaxOrders(): Customer? =
    TODO("7.8 Suggestion: Gunakan maxByOrNull()")

// Me-return product termahal yang dimiliki oleh seorang customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
    TODO("7.9 Suggestion: Gunakan maxByOrNull()")

// Me-return total nominal yang dikeluarkan oleh customer dari product yang di-order
fun moneySpentBy(customer: Customer): Double =
    TODO("7.10 Suggestion: Gunakan flatmap() terlebih dahulu, lalu sumByDouble()")

// Return sebuah pemetaan (mapping) nama customer dan objek customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
    TODO("7.11 Suggestion: Gunakan associateBy()")

// Return sebuah pemetaan (mapping) customer dan city-nya
fun Shop.customerToCityMap(): Map<Customer, City> =
    TODO("7.12 Suggestion: Gunakan associateWith()")

// Return sebuah pemetaan (mapping) nama customer dan city-nya
fun Shop.customerNameToCityMap(): Map<String, City> =
    TODO("7.13 Suggestion: Gunakan associate()")

// Return sebuah pemetaan (mapping) dari pengelompokan sebuah city dan list customer pada city tersebut
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
    TODO("7.14 Suggestion: Gunakan groupBy()")

// Return customer mana saja yang memiliki order tidak terkirim lebih banyak dari order terkirim.
// Order dengan isDelivered = false lebih banyak dari isDelivered = true
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> =
    TODO("7.15 Suggestion: Gunakan partition() dan filter()")

// Me-return list product yang dipesan oleh customer. Return semua product, dapat berulang
fun Customer.getOrderedProducts(): List<Product> =
    TODO("7.16 Suggestion: Gunakan flatMap()")

// Me-return set product yang dipesan oleh semua customer (setidaknya satu customer).
// Return semua product yang dipesan di shop tersebut, tidak berulang
fun Shop.getOrderedProducts(): Set<Product> =
    TODO("7.17 Suggestion: Gunakan getOrderedProducts() dan flatMap()")

// Return berapa kali sebuah product dipesan di shop tersebut. Catatan: product serupa dapat dipesan berkali-kali oleh
// customer yang sama
fun Shop.countProductWasOrdered(product: Product): Int =
    TODO("7.18 Suggestion: Gunakan flatMap() dan count()")

/*
 * Exercise 8: Learn new style
 *
 * doSomething() merupakan versi ringkas dari doSomething_Old(). Lengkapi syntax pada doSomething() sehingga memiliki
 * goal yang sama dengan doSomething_Old(). Lengkapi TODO()
 */
fun doSomething_Old(
    collection: Collection<String>
): Collection<String>? {
    val groupsByLength = mutableMapOf<Int, MutableList<String>>()
    for (s in collection) {
        var strings: MutableList<String>? = groupsByLength[s.length]
        if (strings == null) {
            strings = mutableListOf()
            groupsByLength[s.length] = strings
        }
        strings.add(s)
    }

    var maximumSizeOfGroup = 0
    for (group in groupsByLength.values) {
        if (group.size > maximumSizeOfGroup) {
            maximumSizeOfGroup = group.size
        }
    }

    for (group in groupsByLength.values) {
        if (group.size == maximumSizeOfGroup) {
            return group
        }
    }
    return null
}

fun doSomething(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { TODO("8.1 Group item berdasarkan panjang karakter")}
    val maximumSizeOfGroup = groupsByLength.values.map { TODO("8.2 Mapping setiap item menjadi size-nya") }//.maxOrNull() // Ini akan mencari max dari list ini
    return groupsByLength.values.firstOrNull { TODO("8.3 Cari pertama kali yang match dengan $maximumSizeOfGroup") }
}