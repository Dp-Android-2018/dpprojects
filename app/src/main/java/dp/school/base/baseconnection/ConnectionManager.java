package dp.school.base.baseconnection;

import android.app.Dialog;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import dp.school.R;
import dp.school.base.AppController;
import dp.school.request.BaseRequest;
import dp.school.response.teacherresponse.TeacherResponse;

/**
 * Created by PC on 19/12/2017.
 */

public class ConnectionManager {
    private static final int CONNECTION_TIME_OUT = 8000;
    private static ConnectionManager connectionPresenter = null;
    Dialog dialog;

    private ConnectionManager() {

    }

    public static ConnectionManager getInstance() {
        return connectionPresenter = ((connectionPresenter == null) ? (new ConnectionManager()) : connectionPresenter);
    }

    public void createConnection(Object requestData, String url, final boolean haveHeaders, final boolean showLoadingBar, final ConnectionView connectionView) {

        if (dialog == null) {
            dialog = new Dialog(connectionView.getContext(), R.style.AppTheme);
            dialog.setContentView(R.layout.dialog_loading_bar);
        }

        if (showLoadingBar) {
            dialog.show();
        }

        JSONObject jsonObject = null;
        try {
            String requestString = new Gson().toJson(requestData);
            jsonObject = new JSONObject(requestString);
            System.out.println("Request : " + requestString);
        } catch (Exception e) {
            e.getStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        connectionView.onResponseSuccess(response.toString());
                        System.out.println("Response : "+response.toString());
                        dialog.cancel();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        connectionView.onResponseError(volleyError.networkResponse.statusCode, getErrorMessage(volleyError));
                        dialog.cancel();
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                if (haveHeaders) {
                    //TODO add the auth token
                }
                params.put("Accept", "application/json");
                params.put("key", "kNWSzTpb5d3ZPILEsKUMsdPGsMEjtfcuDe6eBj8TFm365qyHzQvyX7IJRgbu9w6D");
                return params;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                CONNECTION_TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
    }

    private void showResponseMessages(int statueCode, String message) {

    }

    private String getErrorMessage(VolleyError volleyError) {
        String message = null;
        if (volleyError instanceof NetworkError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof ServerError) {
            message = "The server could not be found. Please try again after some time!!";
        } else if (volleyError instanceof AuthFailureError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof ParseError) {
            message = "Parsing error! Please try again after some time!!";
        } else if (volleyError instanceof NoConnectionError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof TimeoutError) {
            message = "Connection TimeOut! Please check your internet connection.";
        }
        return message;
    }


    public static void downLoadImage(String url, ImageView imageView) {
        Picasso.with(AppController.getContext()).load(url).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).into(imageView);
    }
}
