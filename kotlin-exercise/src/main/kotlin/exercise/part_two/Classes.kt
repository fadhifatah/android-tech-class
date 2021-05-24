package exercise.part_two

/*
Exercise 0: Smart cast

Contoh di Java:
public int eval(Expr expr) {
    if (expr instanceof Num) {
        return ((Num) expr).getValue();
    }
    if (expr instanceof Sum) {
        Sum sum = (Sum) expr;
        return eval(sum.getLeft()) + eval(sum.getRight());
    }
    throw new IllegalArgumentException("Unknown expression");
}

Dengan smart cast dari Kotlin, syntax di atas bisa diubah dengan menggunakan when expression.
Silakan lengkapi TODO() di bawah.

*/
fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> TODO("Return value dari instance Num")
        is Sum -> TODO("Return hasil penjumlahan dari properti di Sum")
        else -> throw IllegalArgumentException("Unknown expression")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/*
Exercise 1: Interface implementation

Comparable memiliki function compareTo() yang harus dideklarasikan oleh class yang me-inheritance terhadap dirinya.
Cek main() di bawah, untuk mengetahui implementasi sudah benar atau salah
*/
class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    TODO("Implementasi comparable di MyDate")
}

/*
Exercise 2: Properties get/set

Sebuah variable properti di dalam class bisa memiliki get/set sendiri. get/set pada properti tersebut bisa didefinisikan
untuk merubah/mengambil dari instance lain. Pada kasus ini, Helper menggunakan Storage untuk menyimpan dan mengambil data.

// Contoh penggunaan!
val helper = Helper()

helper.userId = "abc123"
helper.status = "active"

print(helper.status) // "active"
 */
class Helper {
    var userId: String
        get() = Storage.get("userId", "null")
        set(value) {
            Storage.set("userId", value)
        }

    var status: String
        TODO("Implementasi get/set dimana, key yang digunakan adalah \"status\", default value ketika get adalah \"inactive\"")
}

// Jangan diubah!
final class Storage {
    companion object {
        private val mapping: HashMap<String, String> = HashMap()

        fun get(key: String, default: String): String = mapping[key] ?: default

        fun set(key: String, value: String) {
            mapping[key] = value
        }
    }
    }

/*
Exercise 3: Properties access

Sebuah parameter di dalam constructor, bisa menjadi properti yang dapat dipanggil dari objek tersebut. Dengan menggunakan
val/var akan mendefinisikan bahwa variable tersebut merupakan properti dari suatu constructor, sehingga dapat dipanggil
di tempat lain dari instance class tersebut.
 */
class DataManager {
    companion object {
        fun build(): DataManager = DataManager()
    }

    fun getProfiles() {
        print("Ceritanya akses endpoint untuk ambil daftar profil dari user")
    }
}

class Presenter(dataManager: DataManager)

class Fragment {
    private val presenter = Presenter(DataManager.build())

    fun initiateView() {
        presenter.dataManager.getProfiles() // TODO("Compile error. Ubah properti di dalam class Presenter sehingga bisa mengambil dataManager dari presenter")
    }
}

// Pastikan tidak ada error di sini
fun main(args: Array<String>) {
    print(MyDate(2021, 2, 12) < MyDate(2021, 1, 1)) // false
}
