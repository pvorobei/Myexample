package com.example.mydirectory;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private   DrawerLayout drawer;
    private ListView list;                       //Список элементов (листВью)
    private  String [] array_1;                     //Массив строк, который в arrays
    private ArrayAdapter<String> adapter_1;
    private int category;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                                 //После загрузки активити
        list = findViewById(R.id.listView);                                     //Ищем наш листВью для списка элементов
        array_1 = getResources().getStringArray(R.array.one_kategory_array);    //Получаем доступ к списку элементов
        adapter_1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array_1)));
        list.setAdapter(adapter_1);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // toolbar.setTitle(R.string.kat_one);
         drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TextContentActivity.class); //Сообщение системе о том что мы из этого активити хотим перейти в другое
                intent.putExtra("category", category);
                intent.putExtra("element", position);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.kat_one);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.id_two_kat) {
            toolbar.setTitle(R.string.kat_two);
            array_1 = getResources().getStringArray(R.array.two_kategory_array);                 //Достаем массив строк из ресуросов
            adapter_1.clear();                                                                   //очищаем адаптер
            adapter_1.addAll(array_1);                                                           //Добавляем массив строк
            adapter_1.notifyDataSetChanged();                                                    //Говорим адаптеру, что произошли изменения
            category = 1;
            Toast.makeText(this, "Вход в категорию 2", Toast.LENGTH_SHORT).show();  //просто уведомление
        }
        else  if (id == R.id.id_one_kat){
            toolbar.setTitle(R.string.kat_one);
            array_1 = getResources().getStringArray(R.array.one_kategory_array);
            adapter_1.clear();
            adapter_1.addAll(array_1);
            adapter_1.notifyDataSetChanged();
            category = 0;
            Toast.makeText(this, "Вход в категорию 1", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.id_thry_kat){
            toolbar.setTitle(R.string.kat_three);
            array_1 = getResources().getStringArray(R.array.thry_kategory_array);
            adapter_1.clear();
            adapter_1.addAll(array_1);
            adapter_1.notifyDataSetChanged();
            category = 2;
            Toast.makeText(this, "Вход в категорию 3", Toast.LENGTH_SHORT).show();
        }
                else if (id == R.id.other){
            toolbar.setTitle(R.string.kat_four);
            array_1 = getResources().getStringArray(R.array.other_array);
            adapter_1.clear();
            adapter_1.addAll(array_1);
            adapter_1.notifyDataSetChanged();
            category = 3;
            Toast.makeText(this, "Вход в other ", Toast.LENGTH_SHORT).show();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }}