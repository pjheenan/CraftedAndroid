package com.philheenan.palletise.app.framework;

import com.philheenan.palletise.feature.account.authentication.login.LoginPresenter;

import dagger.Module;

/**
 * Created by phillip.heenan on 13/03/15.
 */
@Module(
        library = true,
        complete = false,
        injects = {
                LoginPresenter.class
        }
)
public class PresenterModule {
}
