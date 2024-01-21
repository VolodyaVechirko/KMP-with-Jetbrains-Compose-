import platform.UIKit.UIDevice

/**
 * iOS Platform actual implementation
 */
class IOSPlatform : Platform {
    override val name: String = with(UIDevice.currentDevice) {
        "${systemName()} $systemVersion"
    }
}

actual fun getPlatform(): Platform = IOSPlatform()