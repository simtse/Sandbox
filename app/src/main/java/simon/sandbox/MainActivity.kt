package simon.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NewsStory()
    }
  }
}

@Composable
fun NewsStory() {
  MaterialTheme {
    val typography = MaterialTheme.typography
    Column(
      modifier = Modifier.padding(16.dp)
    ) {
      Image(
        painter = painterResource(id = R.mipmap.header),
        contentDescription = "Header",
        modifier = Modifier
          .height(180.dp)
          .fillMaxWidth()
          .clip(RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop
      )
      Spacer(Modifier.height(16.dp))
      Text(
        "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
        style = typography.h6,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
      )
      Text(
        "Davenport, California",
        style = typography.body2
      )
      Text(
        "December 2018",
        style = typography.body2
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  NewsStory()
}