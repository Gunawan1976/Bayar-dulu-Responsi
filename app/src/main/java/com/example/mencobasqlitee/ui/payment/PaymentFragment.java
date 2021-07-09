package com.example.mencobasqlitee.ui.payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.databinding.FragmentPaymentBinding;
import com.example.mencobasqlitee.ui.PaymentActivity;

public class PaymentFragment extends Fragment {

    private PaymentViewModel paymentViewModel;
    private TextView payment;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        paymentViewModel = new ViewModelProvider(this).get(PaymentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_payment, container, false);
        payment = root.findViewById(R.id.tv_payment);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),PaymentActivity.class));
            }
        });


        return root;
    }
}