package fr.rn605435.ndrawer

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomAdapter(val languageList: Array<Language>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val lang = languageList[position]
        holder.bindItems(languageList[position])

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return languageList.size
    }
    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    //the class is hodling the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(language: Language) {
            val textViewName = itemView.findViewById(R.id.textViewName) as TextView
            textViewName.text = language.name
            val imageViewImg = itemView.findViewById(R.id.imageViewImg) as ImageView
            imageViewImg.setImageResource(language.img)
            itemView.setOnClickListener {
                Toast.makeText(
                        itemView.context,
                       itemView.context.getString(R.string.languageName) + language.name,
                        Toast.LENGTH_LONG).show()
            }
        }
    }
}