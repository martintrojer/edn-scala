# edn-scala

An [EDN format](https://github.com/edn-format/edn) reader/writer for Scala.

## Usage

Add the following line in your build.sbt;

```
resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += "io.github.martintrojer" % "edn-scala_2.10" % "0.1-SNAPSHOT"
```

Using the console;

```scala
scala> import EDN._
import EDN._

scala> Reader.readAll("{:a 1}")
res0: Any = Map(:a -> 1.0)

scala> Writer.writeAll(Map(Vector(1) -> Set(2)))
res1: String = {[] #{2}}
```

Also see the [tests](https://github.com/martintrojer/edn-scala/blob/master/src/test/scala/EDN).

## TODO

* make #inst EDN (RFC-3339) conformant
* leading / trailing commas
* use proper symbol regexps

## License

Copyright (C) 2013 Martin Trojer

Distributed under the Eclipse Public License.
