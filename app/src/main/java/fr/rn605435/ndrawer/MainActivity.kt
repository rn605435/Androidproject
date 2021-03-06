package fr.rn605435.ndrawer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import fr.rn605435.ndrawer.tool.replace
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.system.exitProcess
import android.content.DialogInterface



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val i : Int =20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            // array string needed to fix population error
            intent.putExtra(Intent.EXTRA_EMAIL, Array<String>(1) { "nicolas.rochette@etu.unice.fr" })
            intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        replace(FragmentHome())
        nav_view.setNavigationItemSelectedListener(this)
    }

    fun openDrawer() {
        drawer_layout.openDrawer(GravityCompat.START)
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        else {
            AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(getString(R.string.backpressed_title))
                    .setMessage(getString(R.string.backpressed_sentence))
                    .setPositiveButton(getString(R.string.backpressed_positive)) { dialog, which -> finish() }
                    .setNegativeButton(getString(R.string.backpressed_negative), null)
                    .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when(item.itemId){
            R.id.action_quote -> {
                val intent = Intent(this, QuoteActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replace(FragmentHome())
            }
            R.id.nav_cardview-> {
                replace(FragmentCardview())
            }
            R.id.nav_mc -> {
                replace(FragmentMagicCircle())
            }
            R.id.nav_numberpicker -> {
                replace(FragmentNumberPicker())
            }
            R.id.nav_anko -> {
                val intent = Intent(this, AnkoActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_gridview -> {
                val intent = Intent(this, GridViewActivity::class.java)
                startActivity(intent)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
