package logic;

import logic.parser.QueryParser;
import model.query.Query;
import model.Model;

/**
 * Handles the logic of the application
 */
public class LogicManager {

    private final Model model;

    public LogicManager(Model model) {
        this.model = model;
    }

    public String handleQuery(String queryString) {
        try {
            Query query = QueryParser.parseQuery(model.getTownList(), queryString);
            return query.execute(model);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
