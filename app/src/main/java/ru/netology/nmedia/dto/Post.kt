package ru.netology.nmedia.dto

data class Post (

    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    var likedByMe: Boolean = false,
    var shareByMe: Boolean = false,
    var likes: Int = 0,
    var share: Int = 0,
    var avatarByMe: Boolean = false,
)