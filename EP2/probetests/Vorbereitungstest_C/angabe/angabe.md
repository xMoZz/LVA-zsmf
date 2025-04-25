# EP2 Test 1

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien
  erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie keine der vorgegebenen Methodensignaturen.
* Implementieren Sie keine unnötigen Getter-/Setter-Methoden.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden in vorgegebenen
  Klassen müssen `private` sein.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen.
* Auch für teilweise korrekte Lösungen werden Punkte vergeben.

## Information zur Domäne

Ein Polynom (`Polynomial`) ist ein mathematischer Ausdruck in einer Variablen 'x' in der Form
a⋅x⁰ + b⋅x¹ + c⋅x² + d⋅x³ + e⋅x⁴ ... . Es ist eine Summe mehrerer Monome (`monomial`), das sind
Terme der Form c⋅xᵈ, wobei 'c' der konstante Koeffizient, 'x' die Variable und 'd' der
konstante Grad des Monoms ist. 'c' und 'd' können jeden Wert annehmen (auch einen negativen Wert
oder 0). Da wir davon ausgehen, dass es in allen Polynomen nur ein und dieselbe Variable 'x'
gibt, kann ein Monom als Paar (c, d) von zwei konstanten Werten (`constants`) dargestellt werden.
Wir nehmen ausserdem an, dass diese zwei konstanten Werte ganze Zahlen sind (`integer constants`).
Zum Beispiel kann das Monom 7⋅x² durch das Paar (7,2) dargestellt werden. Werden zwei Polynome
addiert, kann man im Ergebnis die Monome mit demselben Grad zusammenfassen, indem man deren
Koeffizienten addiert.
Beispiel:
(3⋅x⁰ + 2⋅x² + 1⋅x³) + (7⋅x² + 1⋅x³ + 5⋅x⁴) =
3⋅x⁰ + (2+7)⋅x² + (1+1)⋅x³ + 5⋅x⁴ = 3⋅x⁰ + 9⋅x² + 2⋅x³ + 5⋅x⁴
Diese Gleichung lässt sich auch durch Paare ausdrücken:
[(3,0),(2,2),(1,3)] + [(7,2),(1,3),(5,4)] = [(3,0),(9,2),(2,3),(5,4)]

## Aufgabenstellung

Die für diesen Test relevanten Dateien sind:

* [IntConst](../src/IntConst.java)
* [ConstConstTreeMap](../src/ConstConstTreeMap.java)
* [IntConstQueue](../src/IntConstQueue.java)
* [Polynomial](../src/Polynomial.java)
* [ApplicationTest1](../src/ApplicationTest1.java)
* [MCTest1](../src/MCTest1.java)

Im Praxisteil des Tests sollen davon die hier aufgelisteten Dateien bearbeitet werden:

* [ConstConstTreeMap](../src/ConstConstTreeMap.java)
* [Polynomial](../src/Polynomial.java)

### Teilaufgabe 1 (maximal 25 Punkte)

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die
Datei [MCTest1](../src/MCTest1.java) und befolgen Sie die Anweisungen aus den Kommentaren in der
Datei. Wenn Sie [MCTest1](../src/MCTest1.java) ausführen, bekommen Sie eine Fehlermeldung falls
inhaltlich relevante Textteile verändert wurden; ohne Fehler werden Ihre Antworten auf die Fragen
aufgelistet.

### Teilaufgabe 2 (maximal 75 Punkte)

Erzeugen Sie einen binären Suchbaum in dem Schlüssel vom Typ `IntConst` mit
Werten vom Typ `IntConst` assoziiert werden. Ein solcher
binärer Suchbaum wird durch die Klasse [ConstConstTreeMap](../src/ConstConstTreeMap.java)
repräsentiert. Vervollständigen Sie diese Klasse. Erstellen Sie zu diesem Zweck auch eine eigene
Knotenklasse und wählen Sie für diese Klasse einen geeigneten Namen. Die Ordnung der Schlüssel
im binären Suchbaum entspricht der natürlichen Ordnung von `IntConst` und ist durch die Methoden
`isEqual` und `lessThan` der Klasse [IntConst](../src/IntConst.java) bestimmt. Vervollständingen
Sie neben [ConstConstTreeMap](../src/ConstConstTreeMap.java) auch die Klasse
[Polynomial](../src/Polynomial.java).
Alle anderen gegebenen Dateien sind bereits vollständig. Die Klassen [IntConst](../src/IntConst.java)
und [IntConstQueue](../src/IntConstQueue.java) dürfen nicht verändert werden.
[English translation: Create a binary search tree in which keys of type `IntConst` are associated
with values of type `IntConst`. Such a binary search tree is represented by the class
[ConstConstTreeMap](../src/ConstConstTreeMap.java). Complete this class. For this purpose, also
create your own node class and choose an appropriate name for this class. The ordering of the keys
in the binary search tree corresponds to the natural ordering of `IntConst` and is determined by
the methods `isEqual` and `lessThan` of the class [IntConst](../src/IntConst.java). Also complete
the class [Polynomial](../src/Polynomial.java).
All other provided files are already complete. The classes [IntConst](../src/IntConst.java)
and [IntConstQueue](../src/IntConstQueue.java) must not be modified.]

Die Klasse [ApplicationTest1](../src/ApplicationTest1.java) enthält Testfälle mit Sollausgaben als
Kommentare. Neben diesen Testfällen müssen auch alle Kommentare in den gefragten Klassen
zutreffen. Die Klasse [ApplicationTest1](../src/ApplicationTest1.java) fließt nicht in die
Beurteilung ein, Sie können diese Datei nach belieben ändern.

Bei einigen Methoden sind bei den Beschreibungen der Parameter unter `@param` Vorbedingungen
angegeben. Diese Vorbedingungen müssen innerhalb der Methode NICHT überprüft werden, sondern
stellen Zusicherungen dar, auf die sich die Methode verlassen kann.
