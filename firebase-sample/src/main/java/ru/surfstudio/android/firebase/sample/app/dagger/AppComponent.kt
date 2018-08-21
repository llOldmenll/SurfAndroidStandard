package ru.surfstudio.android.firebase.sample.app.dagger

import android.content.Context
import dagger.Component
import ru.surfstudio.android.connection.ConnectionProvider
import ru.surfstudio.android.core.app.ActiveActivityHolder
import ru.surfstudio.android.core.app.StringsProvider
import ru.surfstudio.android.dagger.scope.PerApplication
import ru.surfstudio.android.firebase.sample.interactor.common.analytics.AnalyticsModule
import ru.surfstudio.android.firebase.sample.interactor.common.analytics.AnalyticsService
import ru.surfstudio.android.rx.extension.scheduler.SchedulersProvider

@PerApplication
@Component(modules = [
    AppModule::class,
    SharedPrefModule::class,
    AnalyticsModule::class])
interface AppComponent {
    fun context(): Context
    fun activeActivityHolder(): ActiveActivityHolder
    fun connectionProvider(): ConnectionProvider
    fun schedulerProvider(): SchedulersProvider
    fun stringsProvider(): StringsProvider
    fun analyticsService(): AnalyticsService
}
