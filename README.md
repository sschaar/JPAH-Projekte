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
Ja, FETCH-TYPE "Lazy" und FETCH-TYPE "Eager" sind zwei unterschiedliche Strategien für das Laden von Daten in einem ORM (Object-Relational Mapping) Kontext, wie es in vielen Java Persistence API (JPA) Implementierungen verwendet wird, z.B. in Hibernate.

    Lazy Loading (Lazy Fetch):
        Bei Lazy Loading werden die assoziierten Objekte (z.B. in einer One-to-Many-Beziehung) erst dann geladen, wenn sie benötigt werden.
        Das bedeutet, dass beim Laden des Hauptobjekts (z.B. einer Entität) zunächst nur die direkten Attribute dieser Entität geladen werden, während die assoziierten Objekte (z.B. in einer Collection) erst dann abgerufen werden, wenn darauf zugegriffen wird.
        Dies kann Leistungsverbesserungen bieten, da nur die tatsächlich benötigten Daten abgerufen werden, was die Datenbanklast reduzieren kann. Es kann jedoch auch zu zusätzlichen Datenbankabfragen führen, wenn auf assoziierte Objekte zugegriffen wird.

    Eager Loading (Eager Fetch):
        Im Gegensatz dazu werden bei Eager Loading alle assoziierten Objekte (oder ein Teil davon) sofort geladen, wenn das Hauptobjekt geladen wird.
        Das bedeutet, dass bei der Abfrage des Hauptobjekts auch die assoziierten Objekte in derselben Abfrage geladen werden. Dadurch wird vermieden, dass weitere Abfragen an die Datenbank gesendet werden, um fehlende Daten nachzuladen.
        Eager Loading kann dazu führen, dass mehr Daten als notwendig abgerufen werden, insbesondere wenn viele assoziierte Objekte vorhanden sind oder wenn nur ein Teil der assoziierten Objekte tatsächlich benötigt wird.

    Die Wahl zwischen Lazy Loading und Eager Loading hängt von den spezifischen Anforderungen und dem Datenzugriffsmuster Ihrer Anwendung ab. In vielen Fällen ist eine Kombination beider Strategien die beste Lösung, um eine optimale Leistung zu erzielen.
