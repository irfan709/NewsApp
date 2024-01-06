package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.newsapp.MainActivity
import com.example.newsapp.database.ArticleDatabase
import com.example.newsapp.databinding.FragmentArticleBinding
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.viewmodel.NewsViewModel
import com.example.newsapp.viewmodel.NewsViewModelFactory

class ArticleFragment : Fragment() {

    private lateinit var binding: FragmentArticleBinding
    private val args: ArticleFragmentArgs by navArgs()
    private val newsViewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val article = args.article

//        val newsRepository = NewsRepository(ArticleDatabase(requireContext()))
//        val viewModelFactory = NewsViewModelFactory(requireActivity().application, newsRepository)
//        newsViewModel = ViewModelProvider(requireActivity(), viewModelFactory)[NewsViewModel::class.java]

        if (article != null) {
            binding.webView.apply {
                webViewClient = WebViewClient()
                loadUrl(article.url)
            }

            binding.fab.setOnClickListener {
                newsViewModel.addToFavourites(article)
            }
        }
        else {

        }
    }
}