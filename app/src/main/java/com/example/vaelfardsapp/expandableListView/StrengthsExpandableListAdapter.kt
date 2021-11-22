package com.example.vaelfardsapp.expandableListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.vaelfardsapp.R
import com.example.vaelfardsapp.models.questionModel

class StrengthsExpandableListAdapter(
    var context: Context?,
    private var modelArray: ArrayList<questionModel>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return modelArray.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return modelArray.size - modelArray.lastIndex
    }

    override fun getGroup(groupPosition: Int): String {
        return modelArray[groupPosition].styrkeName
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return modelArray[groupPosition].styrkeTxt
    }

    private fun getIcon(groupPosition: Int): Int {
        return modelArray[groupPosition].imagePath
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        if (convertView == null) {
            val inflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_group, null)
        }
        val indicator = convertView?.findViewById<ImageView>(R.id.indicator)
        val title = convertView?.findViewById<TextView>(R.id.tv_title)
        val icon = convertView?.findViewById<ImageView>(R.id.ic_strength)

        if (isExpanded) {
            indicator?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
        } else {
            indicator?.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
        }

        title?.text = getGroup(groupPosition)
        icon?.setImageResource(getIcon(groupPosition))
        return convertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        if (convertView == null) {
            val inflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_child, null)
        }

        val title = convertView?.findViewById<TextView>(R.id.tv_child)
        title?.text = getChild(groupPosition, groupPosition)
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }
}