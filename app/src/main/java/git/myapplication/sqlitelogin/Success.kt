package git.myapplication.sqlitelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import git.myapplication.sqlitelogin.databinding.ActivityLoginBinding
import git.myapplication.sqlitelogin.databinding.ActivitySuccessBinding

class Success : AppCompatActivity() {

    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}