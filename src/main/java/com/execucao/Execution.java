package com.execucao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Execution {

	public static void exec(String MethodName , String caminhoClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		
			// no paramater
				Class noparams[] = {};

				// String parameter
				Class[] paramString = new Class[1];
				paramString[0] = String.class;

				// int parameter
				Class[] paramInt = new Class[1];
				paramInt[0] = Integer.TYPE;

				// load the AppTest at runtime
				Class cls = Class.forName(caminhoClass);

				Object obj = cls.newInstance();
  
						Method method = cls.getDeclaredMethod("setUp", noparams);
						method.invoke(obj, null);
						 
						method = cls.getDeclaredMethod(MethodName, noparams);
						method.invoke(obj, null);
						
						method = cls.getDeclaredMethod("tearDown", noparams);
						method.invoke(obj, null);
				 
	}
	
}
