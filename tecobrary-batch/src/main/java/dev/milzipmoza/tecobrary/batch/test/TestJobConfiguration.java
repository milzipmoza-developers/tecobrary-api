package dev.milzipmoza.tecobrary.batch.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TestJobConfiguration {

    public static final String TEST_JOB_NAME = "TEST_JOB";
    public static final String TEST_STEP_NAME = "TEST_STEP";
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean(TEST_JOB_NAME)
    public Job testJob() {
        return jobBuilderFactory.get(TEST_JOB_NAME)
                .start(testStep())
                .build();
    }

    @Bean(TEST_STEP_NAME)
    public Step testStep() {
        return stepBuilderFactory.get(TEST_STEP_NAME)
                .tasklet(((contribution, chunkContext) -> {
                    log.info("test step");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }
}
