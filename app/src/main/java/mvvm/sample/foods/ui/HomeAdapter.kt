package mvvm.sample.foods.ui

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import mvvm.sample.foods.BR.item
import mvvm.sample.foods.data.model.Food
import mvvm.sample.foods.databinding.FoodItemRowBinding
import mvvm.sample.foods.ui.base.DataBindingViewHolder

class HomeAdapter(
    private var items: MutableList<Food> = arrayListOf<Food>()
) : RecyclerView.Adapter<HomeAdapter.SimpleVideoHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SimpleVideoHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleVideoHolder {
        val binding  = FoodItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SimpleVideoHolder(binding)
    }

    inner class SimpleVideoHolder(dataBinding: ViewDataBinding)
        : DataBindingViewHolder<Food>(dataBinding)  {
        override fun onBind(t: Food): Unit = with(t) {
            dataBinding.setVariable(item,t)
        }
    }

    fun add(list: MutableList<Food>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }
}