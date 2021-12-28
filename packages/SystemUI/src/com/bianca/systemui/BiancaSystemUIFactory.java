package com.bianca.systemui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;

import com.bianca.systemui.dagger.BiancaGlobalRootComponent;
import com.bianca.systemui.dagger.BiancaSysUIComponent;
import com.bianca.systemui.dagger.DaggerBiancaGlobalRootComponent;

import com.android.systemui.SystemUIFactory;
import com.android.systemui.dagger.GlobalRootComponent;
import com.android.systemui.navigationbar.gestural.BackGestureTfClassifierProvider;
import com.android.systemui.screenshot.ScreenshotNotificationSmartActionsProvider;

import com.google.android.systemui.gesture.BackGestureTfClassifierProviderGoogle;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class BiancaSystemUIFactory extends SystemUIFactory {
    @Override
    protected GlobalRootComponent buildGlobalRootComponent(Context context) {
        return DaggerBiancaGlobalRootComponent.builder()
                .context(context)
                .build();
    }

    @Override
    public BackGestureTfClassifierProvider createBackGestureTfClassifierProvider(AssetManager am, String modelName) {
        return new BackGestureTfClassifierProviderGoogle(am, modelName);
    }

    @Override
    public void init(Context context, boolean fromTest) throws ExecutionException, InterruptedException {
        super.init(context, fromTest);
        if (shouldInitializeComponents()) {
            ((BiancaSysUIComponent) getSysUIComponent()).createKeyguardSmartspaceController();
        }
    }
}
