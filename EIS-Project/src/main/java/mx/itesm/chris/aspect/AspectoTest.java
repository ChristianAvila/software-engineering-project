package mx.itesm.chris.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectoTest {
	
	@After("execution(public * mx.itesm.chris.controller.TestController.startPath(..))")
	public void arfterTestLoad(){
			System.out.println("INFO: Acceso a la pagina principal /");
	}

	
	@Before("execution(public * mx.itesm.chris.controller.TestController.getDataByYear(..))")
	public void beforeExecuteQuery(){
			System.out.println("INFO: Acceso a base de datos Iniciando");
	}
	
	@After("execution(public * mx.itesm.chris.controller.TestController.getDataByYear(..))")
	public void afterExecuteQuery(){
			System.out.println("INFO: Acceso a base de datos Termiando");
	}
}