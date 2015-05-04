package com.jakewharton.u2020;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = { U2020Module.class, ProductionU2020Module.class })
public interface U2020AppComponent extends U2020AppGraph {
    class Builder {
        public static U2020AppComponent build(U2020App app) {
            return DaggerU2020AppComponent.builder()
                    .u2020Module(new U2020Module(app))
                    .productionU2020Module(new ProductionU2020Module())
                    .build();
        }
    }
}
