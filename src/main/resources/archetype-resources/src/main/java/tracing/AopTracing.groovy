package ${packageName}.tracing

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

import com.google.common.base.Stopwatch

@Aspect
@Configuration
class AopTracing {
	private static final Logger LOG = LoggerFactory.getLogger(AopTracing)

	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	@Before("@annotation(${packageName}.tracing.TrackInput) || @annotation(${packageName}.tracing.TrackInputOutput)")
	public void before(JoinPoint joinPoint) {
		//Advice
		def newargs = []
		for(def item in joinPoint.getArgs()) {
			newargs << firstFive(item)
		}
		LOG.trace "{} <<< {}", joinPoint.signature, newargs
	}

	private def firstFive(def arg) {
		def auxarg = arg
		if(arg instanceof Collection) {
			auxarg = arg.take(5)
			if(arg.size() > 5) {
				auxarg << "..."
			}
		}
		return auxarg
	}

	@AfterReturning(value = "@annotation(${packageName}.tracing.TrackOutput) || @annotation(${packageName}.tracing.TrackInputOutput)", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		def newresult = firstFive(result)

		LOG.trace "{} >>> {}", joinPoint.signature, newresult
	}

	@Around("@annotation(${packageName}.tracing.TrackTime)")
	public def around(ProceedingJoinPoint joinPoint) throws Throwable {
		Stopwatch stopwatch = Stopwatch.createStarted()
		def result = joinPoint.proceed()
		def timeTaken = stopwatch.stop()
		LOG.trace "{} == {}", joinPoint.signature, timeTaken
		return result
	}
}
