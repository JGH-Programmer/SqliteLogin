package git.myapplication.sqlitelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import git.myapplication.sqlitelogin.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button4.setOnClickListener {
            val userdtx = binding.editTextTextPersonName2.text.toString()
            val passedtx = binding.editTextTextPassword3.text.toString()

            if (TextUtils.isEmpty(userdtx) || TextUtils.isEmpty(passedtx)){
                Toast.makeText(this,"Add Username & Password", Toast.LENGTH_SHORT).show()
            }else
            {
                val checkuser = DBHelper(this).checkuserpass(userdtx, passedtx)
                if (checkuser == true){
                    Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Success::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"Wrong Username & Password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}