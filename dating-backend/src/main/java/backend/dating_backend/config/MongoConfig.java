package backend.dating_backend.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "backend.dating_backend.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "DatingApp";
    }

    // MongoClient connection to MongoDB
    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(
                "mongodb+srv://kedarkini2019:Saaket%402003@cluster0.tc9g6.mongodb.net/DatingApp?retryWrites=true&w=majority");
    }

    // Defining MongoTemplate bean (for interraction with db)
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), getDatabaseName());
    }
}
