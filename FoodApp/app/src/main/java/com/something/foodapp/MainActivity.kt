package com.something.foodapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var adapter:Foodadapter?=null
    var listofFoods = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load food

        listofFoods.add(Food("Coffee","  Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain coffee species.",R.drawable.coffee_pot))
        listofFoods.add(Food("Espresso","  Espresso is coffee of italian origin,brewed by forcing a small amount of nearly boiling water under pressure through finely ground coffee beans.",R.drawable.espresso))
        listofFoods.add(Food("French Fries","  French fries are batonnet or allumetecut deep-fried potatoes",R.drawable.french_fries))
        listofFoods.add(Food("Honey","  Honey is a sweet, viscous food substance made by bees and some related insects.",R.drawable.honey))
        listofFoods.add(Food("Strawberry","  Strawberry ice cream is a flavour ice cream made with strawberry or strawberry flavoring.",R.drawable.strawberry_ice_cream))
        listofFoods.add(Food("Sugar cubes","  A small cube of compacted sugar used especially for sweetening hot drinks.",R.drawable.sugar_cubes))

        adapter = Foodadapter(this,listofFoods)

        gvListname.adapter = adapter
    }

    class Foodadapter:BaseAdapter{
        var listofFood = ArrayList<Food>()
        var context:Context?=null
        constructor(context: Context,listofFood:ArrayList<Food>):super(){
            this.context=context
            this.listofFood=listofFood
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val food = this.listofFood[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodview = inflater.inflate(R.layout.food_ticket,null)
            foodview.ivFoodimage.setImageResource(food.image!!)
            foodview.ivFoodimage.setOnClickListener {
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodview.tvName.text = food.name!!
            return foodview

        }

        override fun getItem(position: Int): Any {
            return listofFood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
           return listofFood.size
        }

    }
}
