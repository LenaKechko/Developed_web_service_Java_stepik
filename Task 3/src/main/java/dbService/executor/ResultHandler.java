package dbService.executor;

import java.sql.SQLException;
import java.sql.ResultSet;

public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
