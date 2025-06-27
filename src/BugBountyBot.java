import java.io.*;
import java.util.*;
import java.util.regex.*;

class LogEntry {
    String timestamp;
    String level;
    String message;

    LogEntry(String timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public String toString() {
        return "[" + level + "!] at: " + timestamp + ": " + message;
    }
}

public class BugBountyBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the full path to your log file (e.g. C:\\Users\\user\\Documents\\log.txt): ");
        String fileName = scanner.nextLine().trim(); //prevents whitespace from returning a FileNotFound error

        File file = new File(fileName);
        if (!file.exists()) {
        System.out.println("File not found: " + fileName);
        return;
}
        List<LogEntry> logs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                LogEntry entry = parseLogLine(line);
                if (entry != null) {
                    logs.add(entry);
                }
            }

        } catch (IOException e) {
            System.out.println("Failed to read file: " + fileName);
            e.printStackTrace();
            return;
        }

        System.out.println(">>> Parsed Log Entries <<<");
        for (LogEntry log : logs) {
            System.out.println(log);
        }
    }

    // Gets [timestamp] LEVEL message from a log line
    private static LogEntry parseLogLine(String line) {
        Pattern pattern = Pattern.compile("\\[(.*?)\\]\\s+(INFO|WARN|ERROR)\\s+(.*)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.matches()) {
            String timestamp = matcher.group(1);
            String level = matcher.group(2);
            String message = matcher.group(3);
            return new LogEntry(timestamp, level, message);
        }
        return null; // if line didn’t match pattern, return null
    }
}
