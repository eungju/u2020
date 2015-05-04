package com.jakewharton.u2020;

import com.jakewharton.u2020.ui.debug.DebugView;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { U2020Module.class, DebugU2020Module.class })
public interface U2020Component extends U2020Graph {
    void inject(DebugView debugView);

    class Builder {
        public static U2020Component build(U2020App app) {
            return DaggerU2020Component.builder()
                    .u2020Module(new U2020Module(app))
                    .debugU2020Module(new DebugU2020Module())
                    .build();
        }
    }
}
