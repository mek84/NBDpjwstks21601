/*     1. Stwórz 7 elementową listę zawierającą nazwy dni tygodnia. Napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
        a. Pętli for
        b. Pętli for wypisując tylko dni z nazwami zaczynającymi się na „P”
        c. Pętli while
*/

var tydzien=List("Poniedzialek","Wtorek","Sroda","Czwartek","Piatek","Sobota","Niedziela")

var wynik1:String=""

def zad1a()={
  for (x<-tydzien){
    wynik1+=x+","}
    println(wynik1.dropRight(1))

}
zad1a()

var wynik2:String=""

def zad1b()={
  for (x<-tydzien){
    if (x.startsWith("P"))
    wynik2+=x+","}
  println(wynik2.dropRight(1))
}
zad1b()

var wynik3:String=""

def zad1c()={
  var i=0
  while (i<tydzien.length){
      wynik3+=tydzien(i)+","
      i+=1}
  println(wynik3.dropRight(1))
}

zad1c()
/*    2. Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi
          przecinkami korzystając z:
        a. Funkcji rekurencyjnej
        b. Funkcji rekurencyjnej wypisując elementy listy od końca*/

def zad2a(lista: List[String]): String={

  if (lista.isEmpty) {""}
  else if( lista.tail.isEmpty) {
    lista.head+zad2a(lista.tail)}
  else
    {lista.head+","+zad2a(lista.tail)}
  }

println(zad2a(tydzien))

def zad2b(lista: List[String]): String={

  if (lista.isEmpty) {""}
  else if( lista.tail.isEmpty) {
    zad2b(lista.tail) + lista.head

  }

  else
  {zad2b(lista.tail)+","+lista.head
}
}
println(zad2b(tydzien))
/*Stwórz funkcję korzystającą z rekurencji ogonowej do zwrócenia oddzielonego
 przecinkami stringa zawierającego elementy listy z ćwiczenia 1 */

def zad3(lista: List[String]): String={

  if (lista.isEmpty) {""}
  else if( lista.tail.isEmpty) {
    lista.head+zad3(lista.tail)}

  else
  {lista.head+","+zad3(lista.tail)
  }
}
/*     4. Dla listy z ćwiczenia 1 napisz funkcję tworzącą w oparciu o nią stringa z elementami oddzielonymi przecinkami korzystając z:
        a. Metody foldl
        b. Metody foldr
        c. Metody foldl wypisując tylko dni z nazwami zaczynającymi się na „P”*/


//a
def odlewej(lista: List[String]):String= {lista.foldLeft("")((a, b) => a + b + ",").dropRight(1)}
println(odlewej(tydzien))

//b
def odprawej(lista: List[String]):String= {lista.foldRight("")((a, b) => a +","+ b).dropRight(1)}
println(odprawej(tydzien))
//c
def odlewejTylkoP(lista: List[String])= { lista.foldLeft("")((a, b) => if (b.startsWith("P")) a + b + "," else a).dropRight(1)}

odlewejTylkoP(tydzien)

/*  5 Stwórz mapę z nazwami produktów i cenami.
 Na jej podstawie wygeneruj drugą, z 10% obniżką cen. Wykorzystaj mechanizm mapowania kolekcji. */

val cennik = scala.collection.mutable.Map("kawa"->45.0, "telefon"->1230.0,"lampka"->178.0)
val przecena= scala.collection.mutable.Map[String,Double]()
for ((k,v)<-cennik) przecena += k->v*0.9
println(przecena)

/* 6 Zdefiniuj funkcję przyjmującą krotkę z 3 wartościami różnych typów i wypisującą je*/
val zbior =Tuple3("pies",23,0.5)
def krotka(krotka: Tuple3[String, Int, Double] ) = {
  val (a,b,c) = krotka
  println((a,b,c))
}

krotka(zbior)


/* 7 Zaprezentuj działanie Option na dowolnym przykładzie
 (np. mapy, w której wyszukujemy wartości po kluczu) */

val cennik = scala.collection.mutable.Map("kawa"->45.0, "telefon"->1230.0,"lampka"->178.0)

val x = cennik.get("piwo").getOrElse("brak klucza")
val y = cennik.get("kawa").getOrElse("brak klucza")

/* 8 Napisz funkcję usuwającą zera z listy wartości całkowitych
 (tzn. zwracającą listę elementów mających wartości różne od 0).  Wykorzystaj rekurencję. */
val liczby = List(1,1,0,2,0,3,5,6,7,8,0,0)

def usunZera(lista:List[Int]):List[Int]=lista match {
  case Nil=>Nil
  case h::t=> if (h==0) usunZera(t)
  else h::usunZera(t)
}
usunZera(liczby)

/* 9 Zdefiniuj funkcję, przyjmującą listę liczb całkowitych
 i zwracającą wygenerowaną na jej podstawie listę,
 w której wszystkie liczby zostały zwiększone o 1. Wykorzystaj mechanizm mapowania kolekcji. */

val liczby = List(1,1,0,2,0,3,5,6,7,8,0,0)

def zwiekszJeden(lista: List[Int]):List[Int]={

  lista map (n=>n+1)
}

zwiekszJeden(liczby)

/* 10 Stwórz funkcję przyjmującą listę liczb rzeczywistych
 i zwracającą stworzoną na jej podstawie listę zawierającą
 wartości bezwzględne elementów z oryginalnej listy należących do przedziału <-5,12>.
  Wykorzystaj filtrowanie.*/

val liczby = List(1.1,0.5,0,2.222,0,-3,5,6,-7,8,100,0)

def FiiltrujListe(lista: List[Double]):List[Double]={

  lista.filter( _ > -5.0).filter( _ <12.0).map(_.abs)
}

FiiltrujListe(liczby)







