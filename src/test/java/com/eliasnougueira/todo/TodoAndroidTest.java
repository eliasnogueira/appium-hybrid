package com.eliasnougueira.todo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TodoAndroidTest {

	@Test
	public void testeToDo() throws MalformedURLException {
		// capacidades
		File app = new File("src/test/resources/todo/android/ToDo.apk");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulador");
		dc.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		// sessao
		AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		driver.findElement(By.id("titulo")).sendKeys("Lavar o carro");
		driver.findElement(By.cssSelector(".button.button-positive.button-small")).click();
		
		// validação
		assertTrue(driver.findElement(By.xpath("//span[text()='Lavar o carro']")).isDisplayed());
		
		driver.quit();
	}

}
