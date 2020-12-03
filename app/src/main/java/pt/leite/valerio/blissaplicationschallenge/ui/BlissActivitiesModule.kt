package pt.leite.valerio.blissaplicationschallenge.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pt.leite.valerio.blissaplicationschallenge.ui.emoji_list.EmojiListActivity
import pt.leite.valerio.blissaplicationschallenge.ui.emoji_list.EmojiListActivityModule
import pt.leite.valerio.blissaplicationschallenge.ui.main.MainActivity
import pt.leite.valerio.blissaplicationschallenge.ui.main.MainActivityModule

@Module

abstract class BlissActivitiesModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivityInjector(): MainActivity

    @ContributesAndroidInjector(modules = [EmojiListActivityModule::class])
    internal abstract fun emojiListActivityInjector(): EmojiListActivity
}