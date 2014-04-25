package com.prisma.irena;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentListDetail extends ListFragment {

	private String qrdata = "";

	public FragmentListDetail() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Bundle bundle = this.getArguments();
		this.qrdata = bundle.getString("QRDATA");
		View rootView = inflater.inflate(R.layout.fragment_patient_detail,
				container, false);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		PatientJSONParser parser = new PatientJSONParser();
		String[] patientData = parser.toListString(this.qrdata).toArray(new String[0]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        		getActivity(), 
        		android.R.layout.simple_list_item_1,
        		patientData);

        setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.i("FragmentList", "Item clicked: " + id);
	}
}