package com.amotecsolution.faultintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import com.rethinkdb.RethinkDB;

public class FaultListFragment extends Fragment {

    private RecyclerView mFaultRecyclerView;
    private FaultAdapter mFaultAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mFault = new Fault();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fault_list, container, false);
        mFaultRecyclerView = (RecyclerView) view
                .findViewById(R.id.fault_recycler_view);
        mFaultRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI() {
        FaultLab faultLab = FaultLab.get(getActivity());
        List<Fault> faults = faultLab.getFaults();

        mFaultAdapter = new FaultAdapter(faults);
        mFaultRecyclerView.setAdapter(mFaultAdapter);
    }

    private class FaultHolder extends RecyclerView.ViewHolder {

        private TextView mLocationTextView;
        private TextView mTypeTextView;
        private  Fault mFault;

        public void bind(Fault fault) {
            mFault = fault;
            mLocationTextView.setText(mFault.getLocation());
            mTypeTextView.setText(mFault.getType());
        }

        public FaultHolder(LayoutInflater inflater,  ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_fault, parent, false));

            mLocationTextView = (TextView)itemView.findViewById(R.id.fault_location);
            mTypeTextView = (TextView)itemView.findViewById(R.id.fault_type);
        }
    }

    private class FaultAdapter extends RecyclerView.Adapter<FaultHolder> {
        private List<Fault> mFaults;

        public FaultAdapter(List<Fault> faults) {
            mFaults = faults;
        }

        @NonNull
        @Override
        public FaultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new FaultHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull FaultHolder holder, int position) {
            Fault fault = mFaults.get(position);
            holder.bind(fault);
        }

        @Override
        public int getItemCount() {
            return mFaults.size();
        }
    }
}
