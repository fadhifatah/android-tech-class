package exercise.part_one

/*
 * Exercise 0: Hello World!
 */
var hello: String = TODO("Isi dengan Hello World!")

/*
 * Exercise : Simple String & Variable
 *
 * Modifikasi variable tripleQuotedString, agar ketika di-print menghasilkan:

>"Hello World!"

>Perkenalkan, saya Budi.
>Umur 17 tahun asal Jakarta

 * Dimana indentasi pada variable tripleQuotedString dihapus menggunakan extension funtion dari Indent.kt,
 * lalu gunakan variable: hello, name, age dan city
 *
 * Hint: Ubah indentasi dengan extension function replaceIndentByMargin(newIndent, marginPrefix)
 *
 */
var name = "Budi"
var age = 17
var city = "Jakarta"

const val tripleQuotedString = """
    #"hello"
    
    #Perkenalkan, saya name.
    #Umur age tahun asal city """ // TODO("0.1 Masukkan variable, lalu ubah indentasi pada tripleQuotedString")

/*
 * Exercise 1: Simple Math
 *
 * Penjumlahan berbeda tipe data. Gunakan casting ke tipe data yang dibutuhkan
 */
var x = 1000
var y = 1000L

var result: Int = TODO("1.1 Buat operasi x + y dengan hasil berupa Integer. Perlu diingat bahwa y merupakan Long, bukan Integer")

/*
 * Exercise 2: Palindrome text
 *
 * Tebak apakah suatu kata merupakan kata palindrom atau bukan. Kata palindrom adalah sebuah kata yang jika dibalik urutan
 * pada setiap hurufnya, akan menghasilkan kata yang sama.
 * Bisa juga disimpulkan kalau huruf pada 0 dan n pada n length sebuah kata akan sama. 0 == n, 1 == n-1, 2 == n-2, ...
 * dan seterusnya
 *
 * Contoh:
 * "Akan" akan return false
 * "Ada" akan return true
 * "Amma" akan return true
 */
fun isPalindrome(text: String): Boolean {
    TODO("2.1 Check apakah text merupakan kata palindrom")
}

/*
 * Exercise 3: Syntax inside String
 *
 * Buat sebuah logic menggunakan if-else atau when expression di dalam sebuah String block menggunakan ${}. Sebuah String
 * pada Kotlin dapat berisi code/syntax apapun yang mereturn sebuah String juga :)
 *
 * Contoh:
 * "Hasil dari x + y adalah 123, yang merupakan bilangan positif"
 *
 * Catatan:
 * n < 0 adalah negatif, sebaliknya positif (0 akan dibaca positif juga)
 */
var resultWithWording =
    "Hasil dari x + y adalah $result, yang merupakan bilangan ${TODO("3.1 Return apakah $result merupakan bilangan positif atau negatif. Gunakan if-else atau when expression")}"

/*
 * Exercise 4: Prime Factor
 *
 * Lengkapi function primeFactor! Function ini bertujuan untuk membuat sebuah Map himpunan bilngan faktorisasi prima
 *
 * Overview:
 * Untuk mencari bilangan-bilangan prima dari suatu angka, angka tersebut perlu dibagi oleh bilangan-bilangan prima terkecil.
 * Pertama-tama, bagi oleh bilangan prima terkecil, 2, terlebih dahulu. Lalu, hasil dari pembagian akan dibagi lagi, hingga "habis".
 * Bilangan-bilangan prima tersebut yang habis membagi suatu angka merupaka faktorisasi prima dari angka tersebut.
 *
 * Contoh:
 * Faktorisasi prima dari 12 adalah 2 * 2 * 3 = 2^2 * 3
 * Faktorisasi prima dari 29 adalah 29 itu sendiri
 * Faktorisasi prima dari 120 adalah 2 * 2 * 2 * 3 * 5 = 2^3 * 3 * 5
 *
 * Goal:
 * Function ini akan melakukan mapping faktorisasi prima. Sehingga, bentuk dari 2 * 2 * 2 * 3 * 5 akan menjadi
 * { 2=3, 3=1, 5=1}. Key merupakan bilangan prima, Value merupakan pangkat dari bilangan prima tersebut
 *
 */
fun primeFactor(n: Int): Map<Int, Int> {
    var number = n
    val mapPrimeFactor = HashMap<Int, Int>()

    // Bagi dengan bilangan prima terkecil terlebih dahulu
    // Dimulai dari angka 2
    while (number % 2 == 0) {
        mapPrimeFactor[2] = (mapPrimeFactor[2] ?: 0) + 1 // Memasukkan counter dari bilangan prima tersebut
        number /= 2 // Update number
    }

    // Lalu bagi dengan bilangan prima lainnya (setelah 2: yaitu 3, 5, 7, ...)
    // Iterasi dengan melongkapi langkah sebanyak 2 angka, karena bilangan prima dan seterusnya merupakan bilangan ganjil :)
    // Iterasi sampai dengan akar dari bilangan yang dicari ($number).
    //
    // Trivia: Mengapa hanya sampai dengan "akar dari bilangan yang dicari ($number)"?
    // Karena anggota himpunan bilangan prima terbesar yang bisa habis membagi suatu bilangan tidak akan pernah lebih dari
    // setengah suatu bilangan/akar dari suatu bilangan, sehingga cukup melakukan iterasi hanya sampai itu. Kecuali,
    // bilangan tersebut adalah bilangan prima, sehingga himpunan faktorisasi prima hanya dirinya sendiri :)
    //
    // Gunakan sqrt() dari Math untuk mencari hasil dari akar suatu bilngan
    for (TODO("4.1 Buat sintaks iterasi dari 3 sampai dengan akar dari bilangan $number dengan menlongkap sebanyak 2 angka")) {
        // Dimulai dari angka 3
        while (TODO("Code: Selama masih habis dibagi dengan bilangan $i, terus bagi sampai tidak dapat dibagi lagi")) {
            mapPrimeFactor[i] = TODO("4.2 Masukkan ke dalam Map mapPrimeFactor")
            number /= i // Update number
        }
    }

    // Ini adalah sisa dari faktorisasi terakhir, kalau masih ada bilangan prima yang habis membagi $number
    if (number > 2) mapPrimeFactor[number] = (mapPrimeFactor[number] ?: 0) + 1

    return mapPrimeFactor
}
