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

public class BannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Object> listRecyclerItem;

    public BannerAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;}
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        // Присваиваем поля для заполнения элемента RecyclerView
        TextView id, name, description, price;
        public ItemViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            description=(TextView) itemView.findViewById(R.id.description);
            price=(TextView) itemView.findViewById(R.id.price);}}
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Создаем представление из Layout
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_banners, parent, false);
        return new ItemViewHolder((v));}
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
// Заполняем элемент данными
        ItemViewHolder _holder = (ItemViewHolder) holder;
        BannerModel catalog = (BannerModel) listRecyclerItem.get(position);
        _holder.name.setText(catalog.getName());
        _holder.description.setText(catalog.getDescription());
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

