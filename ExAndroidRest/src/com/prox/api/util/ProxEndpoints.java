package com.prox.api.util;

import java.io.UnsupportedEncodingException;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import android.util.Base64;

import com.prox.api.test.GitHubClientTest.Contributor;

public class ProxEndpoints {

	public final static String BASE_URL = "https://gsdev.proxdk.net/api/analytics/";
	public final static String CLIENT_KEY = "f4b434b4554148202017427bb2c753bbf848db34";
	public final static String APPLICATION_ID = "9c929f57db664a7ff4805d76628bfe94";

	public static String getApplicationId() {
		String res = null;
		try {
			byte[] data = (CLIENT_KEY + ":" + APPLICATION_ID).getBytes("UTF-8");
			res = Base64.encodeToString(data, Base64.DEFAULT);
		} catch (UnsupportedEncodingException e1) {
			// nothing interesting
		}
		return res;
	}

	public interface IProxAPI {
		@POST("/{application_id}/totvisitors/{start_date}/{end_date}")
		String totalUniqueVisitors(@Path("application_id") String applicationId,
				@Path("start_date") String startDate, @Path("end_date") String endDate);

		@GET("/repos/{owner}/{repo}/contributors")
		void contributors(@Path("owner") String owner, @Path("repo") String repo,
				Callback<List<Contributor>> callback);
	}

	// old version
	public String getTotalUniqueVisitors(String applicationId, String startDate, String endDate) {
		if (getApplicationId() == null)
			return null;
		return BASE_URL + getApplicationId() + "/totvisitors/" + startDate + "/" + endDate;
	}

}
