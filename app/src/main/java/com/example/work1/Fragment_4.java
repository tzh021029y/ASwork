package com.example.work1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class Fragment_4 extends Fragment {
    private Button M_on;
    private Button M_off;
    private Button button_bind;
    private Button button_unbind;
    private MyService.Mybinder mybinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_4, container, false);
        M_on=view.findViewById(R.id.M_on);
        M_off=view.findViewById(R.id.M_off);
        button_bind=view.findViewById(R.id.button_bind);
        button_unbind=view.findViewById(R.id.button_unbind);
        Intent intent=new Intent(getContext(),MyService.class);
//        M_on.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("server","click");
//                getActivity().startService(intent);
//
//            }
//        });
//        M_off.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().stopService(intent);
//            }
//        });

        Intent intent1=new Intent(getContext(),MyService.class);
        ServiceConnection connection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mybinder=(MyService.Mybinder)iBinder;
                mybinder.play();
            }
            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                mybinder=null;
            }
        };
        button_bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().bindService(intent1,connection, Context.BIND_AUTO_CREATE);
            }
        });
        button_unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().unbindService(connection);
            }
        });
        return view;

    }



}