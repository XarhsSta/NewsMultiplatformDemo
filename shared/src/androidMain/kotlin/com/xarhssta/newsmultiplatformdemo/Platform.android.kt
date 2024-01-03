package com.xarhssta.newsmultiplatformdemo

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform() {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() ="${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val density: Int
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logPlatformSystemInfo() {
        Log.d(
            "NewsMultiplatformDemo",
            "($osName, $osVersion, $deviceModel, $density"
        )
    }

}