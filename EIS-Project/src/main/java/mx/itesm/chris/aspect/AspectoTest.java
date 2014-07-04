package mx.itesm.chris.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectoTest {
	
	@After("execution(public * mx.itesm.chris.controller.TestController.startPath(..))")
	public void arfterTestLoad(){
			System.out.println("Warning: Aspecto cargado");
	}

}
