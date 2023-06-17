package com.example.smartlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnalyzeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Object> listRecyclerItem;

    public AnalyzeAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;}
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        // Присваиваем поля для заполнения элемента RecyclerView
        TextView id, name, description, price, category, time_result, preparation, bio;
        public ItemViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            time_result=(TextView) itemView.findViewById(R.id.time_result);
            price=(TextView) itemView.findViewById(R.id.price);}}
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Создаем представление из Layout
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_analyze, parent, false);
        return new AnalyzeAdapter.ItemViewHolder((v));}
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
// Заполняем элемент данными
        AnalyzeAdapter.ItemViewHolder _holder = (AnalyzeAdapter.ItemViewHolder) holder;
        AnalyzeModel catalog = (AnalyzeModel) listRecyclerItem.get(position);
        _holder.name.setText(catalog.getName());
        _holder.time_result.setText(catalog.getTime_result());
        _holder.price.setText(catalog.getPrice());
// Пример реализации setOnClickListener для этого представления
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, catalog.getId(), Toast.LENGTH_SHORT).show();}});}
    @Override
    public int getItemCount() {
// Получает всёё количесво элементов RecyclerView
        return listRecyclerItem.size();}}
