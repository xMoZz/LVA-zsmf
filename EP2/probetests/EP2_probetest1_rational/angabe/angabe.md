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

Rationale Zahlen (`rational numbers`) können als Bruchzahlen dargestellt werden, wobei jede
Bruchzahl
zwei Bestandteile hat, nämlich Zähler (`numerator`) und Nenner (`denominator`). Der Wert eines
Bruches ergibt sich aus Zähler dividiert durch Nenner. Brüche kann man in gekürzter Form darstellen,
indem man Zähler und Nenner durch deren größten gemeinsamen Teiler (greatest common divisor - `gcd`)
dividiert. Der Wert des Bruches wird dadruch nicht verändert.

## Aufgabenstellung

Die für diesen Test relevanten Dateien sind:

* [Rational](../src/Rational.java)
* [TreeSetRational](../src/TreeSetRational.java)
* [ApplicationTest1](../src/ApplicationTest1.java)
* [MCTest1](../src/MCTest1.java)

Im Praxisteil des Tests sollen davon die hier aufgelisteten Dateien bearbeitet werden:

* [TreeSetRational](../src/TreeSetRational.java)

### Teilaufgabe 1 (maximal 25 Punkte)

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die
Datei [MCTest1](../src/MCTest1.java) und befolgen Sie die Anweisungen aus den Kommentaren in der
Datei. Wenn Sie [MCTest1](../src/MCTest1.java) ausführen, bekommen Sie eine Fehlermeldung falls
inhaltlich relevante Textteile verändert wurden; ohne Fehler werden Ihre Antworten auf die Fragen
aufgelistet.

### Teilaufgabe 2 (maximal 75 Punkte)

Erzeugen Sie einen binären Suchbaum in den Bruchzahlen (Elemente vom Typ `Rational`)
eingetragen werden. Ein solcher binärer Suchbaum wird durch die
Klasse [TreeSetRational](../src/TreeSetRational.java)
repräsentiert. Erstellen Sie zu diesem Zweck auch eine eigene Knotenklasse und wählen Sie für diese
Klasse einen geeigneten Namen. Jedes Objekt vom Typ `TreeSetRational` stellt eine endliche Menge von
Bruchzahlen dar. Die Ordnung der Elemente im binären Suchbaum entspricht der natürlichen Ordnung der
Werte der Bruchzahlen. [English translation: Create a binary search tree in which rational numbers
(elements of type`Rational`) are stored. Such a binary search tree is represented by the  
class [TreeSetRational](../src/TreeSetRational.java). For this purpose, also create your own node class
and choose an appropriate name for this class. Each object of `TreeSetRational` thus represents a
finite set of rational numbers. The ordering of the elements in the binary search tree
corresponds to the natural ordering of the values of the rational numbers.]

Vervollständigen Sie dazu die Klasse [TreeSetRational](../src/TreeSetRational.java) bitte
wie in den Kommentaren beschrieben an den mit TODO gekennzeichneten Stellen.
Alle anderen gegebenen Dateien sind bereits vollständig. Die Datei [Rational](../src/Rational.java)
soll nicht verändert werden.

Die Klasse [ApplicationTest1](../src/ApplicationTest1.java) enthält Testfälle mit Sollausgaben als
Kommentare. Neben diesen Testfällen müssen auch alle Kommentare in den gefragten Klassen
zutreffen. Die Klasse [ApplicationTest1](../src/ApplicationTest1.java) fließt nicht in die
Beurteilung ein, Sie können diese Datei nach belieben ändern.

Bei einigen Methoden sind bei den Beschreibungen der Parameter unter `@param` Vorbedingungen
angegeben. Diese Vorbedingungen müssen innerhalb der Methode NICHT überprüft werden, sondern
stellen Zusicherungen dar, auf die sich die Methode verlassen kann.
