/**
 * An object that holds constants for Retrofit and OkHttp dependencies.
 */
object Retrofit {
    private const val version = "2.9.0"
    /**
     * The core Retrofit dependency.
     */
    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    /**
     * The Retrofit Moshi converter dependency.
     */
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"

    private const val okHttpVersion = "5.0.0-alpha.2"
    /**
     * The core OkHttp dependency.
     */
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    /**
     * The OkHttp logging interceptor dependency.
     */
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
}