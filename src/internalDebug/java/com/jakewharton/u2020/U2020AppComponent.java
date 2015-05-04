package com.jakewharton.u2020;

import com.jakewharton.u2020.ui.debug.DebugView;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { U2020Module.class, DebugU2020Module.class })
public interface U2020AppComponent extends U2020AppGraph {
    void inject(DebugView debugView);

    class Builder {
        public static U2020AppComponent build(U2020App app) {
            return DaggerU2020AppComponent.builder()
                    .u2020Module(new U2020Module(app))
                    .debugU2020Module(new DebugU2020Module())
                    .build();
        }
    }
}
