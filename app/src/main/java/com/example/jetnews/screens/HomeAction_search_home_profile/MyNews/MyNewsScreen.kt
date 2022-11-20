package com.example.jetnews.screens.HomeAction_search_home_profile.MyNews

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetnews.Data.DataOrException
import com.example.jetnews.Model.UserInfoData
import com.example.jetnews.screens.HomeAction_search_home_profile.Home.NewsBox
import com.example.jetnews.screens.MainViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

@Composable
fun MyNewsScreen(navController:NavHostController,mainViewModel: MainViewModel){
    val text = remember {mutableStateOf("")}


    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Row(modifier = Modifier.fillMaxWidth().padding(9.dp), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(value = text.value,
                onValueChange = { text.value = it },
                modifier = Modifier.fillMaxWidth().shadow(elevation = 2.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = Color.LightGray.copy(
                    alpha = 0.5f),
                    unfocusedBorderColor = Color.DarkGray,
                    backgroundColor = Color.White.copy(alpha = 0.5f)),
                shape = CircleShape,
                textStyle = TextStyle(fontSize = 20.sp),
                singleLine = true,
                maxLines = 1,
                placeholder = { Text(text = "Search Saved News") },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        modifier = Modifier.clickable {

                        })
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search,
                    keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions(onSearch = {
                    
                })
            )
        }


        LazyColumn{
            items(mainViewModel.articleFire){art ->

                if (art.title.toString() != "null") {
                    NewsBox(imageURL = art.urlToImage.toString(),
                        title = art.title.toString(),
                        desc = art.description.toString(),
                        content = art.content.toString()) {}
                }
            }
        }
    }
}