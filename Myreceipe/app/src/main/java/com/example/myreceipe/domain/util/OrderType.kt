package com.example.myreceipe.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
