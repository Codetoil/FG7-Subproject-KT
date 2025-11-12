package com.example.examplemod.platform;

import com.example.examplemod.Constants;
import com.example.examplemod.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

// Service loaders are a built-in Java feature that allow us to locate implementations of an interface that vary from one
// environment to another. In the context of MultiLoader we use this feature to access a mock API in the common code that
// is swapped out for the platform specific implementation at runtime.
public class Services
{

	// In this example we provide a platform helper which provides information about what platform the mod is running on.
	// For example this can be used to check if the code is running on Forge vs Fabric, or to ask the modloader if another
	// mod is loaded.
	public static final ForgePlatformHelper PLATFORM = new ForgePlatformHelper();

}