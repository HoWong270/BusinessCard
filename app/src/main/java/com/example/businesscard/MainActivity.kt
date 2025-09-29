package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myName = "Owen Wong"
            val myCollege = "College of Staten Island"
            val myMajor = "Computer Science"
            val myContact = "Ho.Wong@cix.csi.cuny.edu | 828-221-2351"

            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF1E3A8A)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        BusinessCardScreen(
                            name = myName,
                            college = myCollege,
                            major = myMajor,
                            contactInfo = myContact
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DolphinLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.csidolphin),
        contentDescription = "CSI Dolphin Logo",
        modifier = modifier
            .size(100.dp)
            .padding(bottom = 24.dp)
    )
}

@Composable
fun BusinessCardScreen(
    name: String,
    college: String,
    major: String,
    contactInfo: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(vertical = 120.dp, horizontal = 40.dp)
            .background(Color.White)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 40.dp)
                .background(Color(0xFFE0F7FA))
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DolphinLogo()

            GreetingText(message = name)
            CollegeText(college = college)
            MajorText(major = major)

            ContactText(contact = contactInfo)
        }
    }
}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier) {
    Text(
        text = message,
        modifier = modifier.padding(bottom = 8.dp),
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        color = Color(0xFF1D4ED8),
    )
}

@Composable
fun CollegeText(college: String, modifier: Modifier = Modifier) {
    Text(
        text = college,
        modifier = modifier.padding(bottom = 4.dp),
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = Color.Black.copy(alpha = 0.9f),
    )
}

@Composable
fun MajorText(major: String, modifier: Modifier = Modifier) {
    Text(
        text = major,
        modifier = modifier.padding(bottom = 16.dp),
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        color = Color.Black.copy(alpha = 0.7f),
    )
}

@Composable
fun ContactText(contact: String, modifier: Modifier = Modifier) {
    Text(
        text = contact,
        modifier = modifier.padding(top = 8.dp, bottom = 16.dp),
        fontSize = 12.sp,
        color = Color.Black.copy(alpha = 0.7f)
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF1E3A8A)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()) {
                BusinessCardScreen(
                    name = "Owen Wong",
                    college = "College of Staten Island",
                    major = "Computer Science",
                    contactInfo = "Ho.Wong@cix.csi.cuny.edu"
                )
            }
        }
    }
}


