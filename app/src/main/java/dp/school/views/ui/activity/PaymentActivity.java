package dp.school.views.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import dp.school.R;
import dp.school.views.ui.adapter.PaymentAdapter;
import dp.school.model.gloabal.Children;
import dp.school.model.gloabal.PaymentModel;

/**
 * Created by DELL on 22/01/2018.
 */

public class PaymentActivity extends AppCompatActivity {
    private ArrayList<PaymentModel>paymentModels;
    private ArrayList<Children>children;
    private ArrayList<Children>children2;
    private ArrayList<Children>children3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_layout);
        paymentModels=new ArrayList<>();
        children=new ArrayList<>();
        children2=new ArrayList<>();
        children3=new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_payment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        children.add(new Children("Fees Num 1",true));
        children.add(new Children("Bus Num 1",false));
        children.add(new Children("Fees Num 1",true));
        children.add(new Children("Bus Num 1",false));



        children2.add(new Children("Fees Num 2",false));
        children2.add(new Children("Bus Num 2",true));
        children2.add(new Children("Fees Num 2",false));
        children2.add(new Children("Bus Num 2",true));


        children3.add(new Children("Fees Num 3",false));
        children3.add(new Children("Bus Num 3",true));
        children3.add(new Children("Fees Num 3",false));
        children3.add(new Children("Bus Num 3",true));
        PaymentModel paymentModel=new PaymentModel("2018",children);
        PaymentModel paymentModel2=new PaymentModel("2019",children2);
        PaymentModel paymentModel3=new PaymentModel("2020",children3);

        paymentModels.add(paymentModel);
        paymentModels.add(paymentModel2);
        paymentModels.add(paymentModel3);
        PaymentAdapter adapter = new PaymentAdapter(paymentModels);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
