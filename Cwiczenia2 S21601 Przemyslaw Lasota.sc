/*1 Wykorzystaj Pattern Matching w funkcji przyjmującej parametr typu String.
 Dla stringów odpowiadających nazwom dni tygodnia funkcja ma zwrócić „Praca” i „Weekend”
 (odpowiednio dla dni roboczych i wolnych), dla pozostałych napisów „Nie ma takiego dnia”.*/


var tydzien=List("Poniedzialek","Wtorek","Sroda","Czwartek","Piatek","Sobota","Niedziela")

def JakiDzien(Dzien:String):String= Dzien.toUpperCase() match {

  case "PONIEDZIALEK" =>"Praca"
  case "WTOREK" =>"Praca"
  case "SRODA" =>"Praca"
  case "CZWARTEK" =>"Praca"
  case "PIATEK" =>"Praca"
  case "SOBOTA" =>"Weekend"
  case "NIEDZIELA" =>"Weekend"
  case _ =>"Nie ma takiego dnia"

}

JakiDzien("niedziela")
JakiDzien("luty")

/* 2 Zdefiniuj klasę KontoBankowe z metodami wplata i wyplata
 oraz własnością stanKonta - własność ma być tylko do odczytu.
  Klasa powinna udostępniać konstruktor przyjmujący początkowy stan konta
   oraz drugi, ustawiający początkowy stan konta na 0*/

class KontoBankowe(val StanKonta:Double) {
  def wplata() = {println("to jest metoda wplata")}
  def wylata()={println("to jest metoda wyplata")}

  var PoczatkowyStanKonta: Double=0

  def this(StanKonta: Double,PoczatkowyStanKonta:Double){
    this(StanKonta)
    this.PoczatkowyStanKonta=PoczatkowyStanKonta
  }

}

val x= new KontoBankowe(StanKonta = 120,PoczatkowyStanKonta = 2)
x.StanKonta
x.wplata()
x.PoczatkowyStanKonta

/* 3 Zdefiniuj klasę Osoba z własnościami imie i nazwisko.
Stwórz kilka instancji tej klasy. Zdefiniuj funkcję, która
przyjmuje obiekt klasy osoba i przy pomocy Pattern Matching wybiera
 i zwraca napis zawierający przywitanie danej osoby.
  Zdefiniuj 2-3 różne przywitania dla konkretnych osób (z określonym imionami lub nazwiskami)
  oraz jedno domyślne. */

class Osoba(val Imie:String,val Nazwisko:String){
 def witam(osoba: Osoba):String= osoba.Imie match {
   case "Przemek"=>"Czesc Przemo!"
   case "Robert"=>"Czesc Rob!"
   case _ =>"Czesc ty tam!"
 }
}
val Przemek= new Osoba("Przemek",Nazwisko = "Kowalski")
val Robert=new Osoba (Imie= "Robert",Nazwisko= "Lewandowski")
val Janusz=new Osoba(Imie = "Janusz",Nazwisko = "Nowak")
Przemek.witam(Przemek)
Robert.witam(Robert)
Janusz.witam(Janusz)

/*4 Zdefiniuj funkcję przyjmującą dwa parametry -
wartość całkowitą i funkcję operującą na wartości całkowitej.
Zastosuj przekazaną jako parametr funkcję trzykrotnie do wartości całkowitej i zwróć wynik.*/
val fx=(x:Int)=>x*x+1

def funkcjaZlozona(fx:Int=>Int,y: Int):Int={

  var wynik=fx(y)*fx(y-1)*fx(y-2)
  return wynik
}
funkcjaZlozona(fx,2)

/*5  Zdefiniuj klasę Osoba i trzy traity: Student, Nauczyciel, Pracownik. Osoba powinna mieć własności
read only: imie, nazwisko, podatek. Pracownik powinien mieć własność pensja (z getterem i seterem).
Student i Pracownik powinni przesłaniać własność podatek – dla Studenta zwracamy 0, dla Pracownika 20% pensji.
 Nauczyciel powinien dziedziczyć z Pracownika, dla niego podatek zwraca 10% pensji.
  Stwórz obiekty z każdym z traitów, pokaż jak podatek działa dla każdego z nich.
  Stwórz obiekty z traitami Student i Pracownik, pokaż jak podatek zadziała w zależności
  od kolejności w jakiej te traity zostały dodane przy tworzeniu obiektu. */


class Osoby(val Imie:String,val Nazwisko:String,val Podatek:Double)   {

}

trait Pracownik extends Osoby {
  var Pensja:Double=5000
  override val Podatek=0.2
}


trait Student extends Osoby {
  override val Podatek=0.0
}

trait Nauczyciel extends Pracownik {
  override val Podatek=0.1*Pensja
}


val x=new Osoby(Imie = "Jarek","Kowalski",Podatek = 0.6) with Nauczyciel
println(x.Imie,x.Nazwisko,x.Podatek)
val x1=new Osoby(Imie = "Marek","Michalak",Podatek = 0.6) with Student
println(x1.Imie,x1.Nazwisko,x1.Podatek)
val x2=new Osoby(Imie = "Michal","Nowak",Podatek = 0.6) with Pracownik
println(x2.Imie,x2.Nazwisko,x2.Podatek)
val x3=new Osoby(Imie = "Robert","Lewandowski",Podatek = 0.6)
println(x3.Imie,x3.Nazwisko,x3.Podatek)
val x4=new Osoby(Imie = "Maniek","Budka",Podatek = 0.6) with Pracownik with Student
println(x4.Imie,x4.Nazwisko,x4.Podatek)
val x5=new Osoby(Imie = "Maniek","Budka",Podatek = 0.6) with Student with Pracownik
println(x5.Imie,x5.Nazwisko,x5.Podatek)



