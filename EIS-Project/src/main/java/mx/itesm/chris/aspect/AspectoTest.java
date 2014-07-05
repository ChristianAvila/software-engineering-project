package mx.itesm.chris.aspect;

import java.sql.Timestamp;
import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectoTest {
	
	@After("execution(public * mx.itesm.chris.controller.TestController.startPath(..))")
	public void arfterTestLoad(){
		Date date= new Date();	
		System.out.println("INFO: Acceso a la pagina principal / " + new Timestamp(date.getTime()) );
	}

	
	@Before("execution(public * mx.itesm.chris.controller.TestController.getDataByYear(..))")
	public void beforeExecuteQuery(){
		Date date= new Date();	
		System.out.println("INFO: Acceso a base de datos Iniciando a las " + new Timestamp(date.getTime()));
	}
	
	@After("execution(public * mx.itesm.chris.controller.TestController.getDataByYear(..))")
	public void afterExecuteQuery(){
		Date date= new Date();	
		System.out.println("INFO: Acceso a base de datos Termiando a las " + new Timestamp(date.getTime()));
	}
}