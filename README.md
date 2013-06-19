# edn-scala

An [EDN format](https://github.com/edn-format/edn) reader for Scala.

## Usage

Add the following line in your build.sbt;

```libraryDependencies += "io.github.martintrojer" % "edn-scala" % "0.1"```

Using the console;

```scala
scala> import EDN.Reader
import EDN.Reader

scala> Reader.readAll("{:a 1}")
res0: Any = Map(:a -> 1.0)
```

Also see the [test](https://github.com/martintrojer/edn-scala/blob/master/src/test/scala/EDN/ReaderTest.scala).

## TODO

* make #inst EDN (RFC-3339) conformant
* leading / trailing commas

## License

Copyright (C) 2013 Martin Trojer

Distributed under the Eclipse Public License.
