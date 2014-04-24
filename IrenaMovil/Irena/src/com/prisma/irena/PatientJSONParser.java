package com.prisma.irena;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.widget.Toast;

public class PatientJSONParser {

	/** Receives a JSONObject and returns a list **/
	public ArrayList<HashMap<String, String>> parse(String strJson) {
		ArrayList<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = null;

		try {
			JSONObject jPatient = new JSONObject(strJson);
			for (Iterator keyIterator = jPatient.keys(); keyIterator.hasNext();) {
				String key = (String) keyIterator.next();
				String value = jPatient.optString(key);
				map.put(key, value);
			}

			listData.add(map);
		} catch (JSONException e) {
			Log.d("JSONException", e.toString());
		} finally {
			listData = null;
		}
		return listData;
	}
}