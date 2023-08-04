# Placeholder for Jetpack Compose

<a href="https://github.com/fornewid/placeholder/actions/workflows/build.yaml"><img src="https://github.com/fornewid/placeholder/actions/workflows/build.yaml/badge.svg"/></a>
<a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
<a href='https://developer.android.com'><img src='http://img.shields.io/badge/platform-android-green.svg'/></a>

A library which provides a [modifier][modifier] for display 'placeholder' UI while content is loading.

The codes are copied from [accompanist][accompanist] placeholder.
If you're already using [accompanist][accompanist] placeholder, you can migrate by referring to [the migration guide](docs/migrating-from-accompanist.md).

## Compose versions

<table>
 <tr>
  <td>Older versions</td><td>Use <a href='https://github.com/google/accompanist'>accompanist/placeholder</a></td>
 </tr>
 <tr>
  <td>Compose 1.5 (1.5.x)</td><td><img alt="Maven Central" src="https://img.shields.io/maven-central/v/io.github.fornewid/placeholder-foundation"></td>
 </tr>
</table>

### [Placeholder Foundation](./foundation/)

A library that provides easy-to-use modifiers for displaying a placeholder UI while content is loading.

### [Placeholder Material](./material/)

A library that provides easy-to-use modifiers for displaying a placeholder UI on Material theme.

### [Placeholder Material3](./material3/)

A library that provides easy-to-use modifiers for displaying a placeholder UI on Material3 theme.

## Usage

``` groovy
repositories {
    mavenCentral()
}

dependencies {
    // If you're using Material, use placeholder-material
    implementation "io.github.fornewid:placeholder-material:<version>"

    // If you're using Material3, use placeholder-material3
    implementation "io.github.fornewid:placeholder-material3:<version>"

    // Otherwise use the foundation version
    implementation "io.github.fornewid:placeholder-foundation:<version>"
}
```

## Snapshots

Snapshots of the current development version of Placeholder are available, which track the latest commit.
See [here](docs/using-snapshot-version.md) for more information.

## Contributions

Please contribute! We will gladly review any pull requests.
Make sure to read the [Contributing](CONTRIBUTING.md) page first though.

## License

```
Copyright 2023 fornewid
 
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

  [accompanist]: https://github.com/google/accompanist
  [modifier]: https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier
  [migration]: https://fornewid.github.io/placeholder#migration