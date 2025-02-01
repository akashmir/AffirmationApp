package com.example.affirmationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                 modifier = Modifier
                     .fillMaxSize()
                     .padding(16.dp)
            ) {


                AppPreview()
            }


        }
    }
}


@Preview
@Composable
fun AppPreview(){

    Column{
        Text(
            text = "Daily Affirmations",
            fontWeight = FontWeight.Bold,

            fontSize = 40.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(MaterialTheme.colorScheme.background)
            ,
            style = MaterialTheme.typography.headlineMedium,

        )
        LazyColumn(
            content={
                items(getList()){item->App(item.img,item.des)}
            }

        )
    }
}

@Composable
fun App(img:Int ,des : String){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)


        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = des
                ,modifier = Modifier.padding(16.dp)
                ,style = MaterialTheme.typography.headlineSmall
            )

        }
    }
}
data class Affirmation(
    val img : Int ,
    val des : String
)

fun getList(): MutableList<Affirmation> {
    val list = mutableListOf<Affirmation>()
    list.add(Affirmation(R.drawable.image1,"Believe in yourself and all that you are."))
    list.add(Affirmation(R.drawable.image2,"You are capable of amazing things."))
    list.add(Affirmation(R.drawable.image3,"Positivity is a choice. Choose wisely."))
    list.add(Affirmation(R.drawable.image4,"Embrace the journey, trust the process."))
    list.add(Affirmation(R.drawable.image5,"Your potential is endless"))
    list.add(Affirmation(R.drawable.image6,"You are stronger than you think."))
    list.add(Affirmation(R.drawable.image7,"Do what makes your soul shine."))
    list.add(Affirmation(R.drawable.image8,"Happiness is an inside job."))
    list.add(Affirmation(R.drawable.image9,"You are enough just as you are."))
    list.add(Affirmation(R.drawable.image10,"Be kind to yourself and others."))
    return list
}