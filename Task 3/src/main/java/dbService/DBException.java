package dbService;

/**
 * Created with IntelliJ IDEA.
 * User: Зяблик
 * Date: 21.01.16
 * Time: 21:49
 * To change this template use File | Settings | File Templates.
 */
public class DBException extends Exception {
    public DBException(Throwable throwable){
        super(throwable);
    }
}
