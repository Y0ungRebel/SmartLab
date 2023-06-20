package com.example.smartlab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class AnalyzeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Object> listRecyclerItem;
    private final RelativeLayout cartField;

/*    public AnalyzeAdapter(Context context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;}*/

    public AnalyzeAdapter(Context context, List<Object> listRecyclerItem, RelativeLayout cartField) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
        this.cartField = cartField;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        // Присваиваем поля для заполнения элемента RecyclerView
        TextView id, name, description, price, category, time_result, preparation, bio;
        Button btn_add;
        public ItemViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            time_result=(TextView) itemView.findViewById(R.id.time_result);
            btn_add=(Button) itemView.findViewById(R.id.button_add_item);
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
        _holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //listener.onItemClick(v, position);
                //RelativeLayout cartField = new RelativeLayout(context);
                //View cartView = cartField.findViewById(R.id.cart_view);
                Button btnCart = cartField.findViewById(R.id.btn_cart);
                TextView cartPrice = cartField.findViewById(R.id.cart_price);

                if (_holder.btn_add.getText().equals("Добавить")){
                    cartField.setVisibility(View.VISIBLE);
                    _holder.btn_add.setBackgroundResource(R.drawable.btn_delete);
                    _holder.btn_add.setTextColor(ContextCompat.getColor(context, R.color.buttonLogInActive));
                    _holder.btn_add.setText("Убрать");
                    cartPrice.setText(catalog.getPrice() + " ₽");
                    btnCart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
                }
                else if(_holder.btn_add.getText().equals("Убрать")){
                    _holder.btn_add.setBackgroundResource(R.drawable.button_add_item);
                    _holder.btn_add.setTextColor(ContextCompat.getColor(context, R.color.white));
                    _holder.btn_add.setText("Добавить");
                    cartPrice.setText("");
                    cartField.setVisibility(View.INVISIBLE);
                }
            }
        });
// Пример реализации setOnClickListener для этого представления
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
                bottomSheetDialog.setContentView(R.layout.layout_bottom_sheet);
                TextView name = bottomSheetDialog.findViewById(R.id.bs_name);
                TextView description = bottomSheetDialog.findViewById(R.id.bs_description_text);
                TextView preparation = bottomSheetDialog.findViewById(R.id.bs_preparation_text);
                TextView time_result = bottomSheetDialog.findViewById(R.id.bs_results_text);
                TextView bio = bottomSheetDialog.findViewById(R.id.bs_bio_text);
                Button price = bottomSheetDialog.findViewById(R.id.bs_add);
                ImageButton close = bottomSheetDialog.findViewById(R.id.btn_close);

                name.setText(catalog.getName());
                description.setText(catalog.getDescription());
                preparation.setText(catalog.getPreparation());
                time_result.setText(catalog.getTime_result());
                bio.setText(catalog.getBio());
                price.setText("Добавить за " + catalog.getPrice() + " ₽");
                //Toast.makeText(context, catalog.getId(), Toast.LENGTH_SHORT).show();

                bottomSheetDialog.show();

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //bottomSheetDialog.setCanceledOnTouchOutside(true);
                        bottomSheetDialog.dismiss();
                    }
                });
            }});
    }

    @Override
    public int getItemCount() {
// Получает всёё количесво элементов RecyclerView
        return listRecyclerItem.size();}}
