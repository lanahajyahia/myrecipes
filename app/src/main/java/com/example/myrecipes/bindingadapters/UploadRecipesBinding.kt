package com.example.myrecipes.bindingadapters

class UploadRecipesBinding {

//    companion object {
//
//        @BindingAdapter("readApiResponse3", "readDatabase3", requireAll = false)
//        @JvmStatic
//        fun setCardAndProgressVisibility(
//            view: View,
//            apiResponse: NetworkResult<FoodJoke>?,
//            database: List<UploadRecipesEntity>?
//        ) {
//            when (apiResponse) {
//                is NetworkResult.Loading -> {
//                    when (view) {
//                        is ProgressBar -> {
//                            view.visibility = View.VISIBLE
//                        }
//                        is MaterialCardView -> {
//                            view.visibility = View.INVISIBLE
//                        }
//                    }
//                }
//                is NetworkResult.Error -> {
//                    when (view) {
//                        is ProgressBar -> {
//                            view.visibility = View.INVISIBLE
//                        }
//                        is MaterialCardView -> {
//                            view.visibility = View.VISIBLE
//                            if (database != null) {
//                                if (database.isEmpty()) {
//                                    view.visibility = View.INVISIBLE
//                                }
//                            }
//                        }
//                    }
//                }
//                is NetworkResult.Success -> {
//                    when(view){
//                        is ProgressBar -> {
//                            view.visibility = View.INVISIBLE
//                        }
//                        is MaterialCardView -> {
//                            view.visibility = View.VISIBLE
//                        }
//                    }
//                }
//            }
//        }
//
//        @BindingAdapter("readApiResponse4", "readDatabase4", requireAll = true)
//        @JvmStatic
//        fun setErrorViewsVisibility(
//            view: View,
//            apiResponse: NetworkResult<FoodJoke>?,
//            database: List<UploadRecipesEntity>?
//        ){
//            if(database != null){
//                if(database.isEmpty()){
//                    view.visibility = View.VISIBLE
//                    if(view is TextView){
//                        if(apiResponse != null){
//                            view.text = apiResponse.message.toString()
//                        }
//                    }
//                }
//            }
//            if(apiResponse is NetworkResult.Success){
//                view.visibility = View.INVISIBLE
//            }
//        }
//
//    }

}