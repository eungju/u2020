package com.jakewharton.u2020.ui;

import com.jakewharton.u2020.U2020Component;
import com.jakewharton.u2020.ui.trending.TrendingView;
import dagger.Component;

@ActivityScope
@Component(
        dependencies = U2020Component.class,
        modules = MainActivityModule.class
)
public interface MainActivityComponent {
    void inject(MainActivity activity);
    void inject(TrendingView trendingView);
}
