package git.myapplication.sqlitelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import git.myapplication.sqlitelogin.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            val unametext = binding.editTextTextPersonName.text.toString()
            val pwordtext = binding.editTextTextPassword.text.toString()
            val cpwordtext = binding.editTextTextPassword2.text.toString()
            val savedata = DBHelper(this).insertdata(unametext, pwordtext)

            if (TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(
                    cpwordtext
                )
            ) {
                Toast.makeText(
                    this,
                    "Add Username, Password & Conform Password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (pwordtext.equals(cpwordtext)) {
                    if (savedata == true) {
                        Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, Login::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,"User Exists", Toast.LENGTH_SHORT).show()
                    }
                }else
                {
                    Toast.makeText(this,"Password Not Match", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}