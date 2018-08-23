package ru.surfstudio.android.custom_scope_sample.ui.base.dagger.login

import android.content.Context
import dagger.Component
import ru.surfstudio.android.connection.ConnectionProvider
import ru.surfstudio.android.core.app.ActiveActivityHolder
import ru.surfstudio.android.core.app.StringsProvider
import ru.surfstudio.android.core.ui.bus.RxBus
import ru.surfstudio.android.core.ui.provider.ActivityProvider
import ru.surfstudio.android.core.ui.scope.ActivityPersistentScope
import ru.surfstudio.android.custom_scope_sample.app.dagger.AppComponent
import ru.surfstudio.android.custom_scope_sample.ui.base.dagger.scope.PerLogin
import ru.surfstudio.android.rx.extension.scheduler.SchedulersProvider

@PerLogin
@Component(dependencies = [AppComponent::class],
        modules = [LoginModule::class])
interface LoginScreenComponent {
    fun context(): Context
    fun activeActivityHolder(): ActiveActivityHolder
    fun connectionProvider(): ConnectionProvider
    fun schedulerProvider(): SchedulersProvider
    fun stringsProvider(): StringsProvider

    fun loginData(): LoginData
}