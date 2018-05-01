package com.amotecsolution.faultintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FaultFragment extends Fragment {
    private Fault mFault;
    //private EditText mType;
    //private TextView mLocation;
    //private TextView mEquipment;
    private Button mButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFault = new Fault();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fault, container, false);

        mButton = (Button)v.findViewById(R.id.refresh);
        mButton.setText("Refresh");

        return v;

    }
}
