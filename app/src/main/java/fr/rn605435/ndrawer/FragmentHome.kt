package fr.rn605435.ndrawer


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat.finishAffinity
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.system.exitProcess


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentHome : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        activity!!.setTitle(R.string.fragment_title_home)
        btnMenu.setOnClickListener {
            (activity as MainActivity).openDrawer()
        }
        btnQuit.setOnClickListener{
            showDialog(view)
        }
        iv_home.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://kotlinlang.org/"))
            startActivity(i)
        }
    }

    fun showDialog(view: View) {
        val builder = android.support.v7.app.AlertDialog.Builder(view.context)

        // Set the alert dialog title
        builder.setTitle(R.string.dialog_title)

        // Display a message on alert dialog
        builder.setMessage(R.string.dialog_message)

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton(R.string.dialog_yes){dialog, which ->
            // Do something when user press the positive button
            Toast.makeText(activity,R.string.dialog_yes_toast,Toast.LENGTH_SHORT).show()

            exitProcess(-1)
        }


        // Display a negative button on alert dialog
        builder.setNegativeButton(R.string.dialog_no){dialog,which ->
            Toast.makeText(activity,R.string.dialog_no_toast,Toast.LENGTH_SHORT).show()
        }


        // Display a neutral button on alert dialog
        builder.setNeutralButton(R.string.dialog_cancel){_,_ ->
            Toast.makeText(activity,R.string.dialog_no_toast,Toast.LENGTH_SHORT).show()
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }


}
