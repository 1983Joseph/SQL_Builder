    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author disney
 */
public class Constants {

    public static final String templateName = "Media";

    //TBD Constants
    // error logs
    public static final String errMsgNoConnectionHiveServer = "ERROR: Could not connect to Hive Server: ";
    public static final String errMsgIgnorGroot = "ERROR: Ignoring Groot testing: specified Groot test plan is not valid file: ";
    public static final String errMsgfailedCloseStream = "ERROR: Failed to close the stream.\n";
    public static final String errMsgJdbcConnection = "ERROR: Could not find the JDBC driver class.";
    public static final String errMsgNoConnectionVerticaServer = "ERROR: Could not connect to Vertica Server: ";
    public static final String msgConnected = "Successfully connected to DB Server.";

    //File Paths
    public static final String configFilePath = "src/main/resources/config.json";
    public static final String templatesDirPath = "src/main/resources/templates/";
    public static final String background = "background.template";
    public static final String correctEventScenario = "correct_event_scenario.template";
    public static final String feature = "feature.template";
    public static final String turnDown = "turn_down.template";
    public static final String incorrectEventScenario = "incorrect_event_scenario.template";
    public static final String hiveTestCasesPath = "src/test/resources/com/di/bi/maymekh/event_verification_hive/";
    public static final String batchScenario = "batch_scenario.template";
    public static final String correctBatchEvent = "correct_batch_event.template";
    public static final String incorrectBatchEvent = "incorrect_batch_event.template";
    public static final String ignoredFile = "_SUCCESS";

    //test Parameters
    public static final String appId = "com.di.bi.hzn_qa_bi_hadoop";
    public static final String appName = "intl-horizonqa_bi_hadoop";
    public static final String appNameForEventVerification = "intl-horizonqa_bi_event_verification";

    //table prefix
    public static final String lookUpTable = "LU_";
    //Query
    public static final String hiveQueryGetId = "SELECT eventid FROM qa_cto_mobile.${TABLE_NAME} "
        + "WHERE date='${DATE}' AND eventtype='${EVENT_NAME}' "
        + "AND appname='${APP_NAME}'";
    public static final String hiveQueryGetIdMediaAction = "SELECT eventid FROM qa_cto_mobile.${TABLE_NAME} "
        + "WHERE date='${DATE}' AND actiontype='${EVENT_NAME}' "
        + "AND appname='${APP_NAME}'";
    public static String filterForCassandra = " ALLOW FILTERING";

    public enum ServersHosts {

        Cassandra("n7vcq1bi001cas01.compliant.disney.private"),
        Vertica("qn7bi01vnd001"),
        Hive("qn7bi01hdn201.compliant.disney.private"),
        Hive0("qn7bi01hdn200.compliant.disney.private"),
        Hadoop("qn7bi01hdn200.compliant.disney.private");

        private final String elementType;

        private ServersHosts(String element) {
            this.elementType = element;
        }

        @Override
        public String toString() {
            return elementType;
        }

    }

    public enum QueryFields {

        TABLE_NAME("TABLE_NAME"),
        EVENT_NAME("EVENT_NAME"),
        APP_NAME("APP_NAME"),
        BUNDLE_ID("BUNDLE_ID"),
        END_DATE("END_DATE"),
        DATE("DATE"),
        HR("HR"),
        TESTING_DATE("TESTING_DATE"),
        LAST_TESTING_DATE("LAST_TESTING_DATE");

        private final String elementType;

        private QueryFields(String element) {
            this.elementType = element;
        }

        @Override
        public String toString() {
            return elementType;
        }

    }

    public enum TimeParameters {

        ARGUMENT_FORMAT("yyyyMMdd"),
        HADOOP_FORMAT("yyyyMMdd_hhmmss"),
        HIVE_VERTICA_FORMAT("yyyy-MM-dd"),
        LOS_ANGELES("America/Los_Angeles"),
        TIME_ZONE("MST7MDT"),
        SHORT_DATE("yyyy-MM-dd HH:mm:ss"),
        SHORT_DATE_BY_UNDERSCORES("yyyy-MM-dd_HH-mm-ss");

        private final String elementType;

        private TimeParameters(String element) {
            this.elementType = element;
        }

        @Override
        public String toString() {
            return elementType;
        }

    }

    public enum ServersPorts {

        Cassandra(9160),
        Vertica(5433),
        Hive(10000),
        Hadoop(10000); //TODO:

        private int port;

        private ServersPorts(int arg) {
            this.port = arg;
        }

        public int toInteger() {
            return port;
        }

    }

    public enum Clients {

        CASSANDRA("cassandra"),
        HADOOP("hadoop"),
        HIVE("hive"),
        VERTICA("vertica");

        private final String element;

        private Clients(String element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element;
        }

        public static Clients getKeyByValue(String value) {
            for (Clients item : values()) {
                if (item.element.equalsIgnoreCase(value)) {
                    return item;
                }
            }
            return null;
        }
    }

    public enum CastTypes {

        DATE("date"),
        VERTICA_DATE("vertica_date"),
        NONE("none");

        private final String element;

        private CastTypes(String element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element;
        }
    }

    public enum Url {

        CASSANDRA("hzn_gx"),
        HIVE("default"),
        VERTICA("");

        private final String element;

        private Url(String element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element;
        }
    }

    public enum SpecificTableNames {

        LU_SESSION("lu_session"),
        LU_TAP_ACTION("lu_tap_action"),
        LU_APP("lu_app"),
        EXTRACT_TAP_ACTION("EXTRACT_MOBILE_TAP_ACTION"),
        EXTRACT_APP("EXTRACT_MOBILE_APP"),
        EXTRACT_SESSION("EXTRACT_MOBILE_SESSION"),
        EXTRACT_MOBILE_USER("EXTRACT_MOBILE_USER"),
        EXTRACT_MOBILE_DEVICE("EXTRACT_MOBILE_DEVICE");

        private final String element;

        private SpecificTableNames(String element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element;
        }
    }

    public enum CassandraVerticaConnectionDataLoss {

        DEFAULT("SELECT COUNT(*) FROM ${TABLE_NAME}"
            + " WHERE  start_gmt='${DATE}' AND "
            + "end_gmt<='${END_DATE}'"),
        VERTICA("SELECT COUNT(*) FROM ${TABLE_NAME}"
            + " WHERE  BUNDLE_ID='${BUNDLE_ID}'  AND "
            + "date(to_timestamp(event_gmt))='${DATE}'"),
        WITHOUT_DATE_VERTICA("SELECT COUNT(*) FROM ${TABLE_NAME}"
            + " WHERE  BUNDLE_ID='${BUNDLE_ID}'"),
        WITHOUT_DATE_HIVE("SELECT COUNT(*) FROM ${TABLE_NAME}"
            + " WHERE  bundleid='${BUNDLE_ID}'");

        private final String query;

        private CassandraVerticaConnectionDataLoss(String element) {
            this.query = element;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    public enum VideoTablesDataLossQueries {

        HIVE("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "event_ts>='${TESTING_DATE}' AND "
            + "event_ts<'${LAST_TESTING_DATE}'"),
        CASSANDRA("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "event_ts>='${TESTING_DATE}' AND "
            + "event_ts<'${LAST_TESTING_DATE}'"); //2015-09-14 00:00:00

        private final String query;

        private VideoTablesDataLossQueries(String element) {
            this.query = element;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    public enum MediaTablesDataLossQueries {

        HIVE("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "mediatype in (${MEDIA_TYPE})  AND "
            + "bundleid='${BUNDLE_ID}'  AND "
            + "date=${DATE}"),
        HIVE_DATETIME("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "mediatype in (${MEDIA_TYPE})  AND "
            + "bundleid='${BUNDLE_ID}'  AND "
            + "date=${DATE} AND hour=${HR} "),
        HIVE_MEDIA_PLAY("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "mediatype='${MEDIA_TYPE}' AND "
            + "mediaplaytype='${MEDIA_PLAY_TYPE}' AND "
            + "bundleid='${BUNDLE_ID}'  AND "
            + "date=${DATE}"),
        HIVE_MEDIA_PLAY_DATETIME("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "mediatype='${MEDIA_TYPE}' AND "
            + "mediaplaytype='${MEDIA_PLAY_TYPE}' AND "
            + "bundleid='${BUNDLE_ID}'  AND "
            + "date=${DATE} AND hour=${HR} "),
        VERTICA("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "bundle_id='${BUNDLE_ID}' AND "
            + "EVENT_ID='${EVENT_NAME}' AND "
            + "date(to_timestamp(event_gmt))='${DATE}'");

        private final String query;

        private MediaTablesDataLossQueries(String element) {
            this.query = element;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    public enum ConnectionAndDataLoss {

        HIVE("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "bundleid='${BUNDLE_ID}' AND date=${DATE}"),
        HIVE_WITH_DATETIME("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "bundleid='${BUNDLE_ID}' AND date=${DATE} AND hour=${HR}"),
        HIVE_BY_COLUMN_NAME("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "${UNIQUE_KEY}='${UNIQUE_VALUE}'"),
        HIVE_BY_UNIQUE_NAME("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "${UNIQUE_KEY} like '${UNIQUE_VALUE}' group by ${GROUP_KEY}"),
        HIVE_BY_DATE("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + " date=${DATE}"),
        VERTICA("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "bundle_id='${BUNDLE_ID}' AND "
            + "date(to_timestamp(event_gmt))='${DATE}'"),
        VERTICA_BY_UNIQUE_NAME("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "${UNIQUE_KEY} like '${UNIQUE_VALUE}' group by ${GROUP_KEY}"),
        VERTICA_BY_COLUMN_NAME("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "${UNIQUE_KEY}='${UNIQUE_VALUE}'"),
        VERTICA_BY_DATE("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "date(to_timestamp(event_gmt))='${DATE}'"),
        VERTICA_BY_DATA_SOURCE_ID("SELECT COUNT(*) FROM ${TABLE_NAME} WHERE "
            + "bundle_id='${BUNDLE_ID}' AND "
            + "DATA_SOURCE_ID like '${DATE}%'");

        private final String query;

        private ConnectionAndDataLoss(String element) {
            this.query = element;
        }

        @Override
        public String toString() {
            return query;
        }

    }

    public enum ComponentLogicVerification {

        VERTICA_EXTRACT("SELECT COUNT(*) FROM ${SCHEMA_NAME}.${TABLE_NAME} "
            + "WHERE  BUNDLE_ID LIKE '${BUNDLE_ID}' "
            + "AND DATA_SOURCE_ID LIKE '${DATE}%'"),
        VERTICA_BY_UNIQUE_KEY("SELECT COUNT(*) FROM ${SCHEMA_NAME}.${TABLE_NAME} "
            + "WHERE   ${UNIQUE_KEY} LIKE '${UNIQUE_VALUE}' "
            + "AND DATA_SOURCE_ID LIKE '${DATE}%'"),
        VERTICA("SELECT COUNT(*) FROM ${SCHEMA_NAME}.${TABLE_NAME} "
            + "WHERE DATA_SOURCE_ID LIKE '${DATE}%'"),
        VERTICA_BY_UNIQUE_DATA("SELECT COUNT(*) FROM ${SCHEMA1_NAME.TABLE_NAME} "
            + " WHERE DATA_SOURCE_ID LIKE '${DATE}%' AND ${UNIQUE_KEY=UNIQUE_VALUE} AND event_location not in"
            + " (SELECT content_location_nkey FROM ${SCHEMA2_NAME.TABLE_NAME})"),
        VERTICA_COMMON("SELECT COUNT(*) FROM ${SCHEMA1_NAME.TABLE_NAME}"
            + " WHERE DATA_SOURCE_ID LIKE '${DATE}%' "
            + " AND ${UNIQUE_KEY1=UNIQUE_VALUE} AND concat(${CONDITION1}) not in"
            + " (SELECT concat(${CONDITION2}) FROM ${SCHEMA2_NAME.TABLE_NAME}"
            + " WHERE ${UNIQUE_KEY2=UNIQUE_VALUE} )");

        private final String query;

        private ComponentLogicVerification(String element) {
            this.query = element;
        }

        @Override
        public String toString() {
            return query;
        }

    }

    public enum DataDuplication {

        VERTICA_LU_DUPLICATES("SELECT count(*) as duplicates "
            + " FROM "
            + "	(SELECT ${COLUMN_KEY}, count(*) "
            + "	FROM ${SCHEMA_NAME.TABLE_NAME} "
            + " WHERE DATA_SOURCE_ID LIKE '${DATE}%' "
            + "	group by 1 "
            + "	having count(*) > 1"
            + ") t1"),
        VERTICA_FACT_DUPLICATES("SELECT count(distinct ${COLUMN1}) as no_of_column1, "
            + " count(distinct ${COLUMN2}) as no_of_column2, "
            + " count(*) as no_of_rows "
            + " FROM ${SCHEMA_NAME.TABLE_NAME} "
            + " WHERE date(to_timestamp(${DATE_KEY})) between '${START_TESTING_DATE}' "
            + " AND '${END_TESTING_DATE}' "
            + " AND ${BUNDLE_KEY} like '${BUNDLE_ID}' "),
        VERTICA_FACT_VERIFIER("SELECT count(*) "
            + " FROM ${SCHEMA_NAME.TABLE_NAME} "
            + " where date(to_timestamp(${DATE_KEY})) between '${START_TESTING_DATE}' "
            + " and '${END_TESTING_DATE}' "
            + " and ${COLUMN} ${CON_SYM} 0"
            + "AND ${BUNDLE_KEY} like '${BUNDLE_ID}'");

        private final String query;

        private DataDuplication(String element) {
            this.query = element;
        }

        @Override
        public String toString() {
            return query;
        }

    }

    public enum VerticaSchema {

        INTL("QA_DWCTOMOBILEINTL"),
        CORE("QA_DWCTOMOBILECORE"),
        EXTRACT("QA_DWCTOMOBILECORE_EXTRACT");

        private final String element;

        private VerticaSchema(String element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element;
        }
    }

    public enum HadoopFileReadType {

        WITH_BUNDLE_ID_AND_EVENT_NAME("with bundle id and event name"),
        WITH_BUNDLE_ID("with bundle id"),
        WITHOUT_ANYTHING("without anything"),
        NONE("none");

        private final String element;

        private HadoopFileReadType(String element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return element;
        }
    }

    private static final Map<String, String> tableNamesHive = new HashMap();

    public static Map getHiveTableNames() {
        if (tableNamesHive.isEmpty()) {
            setHiveTableNames();
        }
        return tableNamesHive;
    }

    private static void setHiveTableNames() {
        tableNamesHive.put("action", "action");
        tableNamesHive.put("ad_action", "ad_action");
        tableNamesHive.put("background", "app_background");
        tableNamesHive.put("end", "app_end");
        tableNamesHive.put("foreground", "app_foreground");
        tableNamesHive.put("start", "app_start");
        tableNamesHive.put("guest_info", "guest_info");
        tableNamesHive.put("init_media", "media_action");
        tableNamesHive.put("buffer_start", "media_action");
        tableNamesHive.put("buffer_end", "media_action");
        tableNamesHive.put("buffer_complete", "media_action");
        tableNamesHive.put("buffer_warning_start", "media_action");
        tableNamesHive.put("buffer_warning_end", "media_action");
        tableNamesHive.put("dropped_frames", "media_action");
        tableNamesHive.put("update_playhead", "media_action");
        tableNamesHive.put("percent_reached", "media_action");
        tableNamesHive.put("pause", "media_action");
        tableNamesHive.put("play", "media_action");
        tableNamesHive.put("stop", "media_action");
        tableNamesHive.put("forward", "media_action");
        tableNamesHive.put("backward", "media_action");
        tableNamesHive.put("player_close", "media_action");
        tableNamesHive.put("scrub_from", "media_action");
        tableNamesHive.put("scrub_to", "media_action");
        tableNamesHive.put("rollback", "media_action");
        tableNamesHive.put("repeat_one", "media_action");
        tableNamesHive.put("repeat_all", "media_action");
        tableNamesHive.put("shuffle", "media_action");
        tableNamesHive.put("enter_mini_player", "media_action");
        tableNamesHive.put("exit_mini_player", "media_action");
        tableNamesHive.put("enter_fullscreen", "media_action");
        tableNamesHive.put("exit_fullscreen", "media_action");
        tableNamesHive.put("bitrate_change", "media_action");
        tableNamesHive.put("mute", "media_action");
        tableNamesHive.put("unmute", "media_action");
        tableNamesHive.put("change_volume", "media_action");
        tableNamesHive.put("audio_lang_change", "media_action");
        tableNamesHive.put("subtitle_lang_change", "media_action");
        tableNamesHive.put("error_media", "media_action");
        tableNamesHive.put("bookmark", "media_action");
        tableNamesHive.put("change_page", "media_action");
        tableNamesHive.put("change_font_size", "media_action");
        tableNamesHive.put("navigation_action", "navigation_action");
        tableNamesHive.put("page_view", "page_view");
        tableNamesHive.put("session_end", "session_end");
        tableNamesHive.put("session_idle", "session_idle");
        tableNamesHive.put("timing", "timing");
        tableNamesHive.put("touch_action", "touch_action");
        tableNamesHive.put("payment_action", "payment_action");
        tableNamesHive.put("in_app_currency_action", "in_app_currency_action");
        tableNamesHive.put("social_action", "social_action");
        tableNamesHive.put("state", "state");
        tableNamesHive.put("funnel_action", "funnel_action");
        tableNamesHive.put("review_action", "review_action");
        tableNamesHive.put("internal_search_action", "internal_search_action");
        tableNamesHive.put("error", "app_error");
        tableNamesHive.put("perf", "perf");

        //TBD add events name
        tableNamesHive.put("", "lu_app");
        tableNamesHive.put("", "lu_content_location");
        tableNamesHive.put("", "lu_country");
        tableNamesHive.put("", "lu_device");
        tableNamesHive.put("", "lu_device_app");
        tableNamesHive.put("", "lu_geo");
        tableNamesHive.put("", "lu_hard_currency");
        tableNamesHive.put("", "lu_lib_version");
        tableNamesHive.put("", "lu_machine_info");
        tableNamesHive.put("", "lu_purchase");
        tableNamesHive.put("", "lu_reg_type");
        tableNamesHive.put("", "lu_soft_currency");
        tableNamesHive.put("", "lu_tap_action");
        tableNamesHive.put("", "lu_user");
        tableNamesHive.put("", "lu_user_app");
        tableNamesHive.put("", "lu_user_device");
    }
}
