package exercise.part_two

/*
Exercise 4: Builder function

Perhatikan buildString() di bawah, lalu lakukan hal yang sama menyerupai buildString() untuk membuat suatu HashMap!
 */
fun buildString(build: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.build()
    return stringBuilder.toString()
}

// TODO("Buat sebuah builder dengan nama buildMutableMap(), seperti buildString()")

/*
Exercise 5: Extension function

Sebuah function tambahan untuk spesifik class/object. Memiliki instance dalam bentuk `this` untuk mengaksesnya.

Lengkapi extension function isEven() untuk mengembalikan boolean dalam mendeteksi apakah suatu bilangan integer
merupakan bilangan genap atau bukan.
Lalu buat hal serupa, extension function isOdd(), untuk mendeteksi apakah suatu bilangan integer merupakan bilangan
ganjil atau bukan.
 */
fun Int.isEven(): Boolean {
    return TODO("Return true jika genap")
}

// TODO(""Buat extension function serupa untuk isOdd())

/*
Exercise 6: Scope function dan Null safety

Perhatikan code di bawah! Null safety pada Kotlin bertujuan agar setiap objek yang dapat bernilai null tidak dapat
disatukan dengna objek tidak pernah null. Contoh: String? tipe data yang dapat bernilai null, tidak dapat disimpan
ke dalam variable String yang tidak boleh menerima null. Bila dipaksakan akan terjadi compile error.

Scope function terdiri dari let, apply, run, with, also. Masing-masing memiliki bentuk tersendiri yang dapat digunakan
dalam berbagai kebutuhan, silakan dipelajari terlebih dahulu!
 */
val mapOfString = hashMapOf(1 to "Satu", 2 to "Loro", 3 to "Seth", 4 to "Four", 5 to "Go")

fun getSomething(index: Int): String? = mapOfString[index]

fun process(text: String) {
    print("Belajar angka $text")
}

fun run() {
    val temporary_1 = getSomething(4)
    val temporary_2 = getSomething(1)

    process(temporary_2) // TODO("Gunakan syntax !! untuk menjelaskan pada Kotlin, bahwa variable tersebut tidak bernilai null. Tapi harap hati-hati dalam menggunakan `!!`, selalu pastikan tidak return null")
    process(temporary_1) // TODO("Error. Gunakan `let` dan safe call agar process() bisa dijalankan jika $temporary tidak null")
}

/*
Exercise 7: Scope function

Implementasi sebuah scope function baru bernama custom, custom memiliki syntax yang sama dengan apply
 */
fun <T> T.custom(f: T.() -> Unit): T {
    TODO("Lengkapi syntax di dalam sini, agar dapat berfungsi sebagai apply pada scope function :)")
}

// Pastikan tidak ada error
fun createString(): String {
    return StringBuilder().custom {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

// Pastikan tidak ada error
fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().custom {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

// Pastikan tidak ada error di sini
fun main(args: Array<String>) {
    val s = buildString {
        this.append("Numbers: ")
        for (i in 1..3) {
            // 'this' can be omitted
            append(i)
        }
    }

    val mapping: Map<Int, String> = buildMutableMap {
        put(0, "0")
        for (i in 1..5) {
            put(i, "$i")
        }
    }

    val angka = 123

    println(s == "Numbers: 123") // true
    println(mapping) // {0=0, 1=1, 2=2, 3=3, 4=4, 5=5}
    println(angka.isEven()) // false
    println(angka.isOdd()) // true
}