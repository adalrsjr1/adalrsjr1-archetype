package ${packageName}

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["${packageName}"])
class App implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(App)

    public static void main( String[] args ) {
        LOG.info "STARTING THE APPLICATION"
        SpringApplication.run(App, args)
        LOG.info "APPLICATION FINISHED"
    }

    @Override
    public void run( String[] args) {
        LOG.info "EXECUTION : command line runner"

        println ">>> hello world!"
    }
}
