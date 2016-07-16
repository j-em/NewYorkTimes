# New York Times API
  This library can be used to interact with the [New York Times API](https://developer.nytimes.com).
  You need to get an [API key](https://developer.nytimes.com/signup) from the New York Times to use this.

## Scaladoc
  The complete API reference can be found [here](https://j-em.github.io/NewYorkTimes).

## Installation
  The library is hosted on [jitpack](https://jitpack.io).
  
### Gradle
  Add this in your root build.gradle file at the end of the repositories.
  ```
  allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}
  ```

  Then, add the dependency.
  ```
  dependencies {
        compile 'com.github.j-em:NewYorkTimes:3.0.0'
    }       
  ```

## Usage
### Scala 
``` 
getArticles("myquery", LocalDate(2001, 9, 20), LocalDate(2001, 9, 20)).run("apikey")
```

### Kotlin
```
import jem.nytimes.Interop.getArticles

val page = 0
getArticles("apikey", "myquery", LocalDate(2001, 9, 20), LocalDate(2001, 9, 20), page)
```