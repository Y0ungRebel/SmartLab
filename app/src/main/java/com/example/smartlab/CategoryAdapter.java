package com.example.smartlab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Object> listRecyclerItem;

    public CategoryAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;}
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        // Присваиваем поля для заполнения элемента RecyclerView
        Button category;
        public ItemViewHolder(View itemView) {
            super(itemView);
            category = (Button) itemView.findViewById(R.id.category);}}
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Создаем представление из Layout
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_categories, parent, false);
        return new CategoryAdapter.ItemViewHolder((v));}
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
// Заполняем элемент данными
        CategoryAdapter.ItemViewHolder _holder = (CategoryAdapter.ItemViewHolder) holder;
        CategoryModel catalog = (CategoryModel) listRecyclerItem.get(position);
        _holder.category.setText(catalog.getCategory());
// Пример реализации setOnClickListener для этого представления
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _holder.category.setOnClickListener(new View.OnClickListener() {
                    int check = 1;
                    @Override
                    public void onClick(View v) {
                        if (check == 1){
                            check = 0;
                            _holder.category.setBackgroundResource(R.drawable.btn_category_pressed);
                            _holder.category.setTextColor(ContextCompat.getColor(context, R.color.white));
                        }
                        else {
                            check = 1;
                            _holder.category.setBackgroundResource(R.drawable.btn_category_not_pressed);
                            _holder.category.setTextColor(ContextCompat.getColor(context, R.color.gray));
                        }
                    }
                });
            }});
    }

    @Override
    public int getItemCount() {
// Получает всё количесво элементов RecyclerView
        return listRecyclerItem.size();}}
