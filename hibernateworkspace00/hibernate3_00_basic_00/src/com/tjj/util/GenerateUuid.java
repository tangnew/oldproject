package com.tjj.util;

import java.util.UUID;

public abstract class GenerateUuid {
  public static String getUuid(){
	  return UUID.randomUUID().toString();
  }
}
