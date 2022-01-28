package ninja.spring.chaos.clientservice.config;

import de.codecentric.spring.boot.chaos.monkey.configuration.ChaosMonkeySettings;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChaosMetricsConfig {

    private final ChaosMonkeySettings chaosMonkeySettings;

    public ChaosMetricsConfig(ChaosMonkeySettings chaosMonkeySettings) {
        this.chaosMonkeySettings = chaosMonkeySettings;
    }

    @Bean
    Gauge chaosMonkeyStatusGauge(MeterRegistry registry) {
        Number chaosMonkeyStatus = 0;
        if (chaosMonkeySettings.getChaosMonkeyProperties().isEnabled()) {
            chaosMonkeyStatus = 1;
        }

        return Gauge
                .builder("chaos.monkey.status", chaosMonkeyStatus, this::convert)
                .register(registry);
    }

    private double convert(Number f) {
        Number chaosMonkeyStatus = 0;
        if (chaosMonkeySettings.getChaosMonkeyProperties().isEnabled()) {
            chaosMonkeyStatus = 1;
        }
        return chaosMonkeyStatus.doubleValue();
    }
}

