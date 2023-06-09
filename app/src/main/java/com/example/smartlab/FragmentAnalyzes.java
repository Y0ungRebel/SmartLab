package com.example.smartlab;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FragmentAnalyzes extends Fragment {

    //Button element;
    Button btn_cart;
    JSONArray array_banner, array_analyze, array_category;
    private RecyclerView recyclerView_banner, recyclerView_analyze, recyclerView_category;
    private List<Object> viewItems_banner = new ArrayList<>();
    private List<Object> viewItems_analyze = new ArrayList<>();
    private List<Object> viewItems_category = new ArrayList<>();

    RelativeLayout cartField;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_analyzes, container, false);
        new GetTask().execute(new JSONObject());
        new GetTaskAnalyze().execute(new JSONObject());
        new GetTaskCategory().execute(new JSONObject());

        recyclerView_banner=(RecyclerView) v.findViewById(R.id.bannersRecyclerView);
        recyclerView_analyze=(RecyclerView) v.findViewById(R.id.analyzesRecyclerView);
        recyclerView_category=(RecyclerView) v.findViewById(R.id.categoriesRecyclerView);
        cartField=(RelativeLayout) v.findViewById(R.id.cart_field);

        CategoryAdapter adapter_category = new CategoryAdapter(getContext(), viewItems_category);
        recyclerView_category.setAdapter(adapter_category);
        AnalyzeAdapter adapter_analyze = new AnalyzeAdapter(getContext(), viewItems_analyze, cartField);  //new CatalogItemListener()
        //{
//            @Override
//            public void onItemClick(View v, int position) {
//                RelativeLayout cartField = new RelativeLayout(getContext());
//                cartField.setVisibility(View.VISIBLE);
//                String s = "1";
//            }
        //});
        //AnalyzeAdapter adapter_analyze = new AnalyzeAdapter(getContext(), viewItems_analyze);
        recyclerView_analyze.setAdapter(adapter_analyze);
        BannerAdapter adapter_banner = new BannerAdapter(getContext(), viewItems_banner);
        recyclerView_banner.setAdapter(adapter_banner);

        return v;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        //use the elements in this method
        //element = view.findViewById(R.id.)


    }
    public void onClick(View view){

    }


    private class GetTask extends AsyncTask<JSONObject, Void, String> {
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            try {
                InputStream stream = null;
// Для буферизации текста из потока
                BufferedReader reader=null;
                HttpURLConnection connection = null;
                try {
// Присваиваем путь
                    URL url = new URL("http://10.0.2.2:8000/api/news/");
                    connection =(HttpURLConnection)url.openConnection();
// Выбираем метод GET для запроса
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(10000);
                    connection.connect();
// Полученный результат разбиваем с помощью байтовых потоков
                    stream = connection.getInputStream();
                    reader= new BufferedReader(new InputStreamReader(stream));
                    StringBuilder buf=new StringBuilder();
                    String line;
                    while ((line=reader.readLine()) != null) {
                        buf.append(line).append("\n");
                    }
                    JSONObject root = new JSONObject(buf.toString());
                    array_banner= root.getJSONArray("results");
                    addItemsFromJSON();
                    return(buf.toString());
                } catch (Exception e) {e.getMessage();}
            } catch (Exception e) {e.printStackTrace();}

            return null;
        }
    }

    private void addItemsFromJSON() {
        try {
// Заполняем Модель спаршенными данными
            for (int i=0; i<array_banner.length(); ++i) {
                JSONObject itemObj = array_banner.getJSONObject(i);
                String id = itemObj.getString("id");
                String name = itemObj.getString("name");
                String description = itemObj.getString("description");
                String price = itemObj.getString("price");
                BannerModel bannerModel = new BannerModel(id,name,description, price);
                viewItems_banner.add(bannerModel);}
        } catch (JSONException e) {
        }}




    private class GetTaskAnalyze extends AsyncTask<JSONObject, Void, String> {
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            try {
                InputStream stream = null;
// Для буферизации текста из потока
                BufferedReader reader=null;
                HttpURLConnection connection = null;
                try {
// Присваиваем путь
                    URL url_analyze = new URL("http://10.0.2.2:8000/api/catalog/");
                    connection =(HttpURLConnection)url_analyze.openConnection();
// Выбираем метод GET для запроса
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(10000);
                    connection.connect();
// Полученный результат разбиваем с помощью байтовых потоков
                    stream = connection.getInputStream();
                    reader= new BufferedReader(new InputStreamReader(stream));
                    StringBuilder buf=new StringBuilder();
                    String line;
                    while ((line=reader.readLine()) != null) {
                        buf.append(line).append("\n");
                    }
                    JSONObject root = new JSONObject(buf.toString());
                    array_analyze= root.getJSONArray("results");
                    addItemsFromJSON_analyze();
                    return(buf.toString());
                } catch (Exception e) {e.getMessage();}
            } catch (Exception e) {e.printStackTrace();}

            return null;
        }
    }

    private void addItemsFromJSON_analyze() {
        try {
// Заполняем Модель спаршенными данными
            for (int i=0; i<array_analyze.length(); ++i) {
                JSONObject itemObj = array_analyze.getJSONObject(i);
                String id = itemObj.getString("id");
                String name = itemObj.getString("name");
                String description = itemObj.getString("description");
                String price = itemObj.getString("price");
                String category = itemObj.getString("category");
                String time_result = itemObj.getString("time_result");
                String preparation = itemObj.getString("preparation");
                String bio = itemObj.getString("bio");
                AnalyzeModel analyzeModel = new AnalyzeModel(id, name, description, price, category, time_result, preparation, bio);
                viewItems_analyze.add(analyzeModel);}
        } catch (JSONException e) {
        }
    }

    private class GetTaskCategory extends AsyncTask<JSONObject, Void, String> {
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            try {
                InputStream stream = null;
// Для буферизации текста из потока
                BufferedReader reader=null;
                HttpURLConnection connection = null;
                try {
// Присваиваем путь
                    URL url_analyze = new URL("http://10.0.2.2:8000/api/category/");
                    connection =(HttpURLConnection)url_analyze.openConnection();
// Выбираем метод GET для запроса
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(10000);
                    connection.connect();
// Полученный результат разбиваем с помощью байтовых потоков
                    stream = connection.getInputStream();
                    reader= new BufferedReader(new InputStreamReader(stream));
                    StringBuilder buf=new StringBuilder();
                    String line;
                    while ((line=reader.readLine()) != null) {
                        buf.append(line).append("\n");
                    }
                    JSONObject root = new JSONObject(buf.toString());
                    array_category= root.getJSONArray("results");
                    addItemsFromJSON_category();
                    return(buf.toString());
                } catch (Exception e) {e.getMessage();}
            } catch (Exception e) {e.printStackTrace();}

            return null;
        }
    }

    private void addItemsFromJSON_category() {
        try {
// Заполняем Модель спаршенными данными
            for (int i=0; i<array_category.length(); ++i) {
                JSONObject itemObj = array_category.getJSONObject(i);
                String category = itemObj.getString("name");
                CategoryModel categoryModel = new CategoryModel(category);
                viewItems_category.add(categoryModel);}
        } catch (JSONException e) {
        }}
}

