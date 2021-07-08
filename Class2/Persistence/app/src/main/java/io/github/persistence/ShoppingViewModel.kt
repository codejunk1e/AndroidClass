package io.github.persistence

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ShoppingViewModel: ViewModel() {

    fun addShoppingItem(
        shoppingItem: ShoppingModel,
        database: ShoppingDatabase){
        database.shoppingDao().addShoppingItem(shoppingItem)
    }

    fun getAllShoppingItems(database: ShoppingDatabase)
    :LiveData<List<ShoppingModel>> {
        return database.shoppingDao().getAllShoppingItems()
    }
}