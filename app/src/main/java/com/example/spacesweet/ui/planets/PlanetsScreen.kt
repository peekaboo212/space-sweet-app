package com.example.spacesweet.ui.planets

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.spacesweet.R
import com.example.spacesweet.data.shared_preferencences.Preferences


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlanetsScreen(preferences: Preferences){
    Scaffold {
        Box(
            Modifier.fillMaxSize()
        ) {
            SpaceBackground()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    elevation = 4.dp,
                    modifier = Modifier.padding(30.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {

                            Text(
                                text = "Planetas",
                                textAlign = TextAlign.Center,
                                color = Color.Black,
                                fontSize = 30.sp,
                                modifier = Modifier.padding(bottom = 40.dp)
                            )

                        ImageList(imageList, preferences.getNumberOfPlanets())
                        Row(modifier = Modifier.padding(top = 30.dp)){
                            Column() {
                                Text(
                                    text = "Legendary",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Column() {
                                Text(
                                    text = "Supremo",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }

                                Text(
                                    text = "Normal",
                                    textAlign = TextAlign.Center,
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )

                        }
                    }
                }
            }
        }
    }
}

data class ImageInfo(val id: Int, val name: String, val location: Int)

val imageList = listOf(
    ImageInfo(1, "Froz", R.drawable.planeta_heladofin),
    ImageInfo(2, "Pantan", R.drawable.planeta_pantanosofin),
    ImageInfo(3, "Vyper", R.drawable.planeta_venenoso),
    ImageInfo(4, "Roboto", R.drawable.planetarobotfin),
    ImageInfo(5, "Mistery", R.drawable.planetamisterioso),
    ImageInfo(6, "Catrrent", R.drawable.cat_planet),
    ImageInfo(7, "Norboring", R.drawable.earth),
    ImageInfo(8, "Rainbow planet", R.drawable.rainbow_planet)
)

@Composable
fun ImageList(images: List<ImageInfo>, count: Int) {

    if (count > images.size) {
        ImageList(images, images.size)
        return
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(images.take(count)) { image ->
            Column() {


                Image(
                    painter = painterResource(id = image.location),
                    contentDescription = null,
                    modifier = Modifier.padding(end = 1.dp, )
                )
                Text(text = image.name, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,)
            }


            }
        }
    }

@Composable
fun SpaceBackground() {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Image(
        painter = rememberAsyncImagePainter(R.drawable.space_background, imageLoader),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}


