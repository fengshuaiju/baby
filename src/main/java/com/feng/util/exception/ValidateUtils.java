package com.feng.util.exception;

import java.util.Collection;

public class ValidateUtils {

	public static void isTrue(boolean expression, ExceptionCode exceptionCode, String info){
		if(!expression){
			throw new BusinessException(exceptionCode,info);
		}
	}
	
	public static void isTrue(boolean expression, ExceptionCode exceptionCode){
		if(!expression){
			throw new BusinessException(exceptionCode);
		}
	}
	
	public static void isTrue(boolean expression, String info){
		if(!expression){
			throw new BusinessException(ExceptionCode.UNKNOWN,info);
		}
	}
	
	public static void notNull(Object object, ExceptionCode exceptionCode){
		if(object == null){
			throw new BusinessException(exceptionCode);
		}
	}
	
	public static void notNull(Object object, ExceptionCode exceptionCode, String info){
		if(object == null){
			throw new BusinessException(exceptionCode,info);
		}
	}
	
	public static void notNull(Object object, String info){
		if(object == null){
			throw new BusinessException(ExceptionCode.UNKNOWN,info);
		}
	}
	
	public static void notEmpty(Collection<?> collection, ExceptionCode exceptionCode){
		if(collection != null){
			if(collection.size() == 0){
				throw new BusinessException(exceptionCode);
			}
		}
		throw new BusinessException(exceptionCode);
	}
	
}
