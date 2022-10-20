package com.example.work1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    private ImageView imageView1,imageView2,imageView3,imageView4;
    private Fragment fragment_1,fragment_2,fragment_3,fragment_4;
    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("aaa","onstart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("aaa","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("aaa","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("aaa","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("aaa","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("aaa","onRestart");
    }

    private TextView textView3;
    private TextView textView4;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eleminit();
        fragmentinit();
        FragmentTransaction ft=fragmentManager.beginTransaction()
                .hide(fragment_2)
                .hide(fragment_3)
                .hide(fragment_4);
        ft.commit();
        Log.d("aaa","onCreate");
    }

    private void fragmentinit() {
        fragment_1=new Fragment_1();
        fragment_2=new Fragment_2();
        fragment_3=new Fragment_3();
        fragment_4=new Fragment_4();
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction()
                .add(R.id.frameLayout,fragment_1)
                .add(R.id.frameLayout,fragment_2)
                .add(R.id.frameLayout,fragment_3)
                .add(R.id.frameLayout,fragment_4);
                ft.commit();
    }

    private void eleminit() {
        linearLayout1=findViewById(R.id.linearLayout1);
        linearLayout2=findViewById(R.id.linearLayout2);
        linearLayout3=findViewById(R.id.linearLayout3);
        linearLayout4=findViewById(R.id.linearLayout4);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);

        imageView1=findViewById(R.id.imageView1);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linearLayout1:
                select(1);
                break;

            case R.id.linearLayout2:
                select(2);
                break;

            case R.id.linearLayout3:
                select(3);
                break;

            case R.id.linearLayout4:
                select(4);
                break;
        }
    }

    @SuppressLint("ResourceAsColor")
    private void select(int i) {
        TextView textView_top=findViewById(R.id.textView_top);
        FragmentTransaction ft=fragmentManager.beginTransaction();
        remake();
        hide(ft);
        switch (i){
            case 1:
                ft.show(fragment_1);
                imageView1.setImageResource(R.drawable.wx);
                textView_top.setText(R.string.weixin);
                textView1.setTextColor(R.color.bluegreen);
                break;
            case 2:
                ft.show(fragment_2);
                imageView2.setImageResource(R.drawable.tongxunlu);
                textView_top.setText(R.string.tongxunlu);
                textView2.setTextColor(R.color.bluegreen);
                break;
            case 3:
                ft.show(fragment_3);
                imageView3.setImageResource(R.drawable.faxian);
                textView_top.setText(R.string.faxian);
                textView3.setTextColor(R.color.bluegreen);
                break;
            case 4:
                ft.show(fragment_4);
                imageView4.setImageResource(R.drawable.my);
                textView_top.setText(R.string.wo);
                textView4.setTextColor(R.color.bluegreen);
                break;
        }
        ft.commit();
    }

    @SuppressLint("ResourceAsColor")
    private void remake() {
        imageView1.setImageResource(R.drawable.wxh);
        imageView2.setImageResource(R.drawable.tongxunluhui);
        imageView3.setImageResource(R.drawable.faxianhui);
        imageView4.setImageResource(R.drawable.myhui);

        textView1.setTextColor(R.color.black);
        textView2.setTextColor(R.color.black);
        textView3.setTextColor(R.color.black);
        textView4.setTextColor(R.color.black);

    }

    private void hide(FragmentTransaction ft) {
        ft.hide(fragment_1)
            .hide(fragment_2)
            .hide(fragment_3)
            .hide(fragment_4);

    }



}