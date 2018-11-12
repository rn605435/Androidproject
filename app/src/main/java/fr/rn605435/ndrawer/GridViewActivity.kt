package fr.rn605435.ndrawer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_anko.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.jetbrains.anko.warn
import android.widget.GridView
import kotlinx.android.synthetic.main.activity_gridview.*


class GridViewActivity: AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_RED)
        setContentView(R.layout.activity_gridview)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.setDisplayShowHomeEnabled(true)
        // Get an instance of base adapter
        val adapter = ColorBaseAdapter()

        // Set the grid view adapter
        grid_view.adapter = adapter

        // Configure the grid view
        grid_view.numColumns = 2
        grid_view.horizontalSpacing = 15
        grid_view.verticalSpacing = 15
        grid_view.stretchMode = GridView.STRETCH_COLUMN_WIDTH
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}