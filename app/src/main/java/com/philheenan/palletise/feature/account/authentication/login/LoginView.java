package com.philheenan.palletise.feature.account.authentication.login;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.philheenan.palletise.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by phillip.heenan on 10/03/15.
 */
public class LoginView extends LinearLayout implements LoginViewModel {

//    @Inject
//    LoginPresenter presenter;

    @InjectView(R.id.username)
    EditText username;
    @InjectView(R.id.password)
    EditText password;
    @InjectView(R.id.button)
    TextView signInButton;
    @InjectView(R.id.formView)
    LinearLayout formView;
    @InjectView(R.id.progressLayout)
    FrameLayout progressLayout;

    LoginPresenter presenter = new LoginPresenter();

    public LoginView(Context context) {
        super(context);
        init();
    }

    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoginView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void setUsername(String username) {
        this.username.setText(username);
    }

    @Override
    public String getUsername() {
        return this.username.getText().toString();
    }

    @Override
    public String getPassword() {
        return this.password.getText().toString();
    }

    @Override
    public void enableSignInButton(boolean enable) {
        this.signInButton.setEnabled(enable);
    }

    @Override
    public void showForm(boolean showForm) {
        formView.setVisibility(showForm ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    public void success(String token) {
        if (token != null && token.length() > 0) {
            showLoading(false);
        }
    }

    @Override
    public void showLoading(boolean showLoading) {
        progressLayout.setVisibility(showLoading ? View.VISIBLE : View.GONE);
    }

    void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.signin_view, this, true);
        ButterKnife.inject(this);
        presenter.setViewModel(this);
        presenter.setScheduler(AndroidSchedulers.mainThread());
        this.signInButton.setEnabled(false);
    }

    @OnTextChanged({ R.id.username, R.id.password})
    void onTextChanged(CharSequence s) {
        presenter.textUpdate();
    }

    @OnClick(R.id.button)
    void onClick() {
        presenter.signinAction();
    }

}
