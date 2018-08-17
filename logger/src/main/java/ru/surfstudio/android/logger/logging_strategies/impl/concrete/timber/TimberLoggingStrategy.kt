package ru.surfstudio.android.logger.logging_strategies.impl.concrete.timber

import ru.surfstudio.android.logger.logging_strategies.LoggingStrategy
import timber.log.Timber

class TimberLoggingStrategy : LoggingStrategy {

    override fun log(priority: Int, t: Throwable?, message: String?, vararg args: Any?) {
        setClickableLink()
        Timber.log(priority, t, message, *args)
    }

    private fun setClickableLink() {
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size < 2) {
            throw IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?")
        }
        val element = stackTrace[2]
        val tagMsg = String.format("(%s:%s) ", element.fileName, element.lineNumber)
        Timber.tag(tagMsg)
    }
}
