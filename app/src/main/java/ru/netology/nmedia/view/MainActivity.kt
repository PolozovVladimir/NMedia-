package ru.netology.nmedia.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        applyInset(binding.main)
        val viewModel: PostViewModel by viewModels ()
       viewModel.data.observe(this){ post ->
           with(binding) {
               shareQuantity.text = CountCalculator.calculator(post.share)

               share.setOnClickListener {
                   viewModel.share()
                   shareQuantity.text = CountCalculator.calculator(post.share)
               }

           }
           with(binding) {
               likeQuantity.text = CountCalculator.calculator(post.likes)
               like.setImageResource(
                   if (post.likedByMe) {
                       R.drawable.baseline_favorite_24
                   } else {
                       R.drawable.baseline_favorite_border_24
                   }

               )




               like.setOnClickListener {
                   viewModel.like()




               }

               content.text = post.content
               author.text = post.author
               published.text = post.published

           }
       }

    }

    private fun applyInset(main: View) {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}