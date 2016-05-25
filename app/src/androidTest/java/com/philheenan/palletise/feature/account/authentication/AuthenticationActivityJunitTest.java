package com.philheenan.palletise.feature.account.authentication;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by phillip.heenan on 13/03/15.
 */
@RunWith(AndroidJUnit4.class)
public class AuthenticationActivityJunitTest extends ActivityInstrumentationTestCase2<AuthenticationActivity> {

    public AuthenticationActivityJunitTest() {
        super(AuthenticationActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLoginStore() {
        Assert.assertTrue(true);
    }

}
