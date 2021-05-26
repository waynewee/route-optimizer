import logic.LogicManager;
import model.Model;
import model.Matrix;
import model.RouteList;
import model.TownList;
import logic.parser.ModelParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static util.ErrorConstants.EMPTY_FILE_ERROR;
import static util.ErrorConstants.NOT_FOUND_FILE_ERROR;

public class App {

    public static void main(String[] args) {

       File sourceFile = new File(args[0]);
       File queryFile = new File(args[1]);

       try {
           Scanner sourceSc = new Scanner(sourceFile);
           Scanner querySc = new Scanner(queryFile);

           if (!sourceSc.hasNextLine() || !querySc.hasNextLine()) {
               throw new Exception(EMPTY_FILE_ERROR);
           }
           String source = sourceSc.nextLine();

           TownList townList = ModelParser.parseTowns(source);
           RouteList routeList = ModelParser.parseRoutes(source, townList);
           Matrix matrix = new Matrix(townList.getNumTowns(), routeList);

           Model model = new Model(townList, routeList, matrix);
           LogicManager logicManager = new LogicManager(model);

           int qnsNo = 1;
           while (querySc.hasNextLine()) {
               String query = querySc.nextLine();
               String answer = logicManager.handleQuery(query);
               System.out.printf("Output #%d: %s\n", qnsNo, answer);
               qnsNo++;
           }

       } catch (FileNotFoundException e) {
           System.out.println(NOT_FOUND_FILE_ERROR);
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }

    }
}
