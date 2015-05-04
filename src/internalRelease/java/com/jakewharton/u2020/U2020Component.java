package com.jakewharton.u2020;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { U2020Module.class, InternalReleaseU2020Module.class })
public interface U2020Component extends U2020Graph {
    class Builder {
        public static U2020Component build(U2020App app) {
            return DaggerU2020Component.builder()
                    .u2020Module(new U2020Module(app))
                    .internalReleaseU2020Module(new InternalReleaseU2020Module())
                    .build();
        }
    }
}
