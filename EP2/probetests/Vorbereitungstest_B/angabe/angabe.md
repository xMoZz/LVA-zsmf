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

Ein Kamel (`camel`) ist ein Wüstentier, dass Lasten (`load`) tragen kann. Wir nehmen an, dass jedes
Kamel auch eine Stärke (`strength`) hat. Die maximale Geschwindigkeit (`maximal pace`), mit der
das Kamel sich fortbewegen kann, lässt sich über eine Formel aus `load` und `strength` berechnen.

Eine Karavane (`caravan`) ist eine Reihe sich hintereinander (im Gänsemarsch) fortbewegender Kamele.
Alle Kamele der selben Karavane bewegen sich in der gleichen Geschwindigkeit (`pace`). Auch eine
Karavane hat eine bestimmte maximale Geschwindigkeit, die sich aus der maximalen Geschwindigkeit
des langsamsten Kamels in der Karavane ergibt.

## Aufgabenstellung

Die für diesen Test relevanten Dateien sind:

* [Camel](../src/Camel.java)
* [Caravan](../src/Caravan.java)
* [ApplicationTest1](../src/ApplicationTest1.java)
* [MCTest1](../src/MCTest1.java)

### Teilaufgabe 1 (maximal 25 Punkte)

Absolvieren Sie den Multiple-Choice-Test. Um die MC Fragen zu beantworten, editieren Sie die
Datei [MCTest1](../src/MCTest1.java) und befolgen Sie die Anweisungen aus den Kommentaren in der
Datei. Wenn Sie [MCTest1](../src/MCTest1.java) ausführen, bekommen Sie eine Fehlermeldung falls
inhaltlich relevante Textteile verändert wurden; ohne Fehler werden Ihre Antworten auf die Fragen
aufgelistet.

### Teilaufgabe 2 (maximal 75 Punkte)

Erzeugen Sie eine einfach verkettete Liste, in der Kamele als Elemente eingetragen werden können.
Diese Liste soll durch die Klasse [Caravan](../src/Caravan.java) repräsentiert werden. Erstellen
Sie zu diesem Zweck auch eine eigene Knotenklasse und wählen Sie für diese Klasse einen
geeigneten Namen. [English translation: Create a singly linked list in which camels can be
stored as elements. This list should be represented by the class [Caravan](../src/Caravan.java).
For this purpose, also create your own node class and choose an appropriate name for this class.]

Vervollständigen Sie die dazu gefragte Klasse [Caravan](../src/Caravan.java) bitte
wie in den Kommentaren beschrieben an den mit TODO gekennzeichneten Stellen.
Alle anderen gegebenen Dateien sind bereits vollständig. Die Datei [Camel](../src/Camel.java)
soll nicht verändert werden.

Die Klasse [ApplicationTest1](../src/ApplicationTest1.java) enthält Testfälle mit Sollausgaben als
Kommentare. Neben diesen Testfällen müssen auch alle Kommentare in den gefragten Klassen
zutreffen. Die Klasse [ApplicationTest1](../src/ApplicationTest1.java) fließt nicht in die
Beurteilung ein, Sie können diese Datei nach belieben ändern.

Bei einigen Methoden sind bei den Beschreibungen der Parameter unter `@param` Vorbedingungen
angegeben. Diese Vorbedingungen müssen innerhalb der Methode NICHT überprüft werden, sondern
stellen Zusicherungen dar, auf die sich die Methode verlassen kann.
