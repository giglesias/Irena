package com.prisma.irena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class PatientDetail extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_detail);

		Intent intent = getIntent();
		String qrData = intent.getStringExtra(MainActivity.EXTRA_QR_DATA);
		Bundle bundle = new Bundle();
		bundle.putString("QRDATA", qrData);

		if (savedInstanceState == null) {
			FragmentListDetail frgDetail = new FragmentListDetail();
			frgDetail.setArguments(bundle);
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, frgDetail).commit();
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class FragmentListDetail extends ListFragment {

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

}
