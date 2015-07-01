package com.prox.api.util;

import retrofit.http.POST;
import retrofit.http.Path;
import android.util.Base64;

public class ProxEndpoints {

	public final static String BASE_URL = "https://gsdev.proxdk.net/api/analytics/";
	public final static String CLIENT_KEY = "f4b434b4554148202017427bb2c753bbf848db34";
	public final static String APPLICATION_ID = "9c929f57db664a7ff4805d76628bfe94";

	public static String getApplicationId() {
		String res = null;
		byte[] data = (CLIENT_KEY + ":" + APPLICATION_ID).getBytes();
		res = Base64.encodeToString(data, Base64.DEFAULT);
		return res;
	}

	public interface IProxAPI {
		@POST("/{application_id}/totvisitors/{start_date}/{end_date}")
		String totalUniqueVisitors(@Path("application_id") String applicationId,
				@Path("start_date") String startDate, @Path("end_date") String endDate);

		@POST("/{application_id}/totvisits/{start_date}/{end_date}")
		String totalVisitors(@Path("application_id") String applicationId,
				@Path("start_date") String startDate, @Path("end_date") String endDate);

		@POST("/{application_id}/totvisitlen/{start_date}/{end_date}")
		String venueVisitLength(@Path("application_id") String applicationId,
				@Path("start_date") String startDate, @Path("end_date") String endDate);

	}

	// old version
	public String getTotalUniqueVisitors(String applicationId, String startDate, String endDate) {
		if (getApplicationId() == null)
			return null;
		return BASE_URL + getApplicationId() + "/totvisitors/" + startDate + "/" + endDate;
	}

}
