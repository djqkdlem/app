package info.baejw.sample.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.baejw.sample.R
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class RecyclerAdapter(val items: ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    private lateinit var pagerAdapter: VeiwpagerAdapter
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        holder?.name?.text = items.get(position)
        pagerAdapter = VeiwpagerAdapter(items, context)
        holder?.pager?.adapter = pagerAdapter
        val tabLayout = holder?.tabs
        tabLayout?.setupWithViewPager(holder?.pager)
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //    val name = view.list_item
    var pager = view.view_pager
    var tabs = view.tabs
}