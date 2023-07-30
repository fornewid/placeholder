# Placeholder

[![Maven Central](https://img.shields.io/maven-central/v/io.github.fornewid/placeholder-foundation)](https://search.maven.org/search?q=g:io.github.fornewid%20placeholder)

A library which provides a [modifier][modifier] for display 'placeholder' UI while content is loading.

More information on the UX provided by this library can be found on the Material Theming [Placeholder UI](https://material.io/design/communication/launch-screen.html#placeholder-ui) guidelines.

There are actually two versions of the library available:

* *Placeholder Foundation*: Provides the base functionality and depends on Jetpack Compose Foundation. This version requires the app to provide all of the colors to display.
* *Placeholder Material*. This uses the foundation library above, but also provides sensible default colors using your app's Material color palette.

!!! tip
    You only need to use one of the libraries, and most apps should use **Placeholder Material**. The APIs of the libraries are (mostly) equivalent with only the imports being different. Where possible we have provided equivalent code samples below.

## Basic usage

At the most basic usage, the modifier will draw a shape over your composable content, filled with the provided color.

![Basic Placeholder demo](basic.jpg)

=== "Placeholder Material"

    ``` kotlin
    import io.github.fornewid.placeholder.material.placeholder

    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(visible = true)
    )
    ```

=== "Placeholder Foundation"

    ``` kotlin
    import io.github.fornewid.placeholder.placeholder

    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                color = Color.Gray,
                // optional, defaults to RectangleShape
                shape = RoundedCornerShape(4.dp),
            )
    )
    ```

## Placeholder highlights

The library also provides some 'highlight' animations to entertain the user while they are waiting. There are two provided by the library, but you can also provide your own.

### Fade

This highlight fades a color over the entire placeholder in and out.

<figure>
    <video width="400" controls loop>
    <source src="fade.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>
    <figcaption>Placeholder Fade demo</figcaption>
</figure>

=== "Placeholder Material"

    ``` kotlin
    import io.github.fornewid.placeholder.PlaceholderHighlight
    import io.github.fornewid.placeholder.material.placeholder
    import io.github.fornewid.placeholder.material.fade

    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                highlight = PlaceholderHighlight.fade(),
            )
    )
    ```

=== "Placeholder Foundation"

    ``` kotlin
    import io.github.fornewid.placeholder.PlaceholderHighlight
    import io.github.fornewid.placeholder.placeholder
    import io.github.fornewid.placeholder.fade

    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                color = Color.Gray,
                // optional, defaults to RectangleShape
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.fade(
                    highlightColor = Color.White,
                ),
            )
    )
    ```

### Shimmer

This displays a gradient shimmer effect which emanates from the top-start corner.

<figure>
    <video width="400" controls loop>
    <source src="shimmer.mp4" type="video/mp4">
        Your browser does not support the video tag.
    </video>
    <figcaption>Placeholder Shimmer demo</figcaption>
</figure>

=== "Placeholder Material"

    ``` kotlin
    import io.github.fornewid.placeholder.PlaceholderHighlight
    import io.github.fornewid.placeholder.material.placeholder
    import io.github.fornewid.placeholder.material.shimmer

    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                highlight = PlaceholderHighlight.shimmer(),
            )
    )
    ```

=== "Placeholder Foundation"

    ``` kotlin
    import io.github.fornewid.placeholder.PlaceholderHighlight
    import io.github.fornewid.placeholder.placeholder
    import io.github.fornewid.placeholder.shimmer

    Text(
        text = "Content to display after content has loaded",
        modifier = Modifier
            .padding(16.dp)
            .placeholder(
                visible = true,
                color = Color.Gray,
                // optional, defaults to RectangleShape
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = Color.White,
                ),
            )
    )
    ```

## Usage

``` groovy
repositories {
    mavenCentral()
}

dependencies {
    // If you're using Material, use placeholder-material
    implementation "io.github.fornewid:placeholder-material:<version>"

    // Otherwise use the foundation version
    implementation "io.github.fornewid:placeholder-foundation:<version>"
}
```

### Library Snapshots

Snapshots of the current development version of this library are available, which track the latest commit. See [here](../using-snapshot-version) for more information on how to use them.

---

## Contributions

Please contribute! We will gladly review any pull requests.
Make sure to read the [Contributing](../contributing) page first though.

## License

Licensed under the Apache 2.0 license. See [LICENSE](../LICENSE) for details.

  [modifier]: https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier
