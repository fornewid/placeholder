# How to Contribute

We'd love to accept your patches and contributions to this project.
There are just a few small guidelines you need to follow.

## New Features/Libraries

Before contributing large new features and/or libraries please start a discussion with us first via GitHub Issues and check that we can support it.
We are unable to support all new features, even though we wish we could!
If we are unable to support adding your feature, we always encourage you to open source it in your own repository to help the Compose community grow.

## Code Reviews

All submissions, including submissions by project members, require review.
We use GitHub pull requests for this purpose.
Consult [GitHub Help](https://help.github.com/articles/about-pull-requests/) for more information on using pull requests.

## API Changes

If you are changing any public APIs, you need to run `./gradlew metalavaGenerateSignatureRelease` which will update the API signatures.

## Formatting 

To apply formatting, we use spotless.
Run `./gradlew spotlessApply` to format the code according to the spec.
