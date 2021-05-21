package exercise.part_one

/*
 * Exercise 9: Default arguments
 *
 * public String foo(String name, int number, boolean toUpperCase) {
 *     return (toUpperCase ? name.toUpperCase() : name) + number;
 * }
 * public String foo(String name, int number) {
 *     return foo(name, number, false);
 * }
 * public String foo(String name, boolean toUpperCase) {
 *     return foo(name, 42, toUpperCase);
 * }
 * public String foo(String name) {
 *     return foo(name, 42);
 * }
 *
 * Ubah bentuk overloads Java ke dalam penggunaan default arguments pada Kotlin
 *
 */
fun foo(/* TODO("9.1 Isi argument sesuai dengan kebutuhan foo() di atas") */): String =
    TODO("9.2 Hapus simbol komen ini") // (if (toUpperCase) name.toUpperCase() else name) + number

// Extension function untuk melakukan partition suatu Iterable (Collection)
public inline fun <T> Iterable<T>.partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
    val first = ArrayList<T>()
    val second = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) {
            first.add(element)
        } else {
            second.add(element)
        }
    }
    return Pair(first, second)
}

/*
 * Exercise 10: Generic type function
 *
 * Buat sebuah extension function generic (menerima berbagai macam jenis tipe data yang telah ditentukan) seperti
 * partition() pada Iterable, contoh ada di atas!
 *
 * Extension function yang akan dibuat ini, menerima 2 parameter tambahan berupa mutable collection untuk
 * storing (menyimpan sementara result sebelum di-return) yang bisa berupa empty collection atau
 * object collection lain sejenis, memiliki fungsi yang sama dengan variable first dan second pada
 * extension function partition() di atas
 */
fun TODO("10.1 Buat Generic type dari function ini") partitionTo(TODO("10.2 Buat parameter yang dibutuhkan dalam bentuk Generic juga. Parameter yang diterima, 2 buah mutable collection dan 1 buah predikat high-order function")) {
    TODO("10.3 Buat syntax logic partition. Referensi: Silakan contek extension function partition dari Iterable")
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