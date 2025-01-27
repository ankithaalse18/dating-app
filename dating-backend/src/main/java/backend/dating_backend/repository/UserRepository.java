package backend.dating_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import backend.dating_backend.model.UserModel;

// extends MangoRepository for CRUD operations
public interface UserRepository extends MongoRepository<UserModel, String> {

}
