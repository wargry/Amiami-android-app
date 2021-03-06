package ru.cherryperry.amiami.screen.settings

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface SettingsFragmentSubcomponent : AndroidInjector<SettingsFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SettingsFragment>()
}