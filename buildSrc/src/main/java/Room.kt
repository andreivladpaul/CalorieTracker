/**
 * An object that holds constants for Room database dependencies.
 */
object Room {
    private const val version = "2.4.0"
    /**
     * The Room runtime dependency.
     */
    const val roomRuntime = "androidx.room:room-runtime:$version"
    /**
     * The Room compiler dependency.
     */
    const val roomCompiler = "androidx.room:room-compiler:$version"
    /**
     * The Room KTX extensions dependency.
     */
    const val roomKtx = "androidx.room:room-ktx:$version"
}