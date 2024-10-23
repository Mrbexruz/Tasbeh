package com.likobehruz.mashq

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.likobehruz.mashq.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
 var i =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences= getSharedPreferences("my_tasbeh", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        var count = sharedPreferences.getInt("keyCount", 0)
        binding.txt1.text = count.toString()



        var i = sharedPreferences.getInt("keyCount", 0 )
        binding.txt1.text=i.toString()


                binding.btn1.setOnClickListener (){
                    var i = sharedPreferences.getInt("keyCount", 0 )
                    i++
                    editor.putInt("keyCount", i)
                        .commit()
                        val mediaPlayer=MediaPlayer.create(this, R.raw.butla)
                        mediaPlayer.start()

                    binding.txt1.text = i.toString()

                }
        binding.btn2.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Сбросить счётчик?")
            dialog.setMessage("Вы уверены, что хотите сбросить счётчик?")
            dialog.setPositiveButton("Да") { _, _ ->
                count = 0
                editor.putInt("keyCount", count).apply()
                binding.txt1.text = count.toString()
            }
            dialog.setNegativeButton("Нет") { dialogInterface, _ ->
                dialogInterface.dismiss() // Close the dialog without doing anything
            }
            dialog.show()
        }
            }
        }

