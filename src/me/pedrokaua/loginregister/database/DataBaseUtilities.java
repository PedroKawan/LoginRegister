package me.pedrokaua.loginregister.database;

public class DataBaseUtilities {

	private final static DataRegex regexInstance = new DataRegex();
	private final static DataReader readerInstance = new DataReader();
	private final static DataExport exportInstance = new DataExport();
	
	
	public static DataRegex getRegexInstance() {
		return regexInstance;
	}
	public static DataReader getReaderInstance() {
		return readerInstance;
	}
	public static DataExport getExportInstance() {
		return exportInstance;
	}
	
	
}
