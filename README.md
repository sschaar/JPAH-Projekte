Projekte Datenbank (JPA), 10.04.2024
Importieren Sie die entsprechenden Entitäten aus der Projekte Datenbank aus dem File
Projekte_MySQL_DB_utf.sql mit JPA/Hibernate. Hinweis: Eine m-zu-n Verbindung ist auf die eine
und auf die andere Seite der „Zwischentabelle“ eine n-zu-1 Verbindung.
Versuchen Sie nachfolgende Auswertungen über entsprechende Methoden in einer oder mehreren
DAO Klassen mit Ihrem Programm zu machen (Tipp: überlegen Sie sich zuerst immer eine
Auswertung mit klassischem SQL). Die Komplexität der Auswertungen steigt ist in etwa der
Reihenfolge nach. In erster Linie verwenden Sie JPQL und kombinieren, dort wo es nötig ist, die
Technik von Java Streams. Sogenannte „Native Queries“ (TIPP: als „Named Queries“), sollten nur in
Ausnahmefällen verwendet werden.
Gesuchte Auswertungen:
➢ Geben Sie alle Mitarbeiter aus.
➢ Wo wohnt Mitarbeiterin X > soll als Übergabeparameter der Methode übergeben werden?
➢ Welche Vornamen kommen bei den Mitarbeitern öfter als einmal vor?
➢ Wer ist der jüngste Mitarbeiter, geben Sie dessen Daten aus?
➢ Welche Bezeichnung haben die Arbeitspakete des Projekts mit dem Code
X > X soll als Übergabeparameter der Methode übergeben werden?
➢ Geben Sie zu allen Mitarbeitern deren Arbeitspaketen aus, an denen Sie beteiligt sind.
➢ Geben Sie zu allen Mitarbeitern deren Projekte aus, an denen Sie beteiligt sind.
➢ Wie heißen die Projektmanager der Projekte und wie viel Zeit wurde für das
Projektmanagement aufgewendet?
Insert/Update/Delete:
➢ Fügen Sie einen neuen Mitarbeiter ein UND
ordnen Sie (im state „managed“) ihm ein bestehendes Arbeitspaket zu.
➢ Bringen Sie ein Projekt in den state „managed“ und fügen Sie ein neues Arbeitspaket ein.
➢ ZUERSTE DATENBANK BACKUP MACHEN! dann: Löschen Sie per „orphan removal“ ein Projekt
aus Projekte, zeigen Sie was passiert ist.
Zusatz:
➢ Können Sie den Unterschied zwischen FETCH-TYPE „Lazy“ und FETCH-TYPE „Eager“
erkennen?
