import com.vjh0107.barcode.api.server.ProjectManagerPlugin
import org.gradle.kotlin.dsl.provideDelegate

object Deps {
    private val project = ProjectManagerPlugin.project

    val kotlinVersion: String by project

    object Library {
        val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
        val KOTLIN_TEST = "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"

        const val MYSQL_CONNECTOR = "mysql:mysql-connector-java:8.0.28"
        const val HIKARICP = "com.zaxxer:HikariCP:5.0.1"
        const val SQLITE = "org.xerial:sqlite-jdbc:3.36.0.3"
        const val NETTY = "io.netty:netty-all:4.1.78.Final"
        val mockKVersion: String by project
        val MOCKK = "io.mockk:mockk:$mockKVersion"

        object Logger {
            const val LOGBACK_CLASSIC ="ch.qos.logback:logback-classic:1.4.0"
            const val SLF4J_JDK14 = "org.slf4j:slf4j-jdk14:2.0.1"
        }
    }

    object KSP {
        private val kspVersion: String by project
        val API = "com.google.devtools.ksp:symbol-processing-api:$kspVersion"
    }

    object Ktor {
        private val ktorVersion: String by project
        private val SERIALIZATION_JSON = "io.ktor:ktor-serialization-kotlinx-json:$ktorVersion"

        object CLIENT : DependencySet<String> {
            private val CORE = "io.ktor:ktor-client-core:$ktorVersion"
            private val COROUTINES_IO = "io.ktor:ktor-client-cio:$ktorVersion"
            private val CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:$ktorVersion"

            override fun getDependencies(): Collection<String> {
                return setOf(CORE, COROUTINES_IO, CONTENT_NEGOTIATION, SERIALIZATION_JSON)
            }
        }

        object SERVER : DependencySet<String> {
            private val CORE = "io.ktor:ktor-server-core-jvm:$ktorVersion"
            private val CONTENT_NEGOTIATION = "io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion"
            // private const val NETTY = "io.ktor:ktor-server-netty-jvm:$VERSION"
            private val COROUTINES_IO = "io.ktor:ktor-server-cio:$ktorVersion"
            private val RESOURCES = "io.ktor:ktor-server-resources:$ktorVersion"
            private val STATUS_PAGES = "io.ktor:ktor-server-status-pages:$ktorVersion"

            override fun getDependencies(): Collection<String> {
                return setOf(CORE, CONTENT_NEGOTIATION, COROUTINES_IO, RESOURCES, STATUS_PAGES, SERIALIZATION_JSON)
            }
        }
        val SERVER_TEST = "io.ktor:ktor-server-tests-jvm:$ktorVersion"
    }

    object KotlinX {
        object Coroutines {
            private const val VERSION = "1.6.1"

            const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
            const val TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$VERSION"
        }

        object Serialization {
            private const val VERSION = "1.4.0"
            const val JSON = "org.jetbrains.kotlinx:kotlinx-serialization-json:$VERSION"
        }
    }

    object KOTEST : DependencySet<String> {
        private const val VERSION = "5.3.1"
        private const val KOTLIN_TEST_RUNNER = "io.kotest:kotest-runner-junit5:$VERSION"
        private const val KOTLIN_TEST_ASSERTIONS_CORE = "io.kotest:kotest-assertions-core:$VERSION"

        override fun getDependencies(): Collection<String> {
            return setOf(KOTLIN_TEST_RUNNER, KOTLIN_TEST_ASSERTIONS_CORE)
        }
    }

    object EXPOSED : DependencySet<String> {
        private val exposedVersion: String by project
        private val CORE = "org.jetbrains.exposed:exposed-core:$exposedVersion"
        private val DAO = "org.jetbrains.exposed:exposed-dao:$exposedVersion"
        private val JDBC = "org.jetbrains.exposed:exposed-jdbc:$exposedVersion"
        private val JAVA_TIME = "org.jetbrains.exposed:exposed-java-time:$exposedVersion"

        override fun getDependencies(): Collection<String> {
            return setOf(CORE, DAO, JDBC, JAVA_TIME)
        }
    }

    object Koin {
        private val koinVersion: String by project
        private val koinAnnotationVersion: String by project
        val CORE = "io.insert-koin:koin-core:$koinVersion"
        val KTOR = "io.insert-koin:koin-ktor:$koinVersion"
        val ANNOTATIONS = "io.insert-koin:koin-annotations:$koinAnnotationVersion"
        val KSP_COMPILER = "io.insert-koin:koin-ksp-compiler:$koinAnnotationVersion"

        val TEST = "io.insert-koin:koin-test:$koinVersion"
    }
}