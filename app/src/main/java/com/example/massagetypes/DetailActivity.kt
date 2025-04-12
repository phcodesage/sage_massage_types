package com.example.massagetypes

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.example.massagetypes.databinding.ActivityDetailBinding
import com.example.massagetypes.model.Massage

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Massage Details"

        // Get massage data from intent - using the non-deprecated method
        val massage = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("MASSAGE_EXTRA", Massage::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Massage>("MASSAGE_EXTRA")
        }
        massage?.let { displayMassageDetails(it) }
    }

    private fun displayMassageDetails(massage: Massage) {
        // Set basic info
        binding.detailImage.setImageResource(massage.imageResource)
        binding.detailName.text = massage.name
        binding.detailDescription.text = massage.description
        
        // Set origin
        binding.originText.text = massage.origin
        
        // Set history
        binding.historyText.text = massage.history
        
        // Set benefits
        val benefitsText = massage.benefits.joinToString("\n") { "• $it" }
        binding.benefitsText.text = benefitsText
        
        // Set techniques
        val techniquesText = massage.techniques.joinToString("\n") { "• $it" }
        binding.techniquesText.text = techniquesText
        
        // Set additional info
        binding.durationText.text = massage.recommendedDuration
        binding.pressureText.text = massage.pressure
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                finish()
            } else {
                @Suppress("DEPRECATION")
                onBackPressed()
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}