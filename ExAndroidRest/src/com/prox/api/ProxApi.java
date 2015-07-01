package com.prox.api;

import java.util.Date;

import retrofit.RestAdapter;
import android.util.Log;

import com.prox.api.util.DateFormatter;
import com.prox.api.util.ProxEndpoints;
import com.prox.api.util.ProxEndpoints.IProxAPI;

public class ProxApi {

	public static void getContributors() {
		// Create a very simple REST adapter which points the GitHub API
		// endpoint.
		RestAdapter restAdapter = new RestAdapter.Builder().setServer(ProxEndpoints.BASE_URL).build();

		// Create an instance of our GitHub API interface.
		IProxAPI api = restAdapter.create(IProxAPI.class);

		// Fetch and print a list of the contributors to this library.
		String appId = ProxEndpoints.getApplicationId();
		if (appId != null)
			api.totalUniqueVisitors(appId, DateFormatter.format(new Date()), DateFormatter.format(new Date()));
		else {
			Log.e("PROX", "FUCK");
		}
	}

	public static void getTotalVisitors() {
		// Create a very simple REST adapter which points the GitHub API
		// endpoint.
		RestAdapter restAdapter = new RestAdapter.Builder().setServer(ProxEndpoints.BASE_URL).build();

		// Create an instance of our GitHub API interface.
		IProxAPI api = restAdapter.create(IProxAPI.class);

		// Fetch and print a list of the contributors to this library.
		String appId = ProxEndpoints.getApplicationId();
		if (appId != null)
			api.totalVisitors(appId, DateFormatter.format(new Date()), DateFormatter.format(new Date()));
		else {
			Log.e("PROX", "FUCK");
		}
	}

	public static void getVenueVisitLength() {
		// Create a very simple REST adapter which points the GitHub API
		// endpoint.
		RestAdapter restAdapter = new RestAdapter.Builder().setServer(ProxEndpoints.BASE_URL).build();

		// Create an instance of our GitHub API interface.
		IProxAPI api = restAdapter.create(IProxAPI.class);

		// Fetch and print a list of the contributors to this library.
		String appId = ProxEndpoints.getApplicationId();
		if (appId != null) {
			Log.e("PROX", DateFormatter.format(new Date()));
			api.venueVisitLength(appId, DateFormatter.format(new Date()), DateFormatter.format(new Date()));
		} else {
			Log.e("PROX", "FUCK");
		}
	}
}
