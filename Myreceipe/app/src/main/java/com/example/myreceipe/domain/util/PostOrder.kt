package com.example.myreceipe.domain.util

sealed class PostOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): PostOrder(orderType)
}
