# Streampunk

Streampunk is a Clojure interface to stream summarization and
cardinality estimation libraries, such as [stream-lib](https://github.com/addthis/stream-lib).


## Project Goals

 * Provide a nice Clojure interface to stream-lib and similar libraries
 * Be well tested


## Project Maturity

Streampunk is *very* young.


## Artifacts

Streampunk artifacts are [released to Clojars](https://clojars.org/clojurewerkz/streampunk). If you are using Maven, add the following repository
definition to your `pom.xml`:

``` xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With Leiningen:

    [clojurewerkz/streampunk "1.0.0-alpha1"]


With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>streampunk</artifactId>
      <version>1.0.0-alpha1</version>
    </dependency>


## Documentation & Examples

The project is very young and we won't start working on the docs
before the API stabilizes.


## Community & Support

To subscribe for announcements of releases, important changes and so
on, please follow [@ClojureWerkz](https://twitter.com/clojurewerkz) on
Twitter.


## Supported Clojure versions

Streampunk requires Clojure 1.4+.


## Continuous Integration Status

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/streampunk.png)](http://travis-ci.org/clojurewerkz/streampunk)


## Streampunk Is a ClojureWerkz Project

Streampunk is part of the [group of Clojure libraries known as ClojureWerkz](http://clojurewerkz.org), together with

 * [Monger](http://clojuremongodb.info)
 * [Langohr](http://clojurerabbitmq.info)
 * [Elastisch](http://clojureelasticsearch.info)
 * [Cassaforte](http://clojurecassandra.info)
 * [Titanium](http://titanium.clojurewerkz.org)
 * [Neocons](http://clojureneo4j.info)
 * [EEP](https://github.com/clojurewerkz/eep)

and several others.


## Development

Streampunk uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against supported
Clojure versions using

    lein all test

Then create a branch and make your changes on it. Once you are done
with your changes and all tests pass, submit a pull request on GitHub.


## Credits

The work on this library is sponsored by [Open Sensors](http://opensensors.io).


## License

Copyright (C) 2014 Michael S. Klishin, Alex Petrov, and The ClojureWerkz Team.

Double licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure) or
the [Apache Public License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
