package com.example.myreceipe.domain.util

sealed class IngredientOrder(val orderType: OrderType) {
    class Name(orderType: OrderType): IngredientOrder(orderType)
}
