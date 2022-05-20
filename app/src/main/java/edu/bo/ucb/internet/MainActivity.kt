package edu.bo.ucb.internet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button3.setOnClickListener {
            if(isConexion(applicationContext)) {
                Toast.makeText(this, "Tiene acceso a internet", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No tiene acceso a internet", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun isConexion( context: Context) : Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

}
