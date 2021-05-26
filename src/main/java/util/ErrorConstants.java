package util;

public class ErrorConstants {

    public static final String PARSE_ERROR_SOURCE = "ERROR PARSING SOURCE: Please ensure that your query is correctly formatted.\ne.g. AE3 BC2 DE4";
    public static final String EMPTY_FILE_ERROR = "FILE IS EMPTY: Cannot process empty file.";
    public static final String NOT_FOUND_FILE_ERROR = "FILE NOT FOUND: Cannot find file.";
    public static final String INVALID_KEYWORD_ERROR = "INVALID KEYWORD: Valid keywords are - dist, cnts, cnte, shrt, cntr";
    public static final String INDEX_OUT_OF_BOUNDS_ERROR = "INDEX OUT OF BOUNDS: Are you attempting to query something that isn't there?";
    public static final String INVALID_QUERY_ERROR = "INVALID QUERY: Please check the syntax of your query.";
    public static final String INVALID_NAME_ERROR = "INVALID NAME: Town names must be a single character only.";
    public static final String EMPTY_TOWNS_ERROR = "TOWNS IS EMPTY: No valid towns are present in the argument list.";
    public static final String INTEGER_NOT_FOUND_ERROR = "INTEGER NOT FOUND: The query you are attempting to make requires an integer value.";
    public static final String NO_SUCH_ROUTE_ERROR = "NO SUCH ROUTE";

}
