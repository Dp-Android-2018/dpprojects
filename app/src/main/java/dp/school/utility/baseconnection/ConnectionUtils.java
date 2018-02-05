package dp.school.utility.baseconnection;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
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
                        connectionView.onResponseSuccess(response.toString());
                        System.out.println("Response : " + response.toString());
                       if(dialog!=null&&showLoadingBar) {
                           System.out.println("Dialog Has Been Cancelled 1");
                            dialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if(getErrorMessage(volleyError)==null)
                            connectionView.onResponseError(volleyError.networkResponse.statusCode, getErrorMessage(volleyError));
                       if(dialog!=null&&showLoadingBar) {
                           System.out.println("Dialog Has Been Cancelled 2");
                           dialog.dismiss();
                        }
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
                 //   params.put("Authorization","Bearer 7bqaeAu5aF5XrzNMKWDJfwKd7zxFG5FZ6HoV4PpXJ1139kSrE12iai59sLMq1paK");
                    params.put("Authorization","Bearer Mn1DKrcfrZ2yTIbFYISyc6N0Hoibe5GaA2RFVsIw8nU2s87c8wKhEqJEtM0dg1Vy");
                    params.put("Authorization","Bearer Mn1DKrcfrZ2yTIbFYISyc6N0Hoibe5GaA2RFVsIw8nU2s87c8wKhEqJEtM0dg1Vy");
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

    private String getErrorMessage(VolleyError volleyError) {
        String message = null;
        if (volleyError instanceof NetworkError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof ServerError) {
            message = "The server could not be found. Please try again after some time!!";
        } else if (volleyError instanceof NoConnectionError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof TimeoutError) {
            message = "Connection TimeOut! Please check your internet connection.";
        }
        System.out.println(message);
        return message;
    }


    public static void downLoadImage(String url, ImageView imageView) {
        Picasso.with(AppController.getContext()).load(url).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).into(imageView);
    }
}
