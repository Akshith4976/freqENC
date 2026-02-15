package com.example.freqenc

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.sendButton)

        button.setOnClickListener {
            playEncodedAudio(input.text.toString())
        }
    }

    private fun playEncodedAudio(text: String) {
        val sampleRate = 44100
        val bitDuration = 0.05   // 50 ms
        val data = ArrayList<Short>()

        for (c in text) {
            val bits = c.code.toString(2).padStart(8, '0')
            for (b in bits) {
                val freq = if (b == '0') 1200 else 2400
                val samples = (sampleRate * bitDuration).toInt()
                for (i in 0 until samples) {
                    val v = sin(2.0 * Math.PI * freq * i / sampleRate)
                    data.add((v * Short.MAX_VALUE).toInt().toShort())
                }
            }
        }

        val audio = AudioTrack(
            AudioManager.STREAM_MUSIC,
            sampleRate,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            data.size * 2,
            AudioTrack.MODE_STATIC
        )

        val buffer = data.toShortArray()
        audio.write(buffer, 0, buffer.size)
        audio.play()
    }
}
