package ir.atriatech.core.di

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {

	@Provides
	@Singleton
	fun providesPicasso(): Picasso {
		return Picasso.get()
	}
}

