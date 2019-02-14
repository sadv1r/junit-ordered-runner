JUnit Ordered Runner
====================
This little project is designed to give the ability to specify the order of methods execution within a test class.

[![Build Status](https://travis-ci.org/sadv1r/junit-ordered-runner.svg?branch=master)](https://travis-ci.org/sadv1r/junit-ordered-runner)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=ru.sadv1r.junit:junit-ordered-runner&metric=alert_status)](https://sonarcloud.io/dashboard/index/ru.sadv1r.junit:junit-ordered-runner)

Installation
==========================
```xml
<dependency>
    <groupId>ru.sadv1r.junit</groupId>
    <artifactId>junit-ordered-runner</artifactId>
    <version>${dep.junit-ordered-runner.version}</version>
    <scope>test</scope>
</dependency>
```

Usage
====================================
```java
@RunWith(OrderedRunner.class)
public class YourTest {
    @Test
    @Order(1)
    public void needToBeFirst() {
        // Test code
    }

    @Test
    @Order(3)
    public void needToBeThird() {
        // Test code
    }
    
    @Test
    public void withoutOrder() {
        // Test code
    }

    @Test
    @Order(2)
    public void needToBeSecond() {
        // Test code
    }
}
```
