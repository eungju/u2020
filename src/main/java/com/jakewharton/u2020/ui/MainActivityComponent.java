package com.jakewharton.u2020.ui;

import com.jakewharton.u2020.U2020AppComponent;
import com.jakewharton.u2020.ui.trending.TrendingView;
import dagger.Component;

@ActivityScope
@Component(
        dependencies = U2020AppComponent.class,
        modules = MainActivityModule.class
)
public interface MainActivityComponent {
    void inject(MainActivity activity);
    void inject(TrendingView trendingView);
}
