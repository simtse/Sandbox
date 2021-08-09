package simon.sandbox

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HomeMenu()
    }
  }
}

@Composable
fun HomeMenu() {
  val context = LocalContext.current
  MaterialTheme {
    Column {
      TopAppBar {
        Text(text = "Simon's Sandbox")
      }
      Column(Modifier.padding(start = 16.dp, end = 16.dp)) {
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
          context.startActivity(Intent(context, NewsStoryGoogleIo::class.java))
        }) {
          Text(text = "News Story Google IO")
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
          context.startActivity(
            Intent(
              context,
              CodeLabComposeBasics::class.java
            )
          )
        }) {
          Text(text = "Codelabs Compose basic")
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
          context.startActivity(
            Intent(
              context,
              CodeLabComposeLayouts::class.java
            )
          )
        }) {
          Text(text = "Codelabs Layouts")
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
  HomeMenu()
}