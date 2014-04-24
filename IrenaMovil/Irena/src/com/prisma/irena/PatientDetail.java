package com.prisma.irena;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class PatientDetail extends ActionBarActivity {

	JSONObject jPatient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_detail);
		
		Intent intent = getIntent();
		String qrData = intent.getStringExtra(MainActivity.EXTRA_QR_DATA);
		Bundle bundle = new Bundle();
		bundle.putString("QRDATA", qrData);

		PlaceholderFragment frgDetail = new PlaceholderFragment();
		frgDetail.setArguments(bundle);
		
		if (savedInstanceState == null) {
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
	public static class PlaceholderFragment extends Fragment {

		private String data = "";
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			Bundle bundle = this.getArguments();
			this.data = bundle.getString("QRDATA");
			View rootView = inflater.inflate(R.layout.fragment_patient_detail,
					container, false);
			TextView tvData = (TextView) rootView.findViewById(R.id.empty);
			tvData.setText("Scan Result = " + this.data);
			return rootView;
		}
		
	}

}
