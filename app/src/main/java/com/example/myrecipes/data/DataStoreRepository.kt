package com.example.myrecipes.data

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import com.example.myrecipes.util.Constants.Companion.DEFAULT_DIET_TYPE
import com.example.myrecipes.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.example.myrecipes.util.Constants.Companion.PREFERENCES_BACK_ONLINE
import com.example.myrecipes.util.Constants.Companion.PREFERENCES_DIET_TYPE
import com.example.myrecipes.util.Constants.Companion.PREFERENCES_DIET_TYPE_ID
import com.example.myrecipes.util.Constants.Companion.PREFERENCES_MEAL_TYPE
import com.example.myrecipes.util.Constants.Companion.PREFERENCES_MEAL_TYPE_ID
import com.example.myrecipes.util.Constants.Companion.PREFERENCES_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
// data store running in background thread and not main thread (sp difrreneces)
// for bottom sheet choices
// reason why using this is becuz this reporsity gonna be used inside the recipes module
@ActivityRetainedScoped
class DataStoreRepository @Inject constructor(@ApplicationContext private val context: Context) {


    private object PreferenceKeys {
        // meal type is the key
        //define how to store value
        val selectedMealType = preferencesKey<String>(PREFERENCES_MEAL_TYPE)
        val selectedMealTypeId = preferencesKey<Int>(PREFERENCES_MEAL_TYPE_ID)
//        val selectedDietType = preferencesKey<String>(PREFERENCES_DIET_TYPE)
//        val selectedDietTypeId = preferencesKey<Int>(PREFERENCES_DIET_TYPE_ID)
        val backOnline = preferencesKey<Boolean>(PREFERENCES_BACK_ONLINE)
    }

    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = PREFERENCES_NAME
    )

    // take values and store inside datastore prefernces
    // saving meal types
    suspend fun saveMealAndDietType(
        mealType: String,
        mealTypeId: Int
//        ,
//        dietType: String,
//        dietTypeId: Int
    ) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.selectedMealType] = mealType
            preferences[PreferenceKeys.selectedMealTypeId] = mealTypeId
//            preferences[PreferenceKeys.selectedDietType] = dietType
//            preferences[PreferenceKeys.selectedDietTypeId] = dietTypeId
        }
    }

    suspend fun saveBackOnline(backOnline: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKeys.backOnline] = backOnline
        }
    }

    // var for reading data that we storing
    // flow corutins - when reading values from bottom sheets we use flow to pass the selected values
    // catch exception then emit empty prefernces
    // if no dta returned then we use default values
    val readMealAndDietType: Flow<MealAndDietType> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            val selectedMealType = preferences[PreferenceKeys.selectedMealType] ?: DEFAULT_MEAL_TYPE
            val selectedMealTypeId = preferences[PreferenceKeys.selectedMealTypeId] ?: 0
//            val selectedDietType = preferences[PreferenceKeys.selectedDietType] ?: DEFAULT_DIET_TYPE
//            val selectedDietTypeId = preferences[PreferenceKeys.selectedDietTypeId] ?: 0
            MealAndDietType(
                selectedMealType,
                selectedMealTypeId )
//                ,
//                selectedDietType,
//                selectedDietTypeId

        }

    val readBackOnline: Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map {preferences ->
            val backOnline = preferences[PreferenceKeys.backOnline] ?: false
            backOnline
        }

}

data class MealAndDietType(
    val selectedMealType: String,
    val selectedMealTypeId: Int
)
//,
//val selectedDietType: String,
//val selectedDietTypeId: Int