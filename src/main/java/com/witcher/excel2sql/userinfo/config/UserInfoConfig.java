package com.witcher.excel2sql.userinfo.config;

import com.witcher.excel2sql.userinfo.entity.UserInfoEntity;
import com.witcher.excel2sql.userinfo.listener.JobCompletionNotificationListener;
import com.witcher.excel2sql.userinfo.mapper.IndexHolder;
import com.witcher.excel2sql.userinfo.mapper.UserInfoMapper;
import com.witcher.excel2sql.userinfo.processor.UserInfoItemProcessor;
import com.witcher.excel2sql.userinfo.setting.UserInfoSetting;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.FormatterLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @author Alex Mihailov {@literal <avmikhaylov@phoenixit.ru>}.
 */
@Configuration
@EnableBatchProcessing
public class UserInfoConfig {

    @Autowired
    private UserInfoSetting mSetting;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public BeanWrapperFieldExtractor<UserInfoEntity> userBeanWrapperFieldExtractor() {
        BeanWrapperFieldExtractor<UserInfoEntity> fieldExtractor = new BeanWrapperFieldExtractor<>();
        fieldExtractor.setNames(new String[]{"name", "phone", "email", "city", "deliveryMethod", "deliveryAddress"});
        return fieldExtractor;
    }

    @Bean
    public ItemWriter<UserInfoEntity> sqlUserInfoWriter() {
        FlatFileItemWriter<UserInfoEntity> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource(mSetting.getOutputFile()));
        writer.setAppendAllowed(true);

        FormatterLineAggregator<UserInfoEntity> lineAggregator = new FormatterLineAggregator<>();
        lineAggregator.setFormat(mSetting.getFormatLine());
        lineAggregator.setFieldExtractor(userBeanWrapperFieldExtractor());
        writer.setLineAggregator(lineAggregator);
        writer.setLineSeparator(mSetting.getSeparatorLine());
        writer.setShouldDeleteIfExists(true);
        return writer;
    }

    @Bean
    public ItemReader<UserInfoEntity> excelUserInfoReader() {
        PoiItemReader<UserInfoEntity> reader = new PoiItemReader<>();
        reader.setLinesToSkip(mSetting.getSkipRows());
        reader.setResource(new ClassPathResource(mSetting.getInputFile()));
        reader.setRowMapper(excelRowMapper());
        return reader;
    }

    @Bean
    public RowMapper<UserInfoEntity> excelRowMapper() {
        return new UserInfoMapper(
                new IndexHolder(mSetting.getIndexName(),
                        mSetting.getIndexPhone(),
                        mSetting.getIndexEmail(),
                        mSetting.getIndexCity(),
                        mSetting.getIndexDeliveryMethod(),
                        mSetting.getIndexDeliveryAddress())
        );
    }

    @Bean
    public UserInfoItemProcessor userInfoProcessor() {
        return new UserInfoItemProcessor();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step(ItemWriter<UserInfoEntity> sqlUserInfoWriter) {
        return stepBuilderFactory.get("step").<UserInfoEntity, UserInfoEntity> chunk(10)
                .reader(excelUserInfoReader())
                .processor(userInfoProcessor())
                .writer(sqlUserInfoWriter())
                .build();
    }
}
