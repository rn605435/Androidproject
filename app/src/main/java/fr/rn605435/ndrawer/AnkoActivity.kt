package fr.rn605435.ndrawer

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import fr.rn605435.ndrawer.tool.replace
import kotlinx.android.synthetic.main.activity_anko.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.jetbrains.anko.warn

class AnkoActivity: AppCompatActivity(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko)
        btnAnko.setOnClickListener{
            toast(R.string.btn_anko_answer)
        }
        info { "String logged with Anko !"}
        warn { null } //Print null
    }
}