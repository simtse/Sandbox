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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      HomeScaffold()
    }
  }
}

@Composable
fun HomeScaffold() {
  MaterialTheme {
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text(text = "Simon's Sandbox") },
          actions = {
            IconButton(onClick = { /* doSomething() */ }) {
              Icon(Icons.Filled.Favorite, contentDescription = null)
            }
          }
        )
      },
    ) { innerPadding ->
      HomeMenu(Modifier
        .padding(innerPadding)
        .padding(8.dp))
    }
  }
}

@Composable
fun HomeMenu(modifier: Modifier = Modifier) {
  val context = LocalContext.current
  Column {
    Column(modifier) {
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

@Preview(showBackground = true)
@Composable
fun MainMenuPreview() {
  HomeScaffold()
}