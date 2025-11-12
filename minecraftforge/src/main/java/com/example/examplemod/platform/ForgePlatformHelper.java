package com.example.examplemod.platform;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper {

    public String getPlatformName() {

        return "Forge";
    }

    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

	/**
	 * Gets the name of the environment type as a string.
	 *
	 * @return The name of the environment type.
	 */
	public String getEnvironmentName() {

		return isDevelopmentEnvironment() ? "development":"production";
	}
}