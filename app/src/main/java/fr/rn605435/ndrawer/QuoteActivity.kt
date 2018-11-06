package fr.rn605435.ndrawer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import kotlinx.android.synthetic.main.activity_anko.*
import kotlinx.android.synthetic.main.activity_quote.*
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import java.net.URL

class QuoteActivity: AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_PINK)
        setContentView(R.layout.activity_quote)
        doAsync {
            val result = URL("https://talaikis.com/api/quotes/random/").readText()
            val parser: Parser = Parser()
            val stringBuilder: StringBuilder = StringBuilder(result)
            val json: JsonObject = parser.parse(stringBuilder) as JsonObject
            val quote = "Quote : ${json.string("quote")}"
            val author = "Author : ${json.string("author")}"
            uiThread {
                tvQuote.text = quote
                tvAuthor.text = author
            }
        }
    }
}