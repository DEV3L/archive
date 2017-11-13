package com.dev3l.minecraft.main;

import com.dev3l.minecraft.lib.StringConstants;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StringConstants.MODID, version = StringConstants.VERSION)
public class MainRegistry {
	@EventHandler
	public static void preLoad(FMLPreInitializationEvent preEvent) {
		
	}
	
	@EventHandler
	public static void preLoad(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public static void preLoad(FMLPostInitializationEvent postEvent) {
		
	}
}
