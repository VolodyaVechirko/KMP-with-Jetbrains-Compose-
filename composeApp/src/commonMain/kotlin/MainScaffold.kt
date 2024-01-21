import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun MainScaffolding() {
//    Scaffold(
//        topBar = {
//            MainMenuBar()
//        },
//        content = {
//            MainLaunchList()
//        })
}

@Composable
fun MainMenuBar() {
//    val context = LocalContext.current
//
//    TopAppBar(title = {
//        Text(context.getString(R.string.app_name))
//    })
}

//@Composable
//fun MainLaunchList(viewModel: MainViewModel = viewModel()) {
//    val launches by viewModel.launches.observeAsState()
//
//    LazyColumn(
//        contentPadding = PaddingValues(16.dp, 8.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(launches!!) { launch ->
//            MainLaunchCard(launch = launch)
//        }
//    }
//
//    viewModel.getLaunches()
//}

//@Composable
//@Preview(showBackground = true)
//fun MainLaunchCard(@PreviewParameter(SampleLaunchProvider::class) launch: Launch) {
//
//    val context = LocalContext.current
//
//    Card(
//        modifier = Modifier
//            .wrapContentHeight()
//            .fillMaxWidth()
//            .clickable {
////                val intent = Intent(context, LaunchesDetailActivity::class.java)
////                intent.putExtra(LaunchesDetailActivity.LAUNCH_EXTRA, launch)
////                context.startActivity(intent)
//            },
//        elevation = 8.dp
//    ) {
//        Row {
//            if (launch.image != null) {
//                CoilImage(
//                    imageModel = launch.image,
//                    modifier = Modifier
//                        .size(100.dp)
//                        .then(Modifier.padding(8.dp)),
//                    contentScale = ContentScale.Fit,
//                    placeHolder = ImageBitmap.imageResource(id = R.drawable.space_x_logo)
//                )
//            }
//            Column(Modifier.padding(8.dp)) {
//                Text(text = launch.name)
//                Text(DateFormatting.launchDate(launch.date))
//            }
//        }
//    }
//}