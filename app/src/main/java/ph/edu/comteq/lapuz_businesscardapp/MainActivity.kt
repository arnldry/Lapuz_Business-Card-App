package ph.edu.comteq.lapuz_businesscardapp

import android.graphics.drawable.AnimatedImageDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import ph.edu.comteq.lapuz_businesscardapp.ui.theme.Lapuz_BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lapuz_BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BussinesCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun BussinesCard(modifier: Modifier = Modifier) {
    var showGif by remember { mutableStateOf(true) }

    Box(){
        // It display a background image that covers the entire screen
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        // This column is used to arrange everything inside it.
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(40.dp)
        ) {
            if (showGif) {
                // It display a profile picture
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(250.dp).clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                // It iss also an image but it supports animated drawable unlike the Image Compose it only support static image
                AndroidView(
                    factory = { context ->
                        ImageView(context).apply {
                            setImageResource(R.drawable.twerking_morty)
                            contentDescription = "Twerking Morty"
                            val drawable = drawable
                            if (drawable is AnimatedImageDrawable) {
                                drawable.start()
                            }
                        }
                    },
                    modifier = Modifier.size(250.dp).clip(CircleShape),

                    )
            }
            // It is a spacer that doesn't show anything but create a space between the compose
            Spacer(modifier = Modifier.height(20.dp))

            // Surface is to add a style or structure on the content
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                shape = RoundedCornerShape(10),
                color = Color.White.copy(alpha = 0.100f),
                tonalElevation = 6.dp,
                border = BorderStroke(1.dp, Color.White.copy(alpha = 0.2f))
            ) {
                // This compose is used to display a text on the screen
                Text(
                    text = "Arnold Rey Strader Lapuz",
                    fontSize = 23.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .wrapContentWidth(Alignment.CenterHorizontally),
                    style = androidx.compose.ui.text.TextStyle(
                        shadow = Shadow(
                            color = Color(0xFF00BFFF),
                            offset = Offset(2f, 2f),
                            blurRadius = 6f
                        )
                    )
                )
            }
            // This compose is used to display a text on the screen
            Text(
                text = "Android Developer Student",
                fontSize = 16.sp,
                color = Color(0xFF00BFFF)
            )
            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Text(
                    text = "Phone number:",
                    fontSize = 16.sp,
                    color = Color.White
                )
                // This compose is used to display a text on the screen
                Text(
                    text = "+63-966-456-7529",
                    fontSize = 16.sp,
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                )
            }
            // This compose arranges everything inside it horizontally.
            Row {
                // This compose is used to display a text on the screen
                Text(
                    text = "Email:",
                    fontSize = 16.sp,
                    color = Color.White
                )
                // This compose is used to display a text on the screen
                Text(
                    text = "arnldrylapuz@gmail.com",
                    fontSize = 16.sp,
                    color = Color.White,
                    textDecoration = TextDecoration.Underline
                )
            }
            Spacer(modifier = Modifier.height(25.dp))

            // This compose creates a clickable button
            Button(
                onClick = { showGif = !showGif },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .height(50.dp)
                    .width(150.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00BFFF) // sky blue button
                )
            )
            {
                // This compose is used to display a text on the screen
                Text(
                    text = "Click me!",
                    fontSize = 15.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BussinessCardPreview() {
    Lapuz_BusinessCardAppTheme {
        BussinesCard()
    }
}