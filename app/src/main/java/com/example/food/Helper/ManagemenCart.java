package com.example.food.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.food.Activity.CartListActivity;
import com.example.food.Domain.FoodDomain;
import com.example.food.interfa.ChangeNumberITemListenr;

import java.util.ArrayList;

public class ManagemenCart {
    private Context context;
    private TinyDB tinyDb;

    public ManagemenCart(Context context, TinyDB tinyDb) {
        this.context = context;
        this.tinyDb = tinyDb;
    }

    public ManagemenCart(CartListActivity context) {
    }

    public  void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood= getListCart();
                boolean existAlready=false;
                int n =0;
                for (int i =0;i<listFood.size();i++){
                    if (listFood.get(i).getTitle().equals(item.getTitle())){
                        existAlready=true;
                        n=i;
                        break;
                    }
                }
                if (existAlready){
                    listFood.get(n).setNumberaIncart(item.getNumberaIncart());
                }else {
                    listFood.add(item);

                }
                tinyDb.putListObject("CardList",listFood);
                Toast.makeText(context,"added to your cart",Toast.LENGTH_LONG).show();

    }
    public ArrayList<FoodDomain>getListCart(){
        return  tinyDb.getListObject("CartList");
    }
    public void plusNumberFood(ArrayList<FoodDomain>listFood, int position, ChangeNumberITemListenr changeNumberITemListenr){
        listFood.get(position).setNumberaIncart(listFood.get(position).getNumberaIncart()+1);
        tinyDb.putListObject("CartList",listFood);
        changeNumberITemListenr.changed();

    }
    public void minusNumberFood(ArrayList<FoodDomain> listfood,int position,ChangeNumberITemListenr changeNumberITemListenr){
        if (listfood.get(position).getNumberaIncart()==1){
            listfood.remove(position);

        }else {
            listfood.get(position).setNumberaIncart(listfood.get(position).getNumberaIncart()-1);

        }
        tinyDb.putListObject("CartList",listfood);
        changeNumberITemListenr.changed();

    }
    public Double getTotalfee(){
        ArrayList<FoodDomain> listfood=getListCart();
        double fee=0;
        for (int i =0;i<listfood.size();i++){
            fee=fee+(listfood.get(i).getFee()*listfood.get(i).getNumberaIncart());

        }
        return fee;
    }
}
