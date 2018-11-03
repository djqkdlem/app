package info.baejw.sample.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.baejw.sample.R
import info.baejw.sample.common.GlideApp
import kotlinx.android.synthetic.main.item_viewpager.view.*

class VeiwpagerAdapter(val items: ArrayList<String>, val context: Context) : PagerAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getPageTitle(position: Int): CharSequence {
        return ""
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_viewpager, container, false)

        GlideApp.with(context).load("http://www.beffreport.com/news/photo/201803/42671_21636_2025.jpg").into(view.pager_image)
        container.addView(view)
        return view
    }
}