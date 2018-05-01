package com.amotecsolution.faultintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class FaultActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FaultFragment();
    }
}
