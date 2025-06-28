***>>> Bug Bounty Bot <<<***

The BugBountyBot is designed to be a lightweight Java tool that parses log files, detects errors, and clusters similar issues together. It was made with the intention of helping developers quickly understand  and organize complex logs.

What It Does:

- Accepts any log file path from the user
- Extracts timestamp, log level, and message using regex
- Filters for ERROR entries and groups similar messages
- Helps identify recurring bugs or log patterns

What I Learned:

- This project was a great refresher on several key Java concepts and problem-solving skills.

- Relearned how to build and safely escape regex patterns in Java, especially using capturing groups such as
- 
(.∗?)(.∗?)\s+(INFO|WARN|ERROR)\s+(.*).

- Gained comfort working with Java file input and output tools like BufferedReader, FileReader, and try-with-resources for safe file handling

- Became more familiar with Pattern and Matcher classes to compile regex patterns, apply them line by line, and extract structured data from logs 

How to Run:

Clone the repository by entering the following into your compiler's terminal:

git clone https://github.com/ousmanjagana/BugBountyBot.git


Compile the program by enterting the following into your compiler's terminal:

javac -d bin src/*.java


Run the program:

java -cp bin BugBountyBot


When prompted, enter the FULL path to your log file, for example:

C:\Users\yourname\Documents\sample_log.txt

Desired Sample Log Format:

[2025-06-23 03:30:15] INFO Application started

[2025-06-23 03:31:22] ERROR NullPointerException at line 25

[2025-06-23 03:33:00] WARN Low memory warning

**Development Notes**


During development, I had to:

- Relearn how BufferedReader and FileReader work together to read external files line by line
- Understand how to use the Pattern and Matcher classes to apply regex and extract specific parts of each log entry
- Think critically about how to group similar error messages, and design basic logic to cluster related issues
- Test the program with different log formats and file paths to make sure it handled user input reliably


Thank you for reading!
