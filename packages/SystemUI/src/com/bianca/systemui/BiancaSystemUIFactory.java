package com.bianca.systemui;

import android.content.Context;

import com.bianca.systemui.dagger.BiancaGlobalRootComponent;
import com.bianca.systemui.dagger.DaggerBiancaGlobalRootComponent;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;

public class BiancaSystemUIFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerBiancaGlobalRootComponent.builder()
                .context(context)
                .build();
    }
}
