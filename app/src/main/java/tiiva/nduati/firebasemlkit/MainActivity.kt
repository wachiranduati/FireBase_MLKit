package tiiva.nduati.firebasemlkit

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition


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
//                Glide.with(this).load(R.drawable.france).into(mlImgVw)
                Glide.with(this).load(imageLnk.text.toString()).into(mlImgVw)
                readImageText()
            }
        }
    }

    private fun readImageText() {
        Log.d(Companion.TAG, "readImageText: method has been called")
        val bitmp = BitmapFactory.decodeResource(resources, R.drawable.france)
        val image = InputImage.fromBitmap(bitmp, 0)
        val recognizer = TextRecognition.getClient()

        val result = recognizer.process(image)
            .addOnSuccessListener { visionText ->
                Toast.makeText(this, "${visionText.text}", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Log.d(TAG, "readImageText: text recognition failed")
            }

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}