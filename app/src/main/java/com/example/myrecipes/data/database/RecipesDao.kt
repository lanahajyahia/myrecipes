package com.example.myrecipes.data.database

import androidx.room.*
import com.example.myrecipes.data.database.entities.FavoritesEntity
import com.example.myrecipes.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow
// an interface that include sql queries we use in the database

@Dao
interface RecipesDao {
    // kotlin corrutense
    // whenever we fetch data from api we want to replace the current. new rcipes everytime req data from api
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteRecipe(favoritesEntity: FavoritesEntity)


    // flow - light data.
    @Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>

    @Query("SELECT * FROM favorite_recipes_table ORDER BY id ASC")
    fun readFavoriteRecipes(): Flow<List<FavoritesEntity>>

//    @Query("SELECT * FROM food_joke_table ORDER BY id ASC")
//    fun readFoodJoke(): Flow<List<UploadRecipesEntity>>

    @Delete
    suspend fun deleteFavoriteRecipe(favoritesEntity: FavoritesEntity)

    @Query("DELETE FROM favorite_recipes_table")
    suspend fun deleteAllFavoriteRecipes()

}