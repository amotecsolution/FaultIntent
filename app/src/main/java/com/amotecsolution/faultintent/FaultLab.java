package com.amotecsolution.faultintent;

import android.content.Context;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class FaultLab {
    private static FaultLab sFaultLab;
    private List<Fault> mFaults;


    public static FaultLab get (Context context) {
        if (sFaultLab == null) {
            sFaultLab = new FaultLab(context);
        }
        return sFaultLab;
    }

    private FaultLab(Context context) {
        mFaults = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Fault fault = new Fault();
            fault.setLocation("Location #" + i);
            fault.setType("Unknown");
            fault.setEquipment("XXX");
            mFaults.add(fault);
        }
    }

    public List<Fault> getFaults() {
        return mFaults;
    }

    public Fault getFault(UUID id) {
        for (Fault fault: mFaults) {
            if (fault.getId().equals(id)) {
                return fault;
            }
        }
        return null;
    }
}
