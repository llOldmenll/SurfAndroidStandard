package ru.surfstudio.android.core.ui.base.event.delegate.lifecycle.state;


import ru.surfstudio.android.core.ui.ScreenType;
import ru.surfstudio.android.core.ui.base.event.delegate.base.resolver.MultipleScreenEventResolver;

import java.util.List;

public class OnRestoreStateEventResolver extends MultipleScreenEventResolver<OnRestoreStateEvent, OnRestoreStateDelegate, Void> {
    @Override
    public Class<OnRestoreStateDelegate> getDelegateType() {
        return OnRestoreStateDelegate.class;
    }

    @Override
    public Class<OnRestoreStateEvent> getEventType() {
        return OnRestoreStateEvent.class;
    }

    @Override
    public List<ScreenType> getEventEmitterScreenTypes() {
        return ACTIVITY_AND_FRAGMENT_TYPES;
    }

    @Override
    protected Void resolve(OnRestoreStateDelegate delegate, OnRestoreStateEvent event) {
        delegate.onRestoreState(event.getSavedInstanceState());
        return null;
    }
}
