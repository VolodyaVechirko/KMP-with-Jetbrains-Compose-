/**
 * Platform specific expect/actual sample
 */
interface Platform {
    val name: String
}

expect fun getPlatform(): Platform