package com.philheenan.palletise.feature.account.authentication.login;

import com.philheenan.core.Boundary;

import junit.framework.TestCase;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.schedulers.Schedulers;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by phillip.heenan on 10/03/15.
 */
public class LoginPresenterTest extends TestCase {

    @Mock
    LoginViewModel mockViewModel;
    @Mock
    Boundary mockBoundary;

    LoginPresenter presenter;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter();
        presenter.setViewModel(mockViewModel);
        presenter.setBoundary(mockBoundary);
        presenter.delay = 0l;

        when(mockViewModel.getUsername()).thenReturn("user");
        when(mockViewModel.getPassword()).thenReturn("pass");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testLoginPresenter() {
        assertNotNull(mockViewModel);
        assertNotNull(presenter.viewModel);
        assertNotNull(presenter.boundary);
    }

    public void testScheduler() {
        assertEquals(Schedulers.immediate(), presenter.scheduler);

        presenter.setScheduler(Schedulers.io());
        assertEquals(Schedulers.io(), presenter.scheduler);
    }

    public void testSignInAction() {
        presenter.signinAction();
        verify(mockViewModel).getUsername();
        verify(mockViewModel).getPassword();
    }

    public void testShowProgress() {
        presenter.signinAction();
        verify(mockViewModel).showLoading(eq(true));
    }

    public void testSignInSuccessful() {
        presenter.tokenResult("token");
        verify(mockViewModel).success(eq("token"));
    }

    public void testTextUpdate() {
        presenter.textUpdate();
        verify(mockViewModel).enableSignInButton(eq(true));
    }
}
