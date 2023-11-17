package com.example.RegistrationService.model;

/**
 * LogMessage class
 * 
 * Represents a log message after each call of the provided services.
 * 
 * @author Hamza Ennaoui
 * 
 */
public class LogMessage {
    
    private String input;
    private String output;
    private long processingTime; // ms

    /**
     * Constructs a LogMessage with the specified input, output, and processing time.
     * 
     * @param input The input data
     * @param output The output data
     * @param processingTime The processing time in milliseconds
     */
    public LogMessage(String input, String output, long processingTime) {
        this.input = input;
        this.output = output;
        this.processingTime = processingTime;
    }

    /**
     * Get the formatted log message.
     * 
     * @return The formatted log message containing input, output, and processing time
     */
    public String getMessage() {
        return String.format(
            """
                {
                    input: %s,
                    output: %s,
                    processing time: %.2f seconds
                }
            """, input, output, processingTime / 1000f);
    }

    // Getters and setters

    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }
    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        this.output = output;
    }
    public long getProcessingTime() {
        return processingTime;
    }
    public void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }

    
}
