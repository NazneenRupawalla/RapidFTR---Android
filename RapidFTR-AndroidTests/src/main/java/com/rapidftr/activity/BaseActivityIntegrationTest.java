package com.rapidftr.activity;

import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.Solo;
import com.rapidftr.RapidFtrApplication;
import com.rapidftr.activity.pages.ChildPage;
import com.rapidftr.activity.pages.LoginPage;
import com.rapidftr.activity.pages.ViewAllChildrenPage;

public abstract class BaseActivityIntegrationTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public Solo solo;
    public LoginPage loginPage;
    public ViewAllChildrenPage viewAllChildrenPage;
    public ChildPage childPage;

    public BaseActivityIntegrationTest() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        loginPage = new LoginPage(solo);
        viewAllChildrenPage = new ViewAllChildrenPage(solo);
        childPage = new ChildPage(solo);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        RapidFtrApplication.getInstance().setLoggedIn(false);
    }
}
