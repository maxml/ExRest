package com.prox.api.ui;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.prox.api.ProxApi;
import com.prox.api.R;
import com.prox.api.test.GitHubClientTest;
import com.prox.api.test.GitHubClientTest.Contributor;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						getContributors();
						return null;
					}
				}.execute();

			}
		});
	}

	private void getContributors() {
		// ProxApi.getContributors();
		try {
			ProxApi.getContributors();
		} catch (RetrofitError e) {
			System.out.println(e.getResponse().getStatus());
			System.out.println(e.getUrl());

		}
		// new Callback<String>() {
		//
		// @Override
		// public void failure(final RetrofitError arg0) {
		// runOnUiThread(new Runnable() {
		//
		// @Override
		// public void run() {
		// Toast.makeText(MainActivity.this, "FAILURE",
		// Toast.LENGTH_SHORT).show();
		// Log.e("PROX", "failure", arg0);
		// Log.e("PROX", arg0.getBody().toString());
		// Log.e("PROX", arg0.getUrl());
		// Log.e("PROX", arg0.getMessage());
		// }
		// });
		//
		// }
		//
		// @Override
		// public void success(final String arg0, final Response arg1) {
		// runOnUiThread(new Runnable() {
		//
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// Toast.makeText(MainActivity.this, arg0 + arg1.getStatus(),
		// Toast.LENGTH_SHORT).show();
		// Log.e("PROX", arg1.toString());
		// Log.e("PROX", arg1.getHeaders().toString());
		// Log.e("PROX", arg1.getBody().toString());
		// }
		// });
		//
		// }
		// });
	}

	@SuppressWarnings("unused")
	private void startTest() {
		// mListView = getListView();
		GitHubClientTest.getContributors(callback);
	}

	private ListView mListView;
	private Callback<List<Contributor>> callback = new Callback<List<Contributor>>() {

		@Override
		public void success(List<Contributor> contributors, Response response) {
			ArrayAdapter<Contributor> adapter = new ArrayAdapter<GitHubClientTest.Contributor>(
					getApplicationContext(), android.R.layout.simple_list_item_1, contributors);
			mListView.setAdapter(adapter);
		}

		@Override
		public void failure(RetrofitError error) {
		}
	};

}
