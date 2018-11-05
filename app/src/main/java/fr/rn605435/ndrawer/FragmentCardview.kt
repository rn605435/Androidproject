package fr.rn605435.ndrawer


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_cardview.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_cardview.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentCardview : Fragment() {
    var items = Array<Language>(5) {Language()}
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_cardview, container, false)

        // Return the fragment view/layout
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity!!.title = "Cardview"
        seedItems()

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.adapter = CustomAdapter(items)

    }

    fun seedItems(){
        val langArray = resources.getStringArray(R.array.name)
        val imgArray = resources.getStringArray(R.array.src)
        for (i in 0..3){

        }
        for (k in 0..3){
            items[k] = Language(langArray[k], resources.getIdentifier(imgArray[k], "drawable", activity!!.packageName))
        }
    }

    private fun updateObjectList(adapter: CustomAdapter) {
        adapter.notifyDataSetChanged()
    }
}
