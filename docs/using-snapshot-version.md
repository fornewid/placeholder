# Using a Snapshot Version of the Library

If you would like to depend on the cutting edge version of the Placeholder library,
you can use the [snapshot versions][snap] that are published to [Sonatype OSSRH](https://central.sonatype.org/)'s snapshot repository.
These are updated on every commit to `main`.

To do so:

```groovy
repositories {
    // ...
    maven { url 'https://s01.oss.sonatype.org/content/repositories/snapshots' }
}

dependencies {
    // Check the latest SNAPSHOT version from the link above
    implementation 'io.github.fornewid:placeholder-foundation:XXX-SNAPSHOT'
}
```

  [snap]: https://s01.oss.sonatype.org/content/repositories/snapshots/io/github/fornewid/placeholder-foundation/