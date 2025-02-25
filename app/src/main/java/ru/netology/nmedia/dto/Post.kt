package ru.netology.nmedia.dto

data class Post (

    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    val likedByMe: Boolean = false,
    val shareByMe: Boolean = false,
    val likes: Int,
    val share: Int,
    val avatarByMe: Boolean = false,
)