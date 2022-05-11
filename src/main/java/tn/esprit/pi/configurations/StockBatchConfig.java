package tn.esprit.pi.configurations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import tn.esprit.pi.batch.StockProcessor;
import tn.esprit.pi.batch.StockWriter;
import tn.esprit.pi.entities.Products;


@Configuration
/*3. Activer le traitement par lot */
/*toDo5*/
@EnableBatchProcessing
@EnableScheduling
public class StockBatchConfig {

	/*4. Création des variables de notre batch (nom fichier,
	 * nom job, nom step, nom lecteur*/
	private static final String FILE_NAME = "stock.csv"/*toDo1*/;
	private static final String JOB_NAME = "listStocksJob";
	private static final String STEP_NAME = "processingStep";
	private static final String READER_NAME = "stockItemReader";

	/*5. Lister les champs que nous souhaitons parser dans le
	 * fichier excel*/
	private String names = "barCode,nameProd,unit_price_htva,tva,add_date" /*toDo2*/;
/*6. Définir la stratégie de délimitation des différents champs*/
	private String delimiter = ",";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	
	

	/*7 Créer le bean associé au job et le lancer*/
	@Bean
	public Job listStocksJob(Step step1) {
		return jobBuilderFactory.get(JOB_NAME).start(step1).build();
	}

	/*8 Créer le step associé au job et le lancer*/
	@Bean
	public Step stockStep() {
		return stepBuilderFactory.get(STEP_NAME).<Products, Products>chunk(5).reader(stockItemReader())
				.processor(stockItemProcessor()).writer(stockItemWriter()).build();
	}
	
	/*9. étape 1 (ItemReader) Créer le reader pour récupérer les données depuis
	 * le fichier csv*/
	@Bean
	public ItemReader<Products> stockItemReader() {
		FlatFileItemReader<Products> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource(FILE_NAME));
		reader.setName(READER_NAME);
		reader.setLinesToSkip(1);
		/*7. récupérer les données ligne par ligne du fichier excel */
		reader.setLineMapper(stockLineMapper());
		return reader;

	}

	
	/*10. récupérer les données ligne par ligne du fichier excel */

	@Bean
	public LineMapper<Products> stockLineMapper() {

		final DefaultLineMapper<Products> defaultLineMapper = new DefaultLineMapper<>();
		final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(delimiter);
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(names.split(delimiter));
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSet -> {
			Products data = new Products();
			data.setBarCode(fieldSet.readString(0));
			data.setNameProd(fieldSet.readString(1));
			data.setUnit_price_htva(fieldSet.readFloat(2));
			data.setTva(fieldSet.readFloat(3));
			try {
				data.setAdd_date(new SimpleDateFormat("dd/MM/yyyy").parse(fieldSet.readString(4)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//data.setProductCategory(fieldSet.read);
			
			return data;
		});
		return defaultLineMapper;
	}

	/* 11. étape 2 (ItemProcessor) fait appel à la classe StockProcessor
	 * qui se charge de modifier la logique des données selon
	 * nos besoins métiers */
	@Bean
	public ItemProcessor<Products, Products> stockItemProcessor() {
		return new StockProcessor();
	}

	
	/* 12. étape 3 (ItemWriter) fait appel à la classe StockWriter
	 * qui se charge de lancer le service de sauvegarde des 
	 * données liées à la partie stock dans la BD*/
	@Bean
	public ItemWriter<Products> stockItemWriter() {
		return new StockWriter();
	}
}
