package tiiva.nduati.firebasemlkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var readBtn : Button
    lateinit var imageLnk : EditText
    lateinit var mlImgVw : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readBtn = findViewById(R.id.readImageButton)
        imageLnk = findViewById(R.id.imagelinkEditText)
        mlImgVw = findViewById(R.id.mlImageView)

        readBtn.setOnClickListener {
            if(imageLnk.text.toString().isNotEmpty()){
                Glide.with(this).load(imageLnk.text.toString()).into(mlImgVw)
                readImageText()
            }
        }
    }

    private fun readImageText() {
        TODO("Not yet implemented")
    }
}