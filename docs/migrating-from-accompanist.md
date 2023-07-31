# Migrating from Accompanist

## Migration

1. Make sure you are using Compose 1.5.0+ before attempting to migrate to `io.github.fornewid.placeholder`.
2. Change `com.google.accompanist.placeholder.PlaceholderDefaults` to `io.github.fornewid.placeholder.foundation.PlaceholderDefaults`.
3. Change `com.google.accompanist.placeholder.PlaceholderHighlight` to `io.github.fornewid.placeholder.foundation.PlaceholderHighlight`.
4. Change any usages of `placeholder()` to `io.github.fornewid.placeholder.*.placeholder()`
5. For more mappings - see the migration table below.
6. Run your changes on device and check to see if there are any differences.


## Migration Table

The following is a mapping of the placeholder classes from accompanist to io.github.fornewid.placeholder:

| accompanist/placeholder                                   | androidx.compose.foundation                                      |
|-----------------------------------------------------------|------------------------------------------------------------------|
| `com.google.accompanist.placeholder.PlaceholderDefaults`  | `io.github.fornewid.placeholder.foundation.PlaceholderDefaults`  |
| `com.google.accompanist.placeholder.PlaceholderHighlight` | `io.github.fornewid.placeholder.foundation.PlaceholderHighlight` |
| `com.google.accompanist.placeholder.*`                    | `io.github.fornewid.placeholder.foundation.*`                    |
| `com.google.accompanist.placeholder.material.*`           | `io.github.fornewid.placeholder.material.*`                      |
| `com.google.accompanist.placeholder.material3.*`          | `io.github.fornewid.placeholder.material3.*`                     |
