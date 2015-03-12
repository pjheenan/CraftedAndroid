package com.philheenan.palletise.feature.account.authentication.login;

/**
 * Created by phillip.heenan on 10/03/15.
 */
public interface LoginViewModel {

    public void setUsername(String username);
    public String getUsername();
    public String getPassword();
    public void enableSignInButton(boolean enable);
    public void showLoading(boolean showLoading);
    public void showForm(boolean showForm);
    public void success(String token);
}
