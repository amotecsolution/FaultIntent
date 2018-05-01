package com.amotecsolution.faultintent;

import android.support.v4.app.Fragment;

public class FaultListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FaultListFragment();
    }
}
