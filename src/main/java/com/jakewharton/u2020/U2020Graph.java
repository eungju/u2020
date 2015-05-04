package com.jakewharton.u2020;

import com.jakewharton.u2020.data.IntentFactory;
import com.jakewharton.u2020.data.api.GithubService;
import com.jakewharton.u2020.ui.AppContainer;
import com.squareup.picasso.Picasso;

public interface U2020Graph {
    void inject(U2020App app);

    GithubService githubService();
    AppContainer appContainer();
    Picasso picasso();
    IntentFactory intentFactory();
}
