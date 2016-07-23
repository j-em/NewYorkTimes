# New York Times API
  This library can be used to interact with the [New York Times API](https://developer.nytimes.com).
  You need to get an [API key](https://developer.nytimes.com/signup) from the New York Times to use this.

## Scaladoc
  The complete API reference can be found [here](https://j-em.github.io/NewYorkTimes).

## Installation
  The library is hosted on [jitpack](https://jitpack.io/#j-em/NewYorkTimes).
  
### Gradle
  Add this in your root build.gradle file at the end of the repositories.
  ```groovy
  allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}
  ```

  Then, add the dependency.
  ```groovy
  dependencies {
        compile 'com.github.j-em:NewYorkTimes:3.0.0'
    }       
  ```

## Usage
### Android
 Should work OOTB on Android with multidex enabled builds.

### Scala 
```scala
// Get a list of articles from the 2001/09/20 with "myquery" in the body, headline or byline.
getArticles("myquery", LocalDate(2001, 9, 20), LocalDate(2001, 9, 20)).run("apikey")

// Get a list of articles from the 2001/09/20 to the 2001/09/24 with "animals" in the body, headline or byline.
getArticles("animals", LocalDate(2001, 9, 20), LocalDate(2001, 9, 24)).run("apikey")
```

### Kotlin
```kotlin
import jem.nytimes.Interop.getArticles

val page = 0
getArticles("apikey", "myquery", LocalDate(2001, 9, 20), LocalDate(2001, 9, 20), page)
```

### Other JVM languages
The [Interop](http://j-em.xyz/NewYorkTimes/#jem.nytimes.Interop$) object contains (unsafe) methods that makes it easier to interact with the library outside of Scala. Optionals are automatically unwrapped, the usage of Monads is hidden and the return type is a standard java list.

## Build
Running this in a shell should be enough.
```
$ sbt package
```
## Technologies
- [scalaz](https://github.com/scalaz/scalaz)
- [scalaj-http](https://github.com/scalaj/scalaj-http)
