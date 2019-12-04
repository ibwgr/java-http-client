# Usage
## URL "Resource" lesen mit plain java
Nur Klassen direkt von Java werden verwendet.

```
$ mvn clean package
$ java -cp target/*dependencies.jar ReadFromURL http://wttr.in
```

Hier wird der Quelltext der Webseite ausgegeben, in HTML.
Damit wir den ASCII Output bekommen, den auch curl bekommt, brauchen wir einen "richtigen" HTTP Client.

## HTTP Client
Basiert auf dem Apache Projekt http://hc.apache.org/httpcomponents-client-ga/.

```
$ mvn clean package
$ java -cp target/*dependencies.jar HttpClient http://wttr.in
```

Eigentlich wollen wir nicht den HTML Quelltext, sondern, den ASCII Output den wir auch mit curl bekommen.
Das erreichen wir, indem wir den HTTP Request Header "User-Agent" auf "curl" setzen. Der Server erkennt
den Request Header und reagiert entsprechend.