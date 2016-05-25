package com.philheenan.palletise.app.framework;

import com.philheenan.palletise.feature.account.authentication.AuthenticationActivity;
import com.philheenan.palletise.feature.account.authentication.login.LoginView;

import butterknife.ButterKnife;
import dagger.Module;
import dagger.Provides;

/**
 * Created by phillip.heenan on 13/03/15.
 */
@Module(
        complete = false,
        library = true,
        injects = {
                AuthenticationActivity.class,
                LoginView.class,
        },
        includes = {
                PresenterModule.class
        }

)
public class PalletiseModule {


}
