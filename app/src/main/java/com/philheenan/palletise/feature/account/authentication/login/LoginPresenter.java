package com.philheenan.palletise.feature.account.authentication.login;

import com.philheenan.core.Boundary;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by phillip.heenan on 11/03/15.
 */
public class LoginPresenter {

    LoginViewModel viewModel;
    Boundary boundary;
    Scheduler scheduler = Schedulers.immediate();
    long delay = 1000l;

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }

    public void setViewModel(LoginViewModel model) {
        this.viewModel = model;
    }

    public void textUpdate() {
        if (viewModel.getUsername().length() > 0 && viewModel.getPassword().length() > 0) {
            viewModel.enableSignInButton(true);
        } else {
            viewModel.enableSignInButton(false);
        }
    }

    public void signinAction() {
        viewModel.showLoading(true);
        performLogin(viewModel.getUsername(), viewModel.getPassword());
    }

    public void tokenResult(String token) {
        viewModel.success(token);
    }

    private void performLogin(String username, String password) {
//        boundary.callBoundary(username, password);
        Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                subscriber.onNext(true);
                subscriber.onCompleted();
            }
        }).delay(delay, TimeUnit.MILLISECONDS)
                .observeOn(scheduler)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        tokenResult("result");
                    }
                });
    }
}
