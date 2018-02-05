package dp.school.utility.baseconnection;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
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
import dp.school.utility.AppController;
import dp.school.utility.utils.SharedPreferenceUtils;
import dp.school.views.ui.activity.ErrorActivity;


public class ConnectionUtils {
    private static final int CONNECTION_TIME_OUT = 8000;
    private static ConnectionUtils connectionPresenter = null;
    private static String AUTH_KEY = "kNWSzTpb5d3ZPILEsKUMsdPGsMEjtfcuDe6eBj8TFm365qyHzQvyX7IJRgbu9w6D";
    private  Dialog dialog;

    private ConnectionUtils() {

    }

    public static ConnectionUtils getInstance() {
        return connectionPresenter = ((connectionPresenter == null) ? (new ConnectionUtils()) : connectionPresenter);
    }

    public void createConnection(Object requestData, String url, final boolean haveHeaders, final boolean showLoadingBar ,int method, final ConnectionView connectionView) {
        if (showLoadingBar) {
            dialog = new Dialog(connectionView.getContext(), R.style.AppTheme);
            dialog.setContentView(R.layout.dialog_loading_bar);
            try {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            }catch (NullPointerException e){
                e.getStackTrace();
            }
            dialog.show();
        }

        JSONObject jsonObject = null;
        try {
            String requestString = new Gson().toJson(requestData);
            jsonObject = new JSONObject(requestString);
            System.out.println("Request : " + requestString);
        } catch (Exception e) {
            System.out.println("Catch 2 :"+e.getMessage());
            e.getStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if(dialog!=null&&showLoadingBar) {
                            dialog.cancel();
                        }
                        connectionView.onResponseSuccess(response.toString());
                        System.out.println("Response : " + response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if(dialog!=null&&showLoadingBar) {
                            dialog.cancel();
                        }
                        if(getErrorMessage(volleyError,connectionView.getContext())==null)
                            connectionView.onResponseError(volleyError.networkResponse.statusCode, "");
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                if (haveHeaders) {
                    //TODO add the auth token
                    params.put("Accept", "application/json");
                    params.put("Content-Type", "application/json");
                    params.put("key", AUTH_KEY);
                    params.put("Authorization","Bearer "+SharedPreferenceUtils.getUserKey());
                    System.out.println("Bearer "+SharedPreferenceUtils.getUserKey());
                }
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

    private String getErrorMessage(VolleyError volleyError, Context context) {
        Intent intent = new Intent(context, ErrorActivity.class);
        String message = null;
        if (volleyError instanceof NetworkError) {
            message = context.getResources().getString(R.string.label_network_error);
        } else if (volleyError instanceof ServerError) {
            message = context.getResources().getString(R.string.label_server_error);
        } else if (volleyError instanceof NoConnectionError) {
            message = context.getResources().getString(R.string.label_connection_error);
        } else if (volleyError instanceof TimeoutError) {
            message = context.getResources().getString(R.string.label_time_out_error);
        }else if (volleyError instanceof ParseError) {
            message = context.getResources().getString(R.string.label_parse_error);
        }else {
            message = context.getResources().getString(R.string.label_unknown_error);
        }
        ((Activity)context).finishAffinity();
        intent.putExtra("errorMessage",message);
        context.startActivity(intent);
        return message;
    }


    public static void downLoadImage(String url, ImageView imageView) {
        Picasso.with(AppController.getContext()).load(url).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).into(imageView);
    }
}
