package answer

import exercise.part_two.*

fun eval(expr: Expr): Int =
    when(expr) {
        is Num -> expr.value
        is Sum -> eval(expr) + eval(expr)
        else -> throw IllegalArgumentException("Unknown expression")
    }

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            year != other.year -> year - other.year
            month != other.month -> month - other.month
            else -> dayOfMonth - other.dayOfMonth
        }
    }
}

class Helper {
    var userId: String
        get() = Storage.get("userId", "null")
        set(value) {
            Storage.set("userId", value)
        }

    var status: String
        get() = Storage.get("status", "inactive")
        set(value) { Storage.set("status", value) }
}

class DataManager {
    companion object {
        fun build(): DataManager = DataManager()
    }

    fun getProfiles() {
        print("Ceritanya akses endpoint untuk ambil daftar profil dari user")
    }
}

class Presenter(val dataManager: DataManager)

class Fragment {
    private val presenter = Presenter(DataManager.build())

    fun initiateView() {
        presenter.dataManager.getProfiles() // TODO("Compile error. Ubah properti di dalam class Presenter sehingga bisa mengambil dataManager dari presenter")
    }
}

fun <K, V> buildMutableMap(build: HashMap<K, V>.() -> Unit): Map<K, V> {
    val mapping = HashMap<K, V>()
    mapping.build()
    return mapping
}

fun Int.isEven(): Boolean = this % 2 == 0

fun Int.isOdd(): Boolean = this % 2 == 1

fun run() {
    val temporary_1 = getSomething(4)
    val temporary_2 = getSomething(1)

    process(temporary_2!!)
    temporary_1?.let { process(it) }
}

fun <T> T.custom(f: T.() -> Unit): T {
    f()
    return this
}

fun createString(): String {
    return StringBuilder().custom {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

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
    print(MyDate(2021, 2, 12) < MyDate(2021, 1, 1)) // false

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