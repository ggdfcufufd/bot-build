plugins {
    id 'java'
    id 'application'
}

group = 'com.bot'
version = '1.0.0'

repositories {
    mavenCentral()
}

dependencies {
    // Telegram Bot API
    implementation 'org.telegram:telegrambots:6.8.0'
    
    // Логирование
    implementation 'org.slf4j:slf4j-simple:2.0.9'
}

application {
    mainClass = 'com.bot.Main'
}

// Чтобы собирался fat JAR со всеми зависимостями
jar {
    manifest {
        attributes 'Main-Class': 'com.bot.Main'
    }
    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
