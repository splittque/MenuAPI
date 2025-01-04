# MenuAPI
Api for minecraft server plugins that allows you to easily create menus.
Supports Minecraft server version from 1.18.

### Implementation

---

1. Download JAR from releases or build yourself
2. Create a folder in your project and place the jar in it

#### Gradle
```groovy
repositories {
    flatDir {
        dirs "/path/to" 
    }
}
dependencies {
    implementation 'me.splitque:menu-api:0.0.1'
}
```
or
```groovy
dependencies {
    implementation fileTree(dir: '/path/to', include: '*.jar')
}
```

#### Maven
```xml
<dependency>
  <groupId>me.splitque</groupId>
  <artifactId>menu-api</artifactId>
  <version>0.0.1</version>
  <scope>system</scope>
  <systemPath>${project.basedir}/path/to/menu-api-0.0.1.jar</systemPath>
</dependency>
```
Done!

### Examples

---

You can found example of using this api [here](https://github.com/splittque/MenuAPI/tree/main/example/src/main/java/me/splitque).

### Build

---

uses **Gradle 8.10**, **Java 17** and **Paper 1.18**
1. Download or clone this project
2. Change the code
3. Build