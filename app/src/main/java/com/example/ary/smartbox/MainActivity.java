package com.example.ary.smartbox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    Button on1;
    Button on2;
    Button off1;
    Button off2;

@Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        on1 = (Button) findViewById(R.id.on1);
        on2 = (Button) findViewById(R.id.on2);
        off1 = (Button) findViewById(R.id.off1);
        off2 = (Button) findViewById(R.id.off2);


        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        loadFragment(new frag_lampadas());

    }
    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.lampadas:
                fragment = new frag_lampadas();
                break;
            case R.id.temperatura:
                fragment = new frag_temperatura();
                break;
            case R.id.controle:
                fragment = new frag_controle();
                break;

        }
        return loadFragment(fragment);
    }
}
