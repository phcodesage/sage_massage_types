package com.example.massagetypes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.massagetypes.adapter.MassageAdapter
import com.example.massagetypes.databinding.ActivityMainBinding
import com.example.massagetypes.model.Massage

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create comprehensive massage data
        val massages = listOf(
            Massage(
                name = "Swedish Massage",
                description = "A gentle full-body massage that uses long strokes, kneading, deep circular movements, vibration and tapping. It helps to improve circulation, ease muscle tension, and create a sense of relaxation and well-being.",
                imageResource = R.drawable.ic_launcher_foreground, // Temporary placeholder
                origin = "Sweden",
                benefits = listOf(
                    "Reduces stress and anxiety",
                    "Improves blood circulation",
                    "Relieves muscle tension",
                    "Promotes relaxation",
                    "Increases flexibility and range of motion"
                ),
                techniques = listOf(
                    "Effleurage (long, gliding strokes)",
                    "Petrissage (kneading movements)",
                    "Friction (circular pressures)",
                    "Tapotement (rhythmic tapping)",
                    "Vibration (rapid shaking movements)"
                ),
                recommendedDuration = "60-90 minutes",
                pressure = "Light to Medium",
                history = "Swedish massage was developed in the early 19th century by Per Henrik Ling, a Swedish physiologist. Ling combined his knowledge of gymnastics and physiology to create a system of massage that became known worldwide as 'Swedish massage'. It was introduced to the United States in the 1850s and has since become one of the most commonly practiced massage techniques."
            ),
            Massage(
                name = "Deep Tissue Massage",
                description = "A therapeutic massage technique that focuses on realigning deeper layers of muscles and connective tissue. It's particularly helpful for chronic aches and pains and contracted areas such as stiff neck, low back tightness, and sore shoulders.",
                imageResource = R.drawable.ic_launcher_foreground, // Temporary placeholder
                origin = "Various cultures, modern development",
                benefits = listOf(
                    "Relieves chronic pain",
                    "Reduces inflammation",
                    "Breaks down scar tissue",
                    "Improves posture",
                    "Increases range of motion"
                ),
                techniques = listOf(
                    "Stripping (deep, gliding pressure along muscle fibers)",
                    "Friction (pressure applied across muscle fibers)",
                    "Trigger point therapy (focused pressure on tight muscle knots)"
                ),
                recommendedDuration = "60-90 minutes",
                pressure = "Medium to Firm",
                history = "Deep tissue massage evolved from Swedish massage techniques but focuses on the deeper layers of muscle and fascia. It gained popularity in the mid-20th century as therapists recognized the need for more targeted treatment of chronic muscular pain and tension."
            ),
            Massage(
                name = "Hot Stone Massage",
                description = "A specialty massage where smooth, heated stones are placed on specific points on the body and sometimes used by the therapist to massage. The heat from the stones helps to relax muscles more deeply and improve circulation.",
                imageResource = R.drawable.ic_launcher_foreground, // Temporary placeholder
                origin = "Native American cultures",
                benefits = listOf(
                    "Promotes deep relaxation",
                    "Eases muscle tension",
                    "Improves circulation",
                    "Relieves pain",
                    "Reduces stress and anxiety"
                ),
                techniques = listOf(
                    "Placement of heated stones on key points",
                    "Gliding strokes with stones",
                    "Alternating hot and cool stones",
                    "Combination with Swedish massage techniques"
                ),
                recommendedDuration = "75-90 minutes",
                pressure = "Light to Medium",
                history = "The use of stones for healing dates back thousands of years in Native American practices. Modern hot stone massage was developed in the 1990s by Mary Nelson, who created LaStone Therapy, which combines heated and chilled stones with traditional massage techniques."
            ),
            Massage(
                name = "Thai Massage",
                description = "An ancient healing system combining acupressure, Indian Ayurvedic principles, and assisted yoga postures. The therapist uses their hands, knees, legs, and feet to move you into a series of yoga-like stretches while applying muscle compression, joint mobilization, and acupressure.",
                imageResource = R.drawable.ic_launcher_foreground, // Temporary placeholder
                origin = "Thailand",
                benefits = listOf(
                    "Increases energy levels",
                    "Improves flexibility",
                    "Enhances range of motion",
                    "Reduces muscle tension and spasm",
                    "Balances the body's energy systems"
                ),
                techniques = listOf(
                    "Sen (energy line) work",
                    "Passive stretching",
                    "Joint mobilization",
                    "Rhythmic compression",
                    "Acupressure"
                ),
                recommendedDuration = "90-120 minutes",
                pressure = "Medium to Firm",
                history = "Thai massage originated in India and evolved for over 2,500 years. It was developed by Jivaka Kumar Bhaccha, the physician to Buddha. The practice made its way to Thailand, where it was influenced by traditional Chinese medicine and became an integral part of Thai medicine."
            ),
            Massage(
                name = "Shiatsu Massage",
                description = "A Japanese form of bodywork that uses localized finger pressure in a rhythmic sequence on acupuncture meridians. Each point is held for 2 to 8 seconds to improve the flow of energy and help the body regain balance.",
                imageResource = R.drawable.ic_launcher_foreground, // Temporary placeholder
                origin = "Japan",
                benefits = listOf(
                    "Reduces stress, anxiety, and depression",
                    "Relieves headaches",
                    "Reduces muscle tension",
                    "Improves sleep quality",
                    "Increases energy levels"
                ),
                techniques = listOf(
                    "Pressure point therapy",
                    "Meridian stretching",
                    "Joint manipulation",
                    "Palm and thumb pressure",
                    "Rotation and stretching movements"
                ),
                recommendedDuration = "60-90 minutes",
                pressure = "Medium",
                history = "Shiatsu developed in Japan from traditional Chinese medicine, with influences from more recent Western therapies. In the early 1900s, Tokujiro Namikoshi systematized the therapy and founded the first Shiatsu college. Shizuto Masunaga later developed Zen Shiatsu, which integrated traditional Eastern medicine with Western psychology."
            )
        )

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = MassageAdapter(massages) { selectedMassage ->
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("MASSAGE_EXTRA", selectedMassage)
                }
                startActivity(intent)
            }
        }
    }
}