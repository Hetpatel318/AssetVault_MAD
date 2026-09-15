package com.example.mad_assignment
    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import androidx.appcompat.app.AppCompatActivity

    class LoginActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_entry)

            val btnLogin = findViewById<Button>(R.id.btnGetStarted)
            btnLogin.setOnClickListener {
                val intent = Intent(this, MyAssetsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }