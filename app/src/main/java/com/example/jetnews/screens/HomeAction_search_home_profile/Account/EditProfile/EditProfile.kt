package com.example.jetnews.screens.HomeAction_search_home_profile.Account.EditProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetnews.Navigation.JetScreens
import com.example.jetnews.screens.MainViewModel
import com.example.jetnews.screens.SignUp_SingIn.SignIn.TextRow

//Apearence
//logout

@Preview(showSystemUi = true)
@Composable
fun EditProfile(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val conf = LocalConfiguration.current
    val screenH = conf.screenHeightDp.dp

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(backgroundColor = Color.White.copy(alpha = 0.7f)) {

            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(5.dp)
                    .clickable { navController.navigate(JetScreens.AccountScreen.name) })


            Text(text = "Edit Profile",
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(5.dp))

        }

        Box(modifier = Modifier
            .size(screenH / 3 - 20.dp)
            .padding(15.dp)
            .background(color = Color.Transparent)
        ) {
            Box(modifier = Modifier
                .size(screenH / 3 - 20.dp)
                .shadow(elevation = 1.dp, shape = CircleShape)
            ) {
                Icon(imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize())
            }

            FloatingActionButton(onClick = { /*TODO*/ }, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 15.dp, bottom = 15.dp)) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.heightIn(10.dp))
        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp), color = Color.Gray)
        Spacer(modifier = Modifier.height(10.dp))

        TextRow(text1 = "UserName",
            text2 = "*",
            t1c = Color.Gray,
            t2c = Color.Red,
            modifier = Modifier.align(Alignment.Start))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp), shape = CircleShape,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(0xFFFF683A), focusedBorderColor = Color(0xFFFF683A))
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextRow(text1 = "Email",
            text2 = "*",
            t1c = Color.Gray,
            t2c = Color.Red,
            modifier = Modifier.align(Alignment.Start))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp), shape = CircleShape,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(0xFFFF683A), focusedBorderColor = Color(0xFFFF683A))
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextRow(text1 = "About Me",
            text2 = "*",
            t1c = Color.Gray,
            t2c = Color.Red,
            modifier = Modifier.align(Alignment.Start))
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp), shape = CircleShape,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color(0xFFFF683A), focusedBorderColor = Color(0xFFFF683A))
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = { /*TODO*/ },
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color(
                0xFFFF683A))) {
            Text(text = "Save Changes")
        }
    }
}