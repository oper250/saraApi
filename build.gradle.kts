plugins {
	java
	id("org.springframework.boot") version "2.7.14"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.jk"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.1")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.3.1")
	implementation("javax.servlet:jstl:1.2")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper:11.0.0-M5")     // jsp 사용가능
	implementation("com.google.guava:guava:31.1-jre")                           // code case 변환(CamelJSONObject)

	implementation("org.mybatis:mybatis:3.5.13")
	implementation("com.googlecode.json-simple:json-simple:1.1.1")
	implementation("commons-io:commons-io:2.11.0")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")

	runtimeOnly("mysql:mysql-connector-java:8.0.33")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
